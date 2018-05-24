package Intermediate.BankSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/*
 TODO write description text here
*/
public class BankMachine {

    private static int tries = 0;
    private static boolean accountLocked = false;
    private static List<Customer> customers = new ArrayList<Customer>();
    private static Customer currentCustomer;
    // keep the bank machine running 
    private static boolean runBank = false;
           
    static Scanner sc = new Scanner(System.in);
           
    public static void main(String[] args) {
       System.out.println("Welcome to the SimpleATM!");
       boolean login = true;
        
       // test customer 
       Customer customer = new Customer();
       customer.setName("farhaad");
       customer.setPassword("password");
       customer.setCustomerId(generateCustomerId("farhaad"));
       customer.setAccount(new Account(customer, new ArrayList<Transaction>(), 100.00));
       customers.add(customer);
       
       do{   
         loginOptions();
         System.out.print("Select a login option: ");
         int loginOption = sc.nextInt();
         while(loginOption != 1 && loginOption != 2){
            System.out.print("Select a correct login option: ");
            loginOption = sc.nextInt();
         }
         if(loginOption == 1){
           login();
         }else if(loginOption == 2){
           createAccount();
         }
         welcomeCustomer();
         if(runBank){
           showMenu();
         }
         login = false;
         while(runBank){
           System.out.print("select an option: ");
           int choice = sc.nextInt();
           if(choice == 1){
              System.out.println("Your balance is " + currentCustomer.getAccount().getBalance());
              anotherOption();
           }else if(choice == 2){
               System.out.println("How much do you want to withdraw? ");
               double amount = sc.nextDouble();
               double currentBalance = currentCustomer.getAccount().getBalance();
               if(amount > currentBalance){
                   System.out.println("You do not have enough funds to widthdraw");
               }else{
                   double updatedBalance = currentBalance - amount;
                   updateBalance(updatedBalance);
                   addTransaction(amount, Type.WITHDRAW);
               }
               anotherOption();
           }else if(choice == 3){
               getTransactions();
               anotherOption();
           }else if(choice == 4) {
               displayUserProfile();
               anotherOption();   
           }else if(choice == 5) {
               System.out.println("\nThank you for banking with us " + currentCustomer.getName() + "!"
                       + " Hope to see you soon");
               updateCustomer(currentCustomer);
               runBank = false;
               login = true;
           }else if(choice == 6){
               System.out.println("Thank you for using SimpleATM");
               runBank = false;
           }else{
               System.out.print("Incorrect option. Try again: ");
               choice = sc.nextInt();
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
            String pass = sc.next();
            Customer customer = successfulLogin(username, pass);
            if(!customer.getName().isEmpty() && !customer.getPassword().isEmpty()){
                currentCustomer = customer;
                loggedIn = true;
                runBank = true;
                tries = 0; 
            }else{
                System.out.println("Incorrect username or password. Try again");
                tries++;
            }
            if(tries == 3){
                // add functionality for resetting password
            }   
        }while(!loggedIn);
        return loggedIn;
    }

    public static Customer successfulLogin(String username, String password) {
        for(Customer user : customers){
           if(user.getName().equals(username) && user.getPassword().equals(password)){
               return user;
           }
        }
        return new Customer();
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
                   if(customer.getName().equals(username)){
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
       customer.setName(username);
       customer.setPassword(password);
       customer.setCustomerId(generateCustomerId(username));
       customer.setAccount(new Account(customer, new ArrayList(), 100.00));
       customers.add(customer);
       currentCustomer = customer;
       runBank = true;
    }
    
    private static void updateCustomer(Customer current){
        // update the customer array on sign out.
        // this is to persist the information if customer signs back in
        // will update to store to a file to persist this information in future
        for(Customer customer : customers){
            if(customer.getName().equals(current.getName())){
                customer = current;
            }
        }
    }
    
    public static void updateBalance(double balance){
        currentCustomer.getAccount().setBalance(balance);
        System.out.println("Your balance is now " + balance);
    }
    
    public static void addTransaction(double amount, Type type){
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        Account account = currentCustomer.getAccount();
        account.getTransactions().add(new Transaction(dt1.format(new Date()), amount, type));
    }
    
    public static void getTransactions(){
        List<Transaction> transactions = currentCustomer.getAccount().getTransactions();
        if(transactions.isEmpty()){
            System.out.println("No transactions to display!");
        }else{ 
            System.out.println("\n## Transactions ##");
            for(Transaction tr : transactions){
                System.out.println("| Date: " + tr.getDate() + " | Withdrawn: " + 
                  "£" + tr.getAmount() + " | Type: " + tr.getType());
            } 
        }
   }
    
    public static void printTransactions(String name){
        // write transactions to a file 
        String fileName = name;
        try{
            // default encoding 
            FileWriter fileWriter = new FileWriter(fileName);
            
            // wrap in buffered writer
            BufferedWriter bufferedWriter = 
                    new BufferedWriter(fileWriter);
            
            bufferedWriter.write("Transactions Summary");
            bufferedWriter.newLine();
           
            for(Transaction tr : currentCustomer.getAccount().getTransactions()){
                bufferedWriter.write("| Date: " + tr.getDate() + " | ");
                if(tr.getType().equals(Type.WITHDRAW)){
                  bufferedWriter.write("Withdrawn: " + tr.getAmount() + " | ");   
                }else if(tr.getType().equals(Type.DEPOSIT)){
                  bufferedWriter.write("Deposit: " + tr.getAmount() + " | ");
                }
                bufferedWriter.write("Type: " + tr.getType() + " | ");
                bufferedWriter.newLine();
            }
            System.out.println("Written to file " + name);
            bufferedWriter.close();
        }catch(IOException e){
            System.out.println(
                    "Error writing file " + fileName);
        }
    }
      
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
    
    public static void showMenu() {
        System.out.println("\n");
        System.out.println("==== SimpleATM =====");
        System.out.println("");
        System.out.println("========================");
        System.out.println("| [1]  Check Balance   |");
        System.out.println("| [2]  Withdrawal      |");
        System.out.println("| [3]  Transactions    |");
        System.out.println("| [4]  My Profile         |");
        System.out.println("| [5]  Sign out        |");
        System.out.println("| [6]  Exit            |");
        System.out.println("========================");
        System.out.println("");
    }
    
    public static void loginOptions(){
        System.out.println("");
        System.out.println("SimpleATM - Login options");
        System.out.println("========================");
        System.out.println("| [1]  Sign In          |");
        System.out.println("| [2]  Create account   |");
        System.out.println("========================");
        System.out.println("");
    }
    
    public static void welcomeCustomer(){
        System.out.println("\n### Welcome " + currentCustomer.getName() + " ###");;
    }
    
    public static void displayUserProfile(){
        System.out.println("\n## Your profile ##");
        System.out.println("Id: " + currentCustomer.getCustomerId());
        System.out.println("Name: " + currentCustomer.getName());
        System.out.println("\n");
    }
   
}