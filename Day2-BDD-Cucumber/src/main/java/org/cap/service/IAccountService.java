package org.cap.service;


import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;

public interface IAccountService {
public Account createAccount(Customer customer,double amount) throws InvalidCustomer, InvalidOpeningBalance;

public Account findAccountById(int accountNo);

public Account withdraw(int accountNo, double amount) throws AccountNotFound, InsufficientBalance;
public Account updateAccount(int accountNo,double amount);

public Account deposit(int accountNo, double amount) throws AccountNotFound, InsufficientBalance;
}
