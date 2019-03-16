package intermediate.BankSystem.factory;

import intermediate.BankSystem.model.Customer;
import intermediate.BankSystem.service.impl.CustomerServiceImpl;

public class CustomerFactory extends CustomerServiceImpl {
	
	public Customer createCustomer(final Customer oldCustomer){
		Customer customer = null;
		getAllCustomers().add(customer);
		if(validateCustomer(oldCustomer)){
			getAllCustomers().add(customer);
		}
		return customer;
	}
	
	
	public Boolean validateCustomer(Customer customer){
		return null;
	}
	
	
	

}
