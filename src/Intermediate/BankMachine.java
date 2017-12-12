/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediate;

import java.util.Scanner;

public class BankMachine {

    private static String accountName = "farhaad";
    private static String correctPass = "password";
    private static int tries = 0;
    private static boolean accountLocked = false;
    private static double currentBalance = 0;
    private int[] transactions = new int[10];
  
   
    public static void main(String[] args) {

        // login to account
        login();
        showMenu();
    }

    public static boolean login() {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        do {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            loggedIn = successfulLogin(username, pass);
            if(loggedIn){
                System.out.println("Welcome " + accountName);
                tries = 0; 
            }else{
                System.out.println("Incorrect username or password. Try again");
                tries++;
            }
            if(tries >= 3){
                // add functions to reset password 
                accountLocked = true;
            }
        }while(!loggedIn);
    
        return loggedIn;
    }

    public static void resetPin() {

    }

    public static boolean successfulLogin(String username, String password) {
        if(username.equals(accountName) && password.equals(correctPass)){
            return true;
        }
        return false;
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== SimpleATM =====");
        System.out.println("");
        System.out.println("========================");
        System.out.println("| [1]  Check Balance   |");
        System.out.println("| [2]  Withdrawal      |");
        System.out.println("| [2]  Transactions    |");
        System.out.println("| [4]  Exit            |");
        System.out.println("========================");
        System.out.println("");

    }

}
