package com.company;

import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {
        Scanner keyoard = new Scanner(System.in);

        //Create array of accounts
        Account account [] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(keyoard);
            System.out.println();

            if (choice == 1) {
                account[numAccounts++] = createAccount(keyoard);
            } else if(choice == 2) {
                doDeposit(account, numAccounts, keyoard);
            } else if (choice == 3) {
                doWithdraw(account, numAccounts, keyoard);
            } else if (choice == 4) {
                applyInterest(account, numAccounts, keyoard);
            }
            System.out.println();

        } while(choice != 5);

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

    public static int searchAccount(Account account [], int count, int accountNumber) {
        for (int i = 0; i < count ; i++) {
            if(account[i].getAccountNumber() == accountNumber){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * Function to perform deposit on a selected account
     */

    public static void doDeposit(Account account [], int count, Scanner keyboard){

        //Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0) {
            //search for amount
            System.out.println("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();

            account[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account account [], int count, Scanner keyboard){
        //Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0) {
            //search for amount
            System.out.println("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();

            account[index].withdraw(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account account [], int count, Scanner keyboard) {
        //Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0) {

            //must be instance of savings account
            if (account[index] instanceof SavingsAccount) {
                ((SavingsAccount) account[index]).applyInterest();
            }
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
            }
        }
    }

    private static void doDeposit(Account[] account, int numAccounts, Scanner keyoard) {
    }

    private static int searchAccount(Account[] account, int accountNumber) {
            return 0;
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

    public static int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 4);
         return choice;
    }
}
