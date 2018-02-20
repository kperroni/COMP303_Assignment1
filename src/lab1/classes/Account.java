package lab1.classes;
// Account.java
// Represents a bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance)
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
   } // end Account constructor

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN)
   {
	   return userPIN == this.pin;

   } // end method validatePIN
   
   // returns available balance
   public double getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   // credits an amount to the account
   public void deposit(double amount)
   {
      this.availableBalance += amount; // add to total balance
   } // end method credit

   // withdraws an amount from the account
   public void withdraw(double amount)
   {
      this.availableBalance -= amount; // subtract from available balance
   } // end method withdraw

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account