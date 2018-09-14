package intermediate.BankSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import intermediate.BankSystem.factory.CustomerFactory;
import intermediate.BankSystem.model.Customer;
import intermediate.BankSystem.service.ICustomer;
import intermediate.BankSystem.service.impl.CustomerServiceImpl;

/**
 * The Console-Based Bank Machine Application
 * @author farhaadwasim
 *
 */
public class BankMachine {
	
	private Map<Integer, String> menuOptions;
    Scanner scanner;
    static boolean runningBank = true;
   
    public BankMachine(){
    	scanner = new Scanner(System.in);
    }
    
    public void runBank(){
   
    	System.out.println("Welcome to Simple Bank");    
    	
    	do {
    		
	    	try {
				Integer loginOption = displayLoginMenu();
				
				if(loginOption == 1){
					
					
				}else if(loginOption == 2){
					
				}else{
					System.out.println("Select the correct option");
				}
				
			} catch (Exception e) {
				System.out.println("Invalid option, try again.");
			}
    	
    	} while(runningBank); 
    	
    }
    
    
    
    public Integer displayMainMenu() throws Exception {
     	menuOptions = new HashMap<>();
        menuOptions.put(1, "Check Balance");
        menuOptions.put(2, "Check Balance");
        menuOptions.put(3, "Check Balance");
        menuOptions.put(4, "Check Balance");
        menuOptions.put(5, "Exit");
        return promptForOptions(menuOptions);
    }
    
    public Integer displayLoginMenu() throws Exception {
     	menuOptions = new HashMap<>();
        menuOptions.put(1, "Login");
        menuOptions.put(2, "Create Account");
        return promptForOptions(menuOptions);
    }
        
    public Integer promptForOptions(Map<Integer, String> options) throws Exception {
        System.out.println("========================");
        for(Map.Entry<Integer, String> option : menuOptions.entrySet()){
        	System.out.printf("| [%s]  %s%n", option.getKey(), option.getValue());
        }
        System.out.println("========================");
        System.out.print("Select option: ");
        Integer option =  scanner.nextInt();
        return option;
    }
    
    public Customer login(){
    	return null;
    }
    
    public Customer createCustomer(){
    	CustomerFactory customerFactory = new CustomerFactory();
    	System.out.println("Username: ");
    	String username = scanner.next();
    	System.out.println("First Name: ");
    	String firstName = scanner.next();
  
    	Customer customerToCreate = new Customer();
    	customerToCreate.setUsername(username);
    	customerToCreate.setFirstName(firstName);
    	
    	
    	Customer createdCustomer = customerFactory.createCustomer(customerToCreate);
    	return null;
    }
  
} 
