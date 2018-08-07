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
 
  #Scenario: creating new savings account
    #Given customer details
    #And   valid opening balance
    #When  Valid customer
    #And   opening balance is greater than 500
    #Then create new  Savings Account