package Intermediate.BankSystem;

import Intermediate.BankSystem.models.Account;
import Intermediate.BankSystem.models.Type;
import Intermediate.BankSystem.models.Transaction;
import Intermediate.BankSystem.models.Customer;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/*
 The BankMachine is a simple console application that allows 
 the user to navigate through various menus allowing them to:
    - Get bank account information
    - Get transaction and statement information
    - Withdraw money from accounts
    - Transfer money between accounts
*/
public class BankMachine {

    // number of tries the customer has had
    private static int tries = 0;
    // check if current customer is locked out
    private static boolean accountLocked = false;
    // list of customers
    private static List<Customer> customers = new ArrayList<Customer>();
    // current customer that is logged in
    private static Customer currentCustomer;
    // keep the bank machine running
    private static boolean runBank = false;
           
    static Scanner sc = new Scanner(System.in);
           
    public static void main(String[] args) {
       System.out.println("=========================");
       System.out.println("Welcome to the SimpleATM!");
       System.out.println("=========================");
       boolean login = true;
       setupTestUser();
       
       do{   
         loginOptionsMenu();  
         int loginOption = getLoginOption();
         if(loginOption == 1){
           login();
         }else if(loginOption == 2){
           createAccount();
         }
         displayHeading("Welcome " + currentCustomer.getUsername());
         if(runBank){
           showMenu();
         }
         login = false;
         while(runBank){
           System.out.print("select an option: ");
           int choice = sc.nextInt();
           
           switch(choice){
               case 1: 
                   displayHeading("Accounts");
                   List<Account> accounts = currentCustomer.getAccounts();
                   if(accounts.isEmpty()){
                       System.out.println("You have no accounts to display");
                   }else{
                       System.out.format("%-15s%-15s%-15s%-15s\n", "Account Id", "Balance", "Type", "Select");
                       for(int i=0; i < accounts.size(); i++){
                           System.out.format("%-15d%-15s%-15s%-15s\n", 
                                   0, "£" + accounts.get(i).getBalance(), "SOMETHING", "[" + (i+1) + "]");                  
                       }
                       System.out.println("");
                   }
                  break;
               case 2:
                   displayHeading("Transactions");
                   break;
               case 3:    
                   displayHeading("Transfer Money");
                   break;
           }
           
       }
     } while(login);
    }

    public static boolean login() {
        boolean loggedIn = false;
        do {
            System.out.print("Enter Username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            Console console = System.console();
            String pass;
            if (console != null) {
                char passwordArray[] = console.readPassword();
                pass = new String(passwordArray);
            }else{
                pass = sc.next();
            }
            Customer customer = successfulLogin(username, pass);
            if(customer != null){
                currentCustomer = customer;
                loggedIn = true;
                runBank = true; 
            }else{
                System.out.println("Incorrect username or password. Try again");
            }
        }while(!loggedIn);
        return loggedIn;
    }

    public static Customer successfulLogin(String username, String password) {
        for(Customer user : customers){
            // TOO find by customer id
           if(user.getUsername().equals(username) && user.getPassword().equals(password)){
               return user;
           }
        }
        return null;
    }
    
    private static void createAccount() {
       boolean validateUsername = false;
       String username = ""; 
       String password = ""; 
       while(!validateUsername){
           System.out.print("Create username: ");
           username = sc.next();
           // user regex match()
           if(!username.isEmpty() &&  
                   (username.length() >= 3  && username.length() <= 10)){
               boolean userExists = false;
               for(Customer customer : customers){
                   if(customer.getUsername().equals(username)){
                       userExists = true;
                       break;
                   }
               }
               if(userExists){
                   System.out.println("The username already exists. Please re-enter a username");
               }else{
                   validateUsername = true;
               }
           }else{
               System.out.println("Please enter a valid username. "
                       + " Remember the username should be between 3 to 10 letters");
           }
       }
       boolean validatePassword = false;
       while(!validatePassword){
           System.out.print("Create password: ");
           password = sc.next();
           if(!password.isEmpty()){
               // use regex to match()
              if((password.length() >= 5 && password.length() <= 10)){
                validatePassword = true;
              }else{
                 System.out.println("Please enter a valid password."
                         + "Remember this must be between 5 and 10 characters");
              }
           }else{
               System.out.println("This password cannot be empty");
           }
       }
       Customer customer = new Customer();
       customer.setUsername(username);
       customer.setPassword(password);
       customer.setCustomerId(generateCustomerId(username));
       //customer.setAccount(new Account(customer, new ArrayList(), 100.00));
       customers.add(customer);
       currentCustomer = customer;
       runBank = true;
    }
    
    private static void updateCustomer(Customer current){
        // update the customer array on sign out.
        // this is to persist the information if customer signs back in
        // will update to store to a file to persist this information in future
        for(Customer customer : customers){
            if(customer.getUsername().equals(current.getUsername())){
                customer = current;
            }
        }
    }
    
    public static void updateBalance(double balance){
        //currentCustomer.getAccount().setBalance(balance);
        //System.out.println("Your balance is now " + balance);
    }
    
    public static void addTransaction(double amount, Type type){
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        //Account account = currentCustomer.getAccount();
        //account.getTransactions().add(new Transaction(dt1.format(new Date()), amount, type));
    }
    
    public static void getTransactions(){
        List<Transaction> transactions = null;
        if(transactions.isEmpty()){
            System.out.println("No transactions to display!");
        }else{ 
            System.out.println("\n## Transactions ##");
            for(Transaction tr : transactions){
                System.out.println("| Date: " + tr.getTransactionDate() + " | Withdrawn: " + 
                  "£" + tr.getAmount() + " | Type: " + tr.getType());
            } 
        }
   }

    public static void setupTestUser(){
       Customer customer = new Customer();
       customer.setUsername("farhaad");
       customer.setFirstName("Farhaad");
       customer.setSurName("Wasim");
       customer.setPassword("password");
       customer.setCustomerId(generateCustomerId(customer.getUsername()));
       List<Account> accounts = new ArrayList<Account>();
       Account account = new Account(Long.MIN_VALUE, customer, null, 0.00, new Date(), 0);
       accounts.add(account);
       customer.setAccounts(accounts);
       customers.add(customer);
    }
    
//    public static void printTransactions(String name){
//        // write transactions to a file 
//        String fileName = name;
//        try{
//            // default encoding 
//            FileWriter fileWriter = new FileWriter(fileName);
//            
//            // wrap in buffered writer
//            BufferedWriter bufferedWriter = 
//                    new BufferedWriter(fileWriter);
//            
//            bufferedWriter.write("Transactions Summary");
//            bufferedWriter.newLine();
//           
//            for(Transaction tr : currentCustomer.getAccount().getTransactions()){
//                bufferedWriter.write("| Date: " + tr.getDate() + " | ");
//                if(tr.getType().equals(Type.WITHDRAW)){
//                  bufferedWriter.write("Withdrawn: " + tr.getAmount() + " | ");   
//                }else if(tr.getType().equals(Type.DEPOSIT)){
//                  bufferedWriter.write("Deposit: " + tr.getAmount() + " | ");
//                }
//                bufferedWriter.write("Type: " + tr.getType() + " | ");
//                bufferedWriter.newLine();
//            }
//            System.out.println("Written to file " + name);
//            bufferedWriter.close();
//        }catch(IOException e){
//            System.out.println(
//                    "Error writing file " + fileName);
//        }
//    }
      
    public static String generateCustomerId(String username){
        return username + UUID.randomUUID().toString().substring(0, 6);
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
    
    public static void showAccountMenu() {
        System.out.println("\n");
        System.out.println("==== SimpleATM =====");
        System.out.println("");
        System.out.println("========================");
        System.out.println("| [1]  Check Balance   |");
        System.out.println("| [2]  Withdrawal      |");
        System.out.println("| [3]  Transactions    |");
        System.out.println("| [4]  My Profile      |");
        System.out.println("| [5]  Sign out        |");
        System.out.println("| [6]  Exit            |");
        System.out.println("========================");
        System.out.println("");
    }
    
    public static void showMenu() {
        System.out.println("\n");
        System.out.println("==== SimpleATM =====");
        System.out.println("");
        System.out.println("========================");
        System.out.println("| [1]  Accounts        |");
        System.out.println("| [2]  Transactions    |");
        System.out.println("| [3]  Transfer Money  |");
        System.out.println("| [4]  My Information  |");
        System.out.println("| [5]  Sign out        |");
        System.out.println("| [6]  Exit            |");
        System.out.println("========================");
        System.out.println("");
    }
    
    /**
     * Method to display heading in console in single line
     */
    public static void displayHeading(String headingName){
        System.out.println("\n### " + headingName + " ###\n");
    }
    
    public static void loginOptionsMenu(){
        System.out.println("");
        System.out.println("SimpleATM - Login options");
        System.out.println("========================");
        System.out.println("| [1]  Sign In         |");
        System.out.println("| [2]  Create account  |");
        System.out.println("========================");
        System.out.println("");
    }
    
    public static void welcomeCustomer(){
        System.out.println("\n### Welcome " + currentCustomer.getUsername() + " ###");;
    }
    
    public static void displayUserProfile(){
        System.out.println("\n## Your profile ##");
        System.out.println("Id: " + currentCustomer.getCustomerId());
        System.out.println("Name: " + currentCustomer.getUsername());
        System.out.println("\n");
    }

    private static int getLoginOption() {
         System.out.print("Select a login option: ");
         int loginOption = 0;
         // Exit the application if number of tries > 3
         int noOfTries = 0;
         boolean correctOption = false;
         while(!correctOption){
             try{
                loginOption = sc.nextInt();
                if(loginOption != 1 && loginOption != 2){
                   System.out.print("Select a correct login option: ");
                }else{
                    correctOption = true;
                }
              }catch(InputMismatchException e){ 
                  System.out.print("Select a correct login option: ");
                  sc.next();
              }
              System.out.println("Number of tries " + ++noOfTries);
         }
         return loginOption;
    }    
}
