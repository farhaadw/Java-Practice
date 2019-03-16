package intermediate.BankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import intermediate.BankSystem.factory.CustomerFactory;
import intermediate.BankSystem.model.Customer;
import intermediate.BankSystem.model.dto.CustomerResponseDto;
import intermediate.BankSystem.service.ICustomer;
import intermediate.BankSystem.service.impl.CustomerServiceImpl;
import intermediate.BankSystem.validator.CustomerValidator;

/**
 * The Console-Based Bank Machine Application
 * 
 * @author farhaadwasim
 *
 */
public class BankMachine {

	private Map<Integer, String> menuOptions;
	Scanner scanner;
	static boolean runningBank = true;

	public BankMachine() {
		scanner = new Scanner(System.in);
	}

	public void runBank() {

		System.out.println("Welcome to Simple Bank");

		do {
			try {
				int loginOption = displayLoginMenu();

				if (loginOption == 1) {

				} else if (loginOption == 2) {

					boolean accountCreated = false;

					do {
						CustomerResponseDto createAccount = createCustomer();
						
						if (createAccount.hasErrors()) {
							System.out.println(createAccount.getErrors());
						}

					} while (!accountCreated);

				} else {
					System.out.println("Select the correct option");
				}

			} catch (Exception e) {
				System.out.println("Invalid option, try again.");
			}

		} while (runningBank);

	}

	public Integer displayMainMenu() throws Exception {
		menuOptions = new HashMap<>();
		menuOptions.put(1, "Check Balance");
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
		for (Map.Entry<Integer, String> option : menuOptions.entrySet()) {
			System.out.printf("| [%s]  %s%n", option.getKey(), option.getValue());
		}
		System.out.println("========================");
		System.out.print("Select option: ");
		Integer option = scanner.nextInt();
		return option;
	}

	public Customer login() {
		return null;
	}

	public CustomerResponseDto createCustomer() {
		final CustomerFactory customerFactory = new CustomerFactory();
		final CustomerValidator customerValidator = new CustomerValidator();
		final CustomerResponseDto customerResponse = new CustomerResponseDto();
		Customer newCustomer = null;
		
		System.out.println("Username: ");
		final String username = scanner.next();

		boolean doesUserExist = customerValidator.validateUsername(username);
		if (doesUserExist) {
			customerResponse.getErrors().add("Username " + username + " already exists");
			return customerResponse;
		}
		newCustomer = new Customer();
		newCustomer.setUsername(username);
		System.out.println("First Name: ");
		final String firstName = scanner.next();
		newCustomer.setFirstName(firstName);
		customerResponse.getCustomer().setPreviousCustomer(newCustomer);
		customerValidator.validateCustomer(newCustomer, customerResponse);
		if(customerResponse.hasErrors()){
			return customerResponse;
		}
		
		Customer createdCustomer = customerFactory.createCustomer(newCustomer);
		customerResponse.getCustomer().setCurrentCustomer(createdCustomer);
		return customerResponse;
	}


}
