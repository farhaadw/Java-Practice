package Intermediate.BankSystem;

import java.util.List;

/**
 *
 * @author farhaadwasim
 */
public class Account {
    
    private Customer customer;
    private List<Transaction> transactions;
    private double balance;

    public Account(Customer customer, List<Transaction> transactions, double balance) {
        this.customer = customer;
        this.transactions = transactions;
        this.balance = balance;
    }
    
    public Account(){
        
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
    
    
    
    
}
