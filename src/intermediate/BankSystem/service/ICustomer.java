package intermediate.BankSystem.service;

import java.util.List;

import intermediate.BankSystem.model.Customer;

public interface ICustomer {
	
	/**
	 * Method to check if customer is active
	 * @param customer
	 * @return
	 */
	Boolean isCustomerActive(Customer customer);
	
	/**
	 * Method to get customer by username
	 * @param username
	 * @return
	 */
	Customer getCustomerByUsername(final String username);
	
	/**
	 * Method to get all customers
	 * @return list of customers
	 */
	List<Customer> getAllCustomers();

}
