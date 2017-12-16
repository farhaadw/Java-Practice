package Intermediate.BankSystem;

/**
 *
 * @author farhaadwasim
 */
public class Transaction {
    
    String date;
    Double amount;
    Type type;
    
    public Transaction(String date, Double amount, Type type){
        this.date = date;
        this.amount = amount;
        this.type = type;
       
    }
    
    public Transaction(){
        
    }

    public String getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
}
