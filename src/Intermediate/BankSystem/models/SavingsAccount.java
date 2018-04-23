package Intermediate.BankSystem.models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author farhaad
 */
public class SavingsAccount extends Account {

    public SavingsAccount(Long accountNo, Customer customer, List<Transaction> transactions, 
                                        double balance, Date openedDate, float interestRate) {
        super(accountNo, customer, transactions, balance, openedDate, interestRate);
    }

    public SavingsAccount(Customer customer, 
                                List<Transaction> transactions, double balance) {
        super(customer, transactions, balance);
    }
    
}
