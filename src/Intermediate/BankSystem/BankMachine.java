package Intermediate.BankSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankMachine {

    private static String accountName = "farhaad";
    private static String correctPass = "password";
    private static int tries = 0;
    private static boolean accountLocked = false;
    private static double currentBalance = 100.00;
    private static List<Transaction> transactions = new ArrayList<Transaction>();
    // keep the bank machine running 
    private static boolean runBank = true;
           
    static Scanner sc = new Scanner(System.in);
           
    public static void main(String[] args) {
       System.out.println("Welcome to the bank machine!");
      
       login();
       showMenu();
       
       while(runBank){
           System.out.print("select an option: ");
           int choice = sc.nextInt();
           if(choice == 1){
              System.out.println("Your balance is " + currentBalance);
              anotherOption();
           }else if(choice == 2){
               System.out.println("How much do you want to withdraw? ");
               double amount = sc.nextDouble();
               if(amount > currentBalance){
                   System.out.println("You do not have enough funds to widthdraw");
                   
               }else{
                   currentBalance = currentBalance - amount;
                   System.out.println("Your balance is now " + currentBalance);
                   addTransaction(amount, Type.WITTHDRAW);
               }
               anotherOption();
           }else if(choice == 3){
               getTransactions();
               anotherOption();
           }else if(choice == 4) {
               System.out.println("Thank you for using SimpleATM");
               runBank = false;
           }else{
               System.out.print("Incorrect option. Try again: ");
               choice = sc.nextInt();
           }
       }
    }

    public static boolean login() {
        boolean loggedIn = false;
        do {
            System.out.print("Enter Username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String pass = sc.next();
            loggedIn = successfulLogin(username, pass);
            if(loggedIn){
                System.out.println("Welcome " + accountName);
                tries = 0; 
            }else{
                System.out.println("Incorrect username or password. Try again");
                tries++;
            }
            if(tries == 3){
                 System.out.println("You account is locked! (Reset username or password)");
                 accountLocked = true;
                 while(accountLocked){
                     System.out.println("U for username or P for password");
                     String reset = sc.next();
                     if(reset.equalsIgnoreCase("u")){
                         System.out.print("New username: ");
                         accountName = sc.next();
                         accountLocked = false;
                         tries = 0;
                     }else if(reset.equalsIgnoreCase("p")){
                         System.out.print("New password: ");
                         correctPass = sc.next();
                         accountLocked = false;
                         tries = 0; 
                     }else{
                         System.out.println("Incorrect option. Try Again");
                     }
                 }
            }   
        }while(!loggedIn);
        return loggedIn;
    }

    public static boolean successfulLogin(String username, String password) {
        if(username.equals(accountName) && password.equals(correctPass)){
            return true;
        }
        return false;
    }
    
    public static void addTransaction(double transaction, Type type){
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        transactions.add(new Transaction(dt1.format(new Date()), transaction, type));
    }
    
    public static void getTransactions(){
        for(Transaction tr : transactions){
            System.out.println("Date: " + tr.getDate() + " Withdraw " + 
                    tr.getAmount() + " Type " + tr.getType());
        }
    }
    
    public static void anotherOption(){
          System.out.print("Another option? (Y/N) ");
          String option = sc.next();
          while((!option.equalsIgnoreCase("y")) && (!option.equalsIgnoreCase("n"))){
             System.out.print("You must enter Y or N ");
             option = sc.next();
          }
          if(option.equalsIgnoreCase("y")){
              runBank = true;
              return;
          }
          System.out.println("Thank you for using SimpleATM");
          runBank = false;
    }
    
    public static void showMenu() {
        System.out.println("\n");
        System.out.println("==== SimpleATM =====");
        System.out.println("");
        System.out.println("========================");
        System.out.println("| [1]  Check Balance   |");
        System.out.println("| [2]  Withdrawal      |");
        System.out.println("| [3]  Transactions    |");
        System.out.println("| [4]  Exit            |");
        System.out.println("========================");
        System.out.println("");
    }
}
