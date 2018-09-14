package intermediate.BankSystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author farhaadwasim
 */
public class Account {
    
    private String uuid;
    private Customer customer;
    private List<Transaction> transactions = new ArrayList<Transaction>();
    private double balance;
    private Date openedDate;
    private float interestRate;

    public Account(Customer customer, List<Transaction> transactions, double balance) {
        this.customer = customer;
        this.transactions = transactions;
        this.balance = balance;
    }
    
    public Account(Customer customer) {
        this.customer = customer;
        this.balance = 0.00;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
          
}
