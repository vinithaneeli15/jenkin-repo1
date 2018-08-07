@account
Feature: Create New Account
Create new Account for the valid customer details
 Scenario: For valid customer create new Account
  Given customer details
  When  Valid customer
  And   valid opening balance
  Then create new Account
Scenario: For Invalid customer 
 For Invalid customer details throw error message
  Given Customer details
  When Invalid Customer
  Then throw 'Invalid Customer' error message
  
  Scenario: For Invalid Opening Balance 
   Given Customer details and opening balance
   When Invalid opening balance
   Then throw 'Insufficient Balance' error message 

   
	  
	Scenario: Find account details 
   Given account number
   When valid Account number
   Then find account details
   
	Scenario: Withdraw Amount from account  
   Given account number 1 and amount 100
   When Find Account and do withdraw
   Then update the account details 
   
	Scenario: Deposit Amount from account  
   Given account number 1 and amount 100
   When Find Account and do deposit
   Then update the account details 