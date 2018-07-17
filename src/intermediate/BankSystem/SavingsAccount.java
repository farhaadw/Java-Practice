package intermediate.BankSystem;

import java.util.Date;
import java.util.List;

public class SavingsAccount extends Account {

    public SavingsAccount(Customer customer, List<Transaction> transactions, 
                                        Double balance, Date openedDate, float interestRate) {
        super(customer, transactions, balance);
    }

    public SavingsAccount(Customer customer, 
                                List<Transaction> transactions, double balance) {
        super(customer, transactions, balance);
    }
    
}