package createAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.cap.dao.AccountDao;
import org.cap.dao.AccountDaoImpl;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	private Customer customer;
	private double openingBalance;
	private IAccountService accountService;
	@Mock
	private AccountDao accountDao;
	@Before
	public void  setUp() {
		MockitoAnnotations.initMocks(this);
		customer= new Customer();
		openingBalance=1000;
		//accountDao=new AccountDaoImpl();
		accountService=new AccountServiceImpl(accountDao);
		
	}
	
	@Given("^customer details$")
	public void customer_details() throws Throwable {
	    customer.setFirstName("Tom");
	    customer.setLastName("Jerry");
	    Address address=new Address();
	    address.setDoorNo("11/B");
	    address.setCity("Chennai");
	    customer.setAddress(address);
	    
	}

	@When("^Valid customer$")
	public void valid_customer() throws Throwable {
	   assertNotNull(customer);
	}

	@When("^valid opening balance$")
	public void valid_opening_balance() throws Throwable {
	   assertTrue(openingBalance>=500);
	}

	@Then("^create new Account$")
	public void create_new_Account() throws Throwable {
		
		Account account=new Account();
		account.setAccountNo(1);
		account.setOpeningBalance(1000);
		account.setCustomer(customer);
		Mockito.when(accountDao.addAccount(account)).thenReturn(true);
		
		
	    Account account2=accountService.createAccount(customer, openingBalance);
	    Mockito.verify(accountDao).addAccount(account);
	    assertNotNull(account2);
	    assertEquals(openingBalance, account2.getOpeningBalance(),0.0);
	    assertEquals(1, account2.getAccountNo());
	}
	 
		
		@Given("^Customer details$")
		public void customer_details1() throws Throwable {
			customer=null;
		} 
		@When("^Invalid Customer$")
		public void invalid_Customer() throws Throwable {
		    assertNull(customer);
		}

		@Then("^throw 'Invalid Customer' error message$")
		public void throw_Invalid_Customer_error_message() throws Throwable {
		   try {
			 accountService.createAccount(customer, 3000);  
		   }
		   catch(Exception e) {
			   
		   }
		} 
	@Given("^Customer details and opening balance$")
		public void customer_details_and_opening_balance() throws Throwable {
		    openingBalance=100;
		}

		@When("^Invalid opening balance$")
		public void invalid_opening_balance() throws Throwable {
		    assertTrue(openingBalance<500);
		}

		@Then("^throw 'Insufficient Balance' error message$")
		public void throw_Insufficient_Balance_error_message() throws Throwable {
			 try {
				 accountService.createAccount(customer, openingBalance);  
			   }
			   catch(Exception e) {
				   
			   }
		}	 
	 

}
