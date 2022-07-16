package com.company;
//Savings Account child class
//has an interest rate
//a method to apply interest - profit
public class SavingsAccount {

    //interest rate
    private double interestRate;
    private double balance;
    private double FEE;


    //Default constructor
    public SavingsAccount() {
        super();
    }

    /**
     * parameter constructor to initialize SavingsAccount
     * with a custom Account Number and interest rate.
     */

    public SavingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    //getter function
    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount added to balance", interest);
        deposit(interest);
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
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }


}
