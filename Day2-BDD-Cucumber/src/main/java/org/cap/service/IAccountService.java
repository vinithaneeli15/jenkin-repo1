package org.cap.service;

import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;

public interface IAccountService {
public Account createAccount(Customer customer,double amount) throws InvalidCustomer, InvalidOpeningBalance;
}
