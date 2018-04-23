package Intermediate.BankSystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author farhaadwasim
 */
public class Account {
    
    private Long accountNo;
    private Customer customer;
    private List<Transaction> transactions = new ArrayList<Transaction>();
    private double balance;
    private Date openedDate;
    private float interestRate;

    public Account(Long accountNo, Customer customer, List<Transaction> transactions, 
                                double balance, Date openedDate, float interestRate) {
        this.accountNo = accountNo;
        this.customer = customer;
        this.transactions = transactions;
        this.balance = balance;
        this.openedDate = openedDate;
        this.interestRate = interestRate;
    }
    
    public Account(Customer customer,  List<Transaction> transactions, double balance) {
        this.customer = customer;
        this.transactions = transactions;
        this.balance = balance;
    }
    
    /**
     * @return the accountNo
     */
    public Long getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the openedDate
     */
    public Date getOpenedDate() {
        return openedDate;
    }

    /**
     * @param openedDate the openedDate to set
     */
    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }

    /**
     * @return the interestRate
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
    
}
