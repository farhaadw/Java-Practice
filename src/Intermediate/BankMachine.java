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

        enterPin();

        if (accountLocked == true) {
            System.out.println("We are unable to login you in..");
            resetPin();
        }

        showMenu();

    }

    public static boolean enterPin() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        boolean loggedIn = successfulLogin(pass, correctPass);

        while (!pass.equals(correctPass)) {
            System.out.println("Wrong Password. Enter password again ...");
            pass = sc.nextLine();

            if (tries == 3) {
                System.out.println("You are locked out.");
                accountLocked = true;
                break;
            }

            if (successfulLogin(pass, correctPass)) {
                loggedIn = true;
                break;
            }

            tries++;
        }

        if (loggedIn == true) {
            System.out.println("Welcome " + accountName);

        }

        return loggedIn;
    }

    public static void resetPin() {

    }

    public static boolean successfulLogin(String pass, String correctPass) {
        if (pass.equals(correctPass)) {
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

    public static void validateChoice() {

    }

}
