package intermediate.BankSystem.model;

public class CachedCustomer {

	private Customer currentCustomer;

	private Customer previousCustomer;

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public Customer getPreviousCustomer() {
		return previousCustomer;
	}

	public void setPreviousCustomer(Customer previousCustomer) {
		this.previousCustomer = previousCustomer;
	}

}
