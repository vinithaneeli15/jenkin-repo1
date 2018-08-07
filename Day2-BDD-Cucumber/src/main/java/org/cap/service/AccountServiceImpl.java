package org.cap.service;

import org.cap.dao.IAccountDao;
import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService {
private IAccountDao accountDao;
	public AccountServiceImpl(IAccountDao accountDao2) {
	this.accountDao=accountDao2;
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
			}
			else {
				throw new InvalidOpeningBalance("Sorry! Invalid Opening Balance");
			}
			
		}
		else {
			throw new InvalidCustomer("Sorry! Customer refers Null!");
		}
		
	}
	public AccountServiceImpl() {
		super();
	}
	@Override
	public Account findAccountById(int accountNo) {
				return accountDao.findAccountById(accountNo);
	}
	@Override
	public Account withdraw(int accountNo, double amount) throws AccountNotFound, InsufficientBalance {
		Account account=accountDao.findAccountById(accountNo);
	   if(account==null) {
		   throw new AccountNotFound("Sorry! Account does not exit");
		}
	   if(amount>account.getOpeningBalance()) {
		   throw new InsufficientBalance("Sorry! Insufficient Balance");
	   }
		else {
			account.setOpeningBalance(account.getOpeningBalance()-amount);
			updateAccount(accountNo, account.getOpeningBalance());
			return account;
		}
			
	}
	@Override
	public Account updateAccount(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(accountNo, amount);
	}
	@Override
	public Account deposit(int accountNo, double amount) throws AccountNotFound, InsufficientBalance {
		Account account=accountDao.findAccountById(accountNo);
		   if(account==null) {
			   throw new AccountNotFound("Sorry! Account does not exit");
			}
		   if(amount>account.getOpeningBalance()) {
			   throw new InsufficientBalance("Sorry! Insufficient Balance");
		   }
			else {
				account.setOpeningBalance(account.getOpeningBalance()+amount);
				updateAccount(accountNo, account.getOpeningBalance());
				return account;
			}
	}

}
