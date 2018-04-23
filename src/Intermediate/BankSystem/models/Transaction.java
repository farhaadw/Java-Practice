package Intermediate.BankSystem.models;

import java.util.Date;

/**
 *
 * @author farhaadwasim
 */
public class Transaction {
    
    Long transactionId;
    Account accountReference = null;
    String transactionName;
    Date transactionDate;
    Double amount;
    Type type;
    String reference;
    String description;

    public Transaction(Long transactionId, String transactionName, Date transactionDate, Double amount, Type type, String reference, String description) {
        this.transactionId = transactionId;
        this.transactionName = transactionName;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.type = type;
        this.reference = reference;
        this.description = description;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(Account accountReference) {
        this.accountReference = accountReference;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", accountReference=" + accountReference + ", transactionName=" + transactionName + ", transactionDate=" + transactionDate + ", amount=" + amount + ", type=" + type + ", reference=" + reference + ", description=" + description + '}';
    }
    
}
