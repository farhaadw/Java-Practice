package intermediate.BankSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import intermediate.BankSystem.model.Customer;
import intermediate.BankSystem.service.ICustomer;

public class CustomerServiceImpl implements ICustomer {

	private static List<Customer> customers = new ArrayList<Customer>();
	
	@Override
	public Boolean isCustomerActive(Customer customer) {
		return null;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
