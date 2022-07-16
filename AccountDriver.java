package com.company;

import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {
        Scanner keyoard = new Scanner(System.in);

        //Create array of accounts
        Account account [] = new Account[10];
    }

    /**
     *
     * @param keyboard
     * @returm choice
     */

    public static int accountMenu(Scanner keyboard){
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Accoumt");

        int choice;
        do {
            System.out.println("Enter Choice");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice >2)

        return choice;
    }

    public int searchAccount(Account account [], int count, int accountNumber) {
        for (int i = 0; i < count ; i++) {

        }
    }

    /**
     *
     * Function to perform deposit on a selected account
     */

    public void doDeposit(Account account [], int count, Scanner keyboard){

        //Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, accountNumber);

    }


    /**
     * Function to create a new Account
     */

    public static Account createAccount(Scanner keyboard){

        CheckingAccount account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.println("Enter Account Number");
        accountNumber = keyboard.nextInt();

        if(choice == 1) { //checking account
            System.out.println("Enter transaction fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else { //Savings account

            System.out.print("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }

        return account;

    }


    /**
     * Menu to display options and get the user's selection
     *
     * @param keyboard
     * @return choice
     */

    public int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Quit");

        int choice;

        do {
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 4);
         return choice;
    }
}
