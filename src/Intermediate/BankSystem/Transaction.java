package Intermediate.BankSystem;

import java.util.Date;

/**
 *
 * @author farhaadwasim
 */
public class Transaction {
    
    private String uuid;
    private Account accountReference;
    private String transactionName;
    private Date transactionDate;
    private Double amount;
    private Type type;
    private String reference;
    private String description;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
    
}
