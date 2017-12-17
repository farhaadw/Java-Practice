
package Intermediate.BankSystem;

/**
 *
 * @author farhaadwasim
 */
public class Customer {
    
    private String name = "";
    private String password = "";
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
   
}
