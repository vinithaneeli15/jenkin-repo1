package org.cap.service;

import org.cap.dao.AccountDao;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService {
	private AccountDao accountDao;


	public AccountServiceImpl(AccountDao accountDao2) {
		accountDao=accountDao2;
	}


	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Account createAccount(Customer customer, double amount) throws InvalidCustomer,InvalidOpeningBalance{
		if(customer!=null) {
			if(amount>=500) {
				Account account=new Account();
				account.setCustomer(customer);
				account.setOpeningBalance(amount);
				account.setAccountNo(AccountUtil.generateAccountNo());
				boolean flag=accountDao.addAccount(account);
				if(flag)
				    return account;
				else
					return null;
			}else {
				throw new InvalidOpeningBalance("Sorry");
			}
			
		}else {
			throw new InvalidCustomer("Sorry! Customer refers Null!");
		}
	}

}
