package com.company;

public  class CheckingAccount extends Account {

    //Default transasction fee
    private static double FEE = 2.5;

    //Default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * parameter constructor to initialize CheckingAccount
     * with a custom Account Number and a Customer Transaction Fee.
     */

    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
        FEE = fee;
    }

    /**
     * Function to deposit funds into account as lomg as
     * the amount parameter is > 0
     *
     * Apply transaction fee for the CheckingAccount
     *
     * @param amount value to be withdrawn
     */

    public void deposit(double amount) {

        //First Check Amount
        if(amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited", amount);

            //Apply transaction fee
            balance -= FEE;
            System.out.printf("Fee %.2f Appied%n", FEE);
            System.out.printf("Current Balance is: %.2%n", balance);
        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount withdrawn must be <= balance
     *
     * @param amount value to be withdrawn
     */

    public void withdraw(double amount) {

        //Same check
        if(amount > 0) {

            if((amount+FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance-=amount;
                balance-=FEE;
                System.out.printf("Fee of %.2 withdrawn from Account%n", amount);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }


}
