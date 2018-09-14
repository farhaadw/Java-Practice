package intermediate.BankSystem.factory;

import intermediate.BankSystem.model.Customer;
import intermediate.BankSystem.service.impl.CustomerServiceImpl;

public class CustomerFactory extends CustomerServiceImpl {
	
	public Customer createCustomer(final Customer oldCustomer){
		validateCustomer(oldCustomer);
		
		Customer customer = new Customer();
		getAllCustomers().add(customer);
		return customer;
	}
	
	
	public Customer validateCustomer(Customer customer){
		return null;
	}
	
	
	

}
