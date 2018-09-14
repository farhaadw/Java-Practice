
package intermediate.BankSystem.model;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author farhaadwasim
 */
public class Customer {
        
	/** Unique identifier for customer **/
    private String uuid;
    
    /** Users username **/
    private String username;
    
    /** Users first name **/
    private String firstName;
    
    /** Users last name **/
    private String lastName;
    
    /** Email address **/
    private String emailAddress;
    
    /** MD5 hash of users pin **/
    private byte pinHash[];
    
    /** List of banks the user has **/
    private List<Account> accounts;
    
    /** Attempts the user has when logging in **/
    private int tries;
    
    /** The branch the user is associated with **/ 
    private Branch bankBranch;
        
	public Customer(String uuid, String username, String firstName, String lastName, String emailAddress,
			byte[] pinHash, List<Account> accounts, int tries, Branch bankBranch) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.pinHash = pinHash;
		this.accounts = accounts;
		this.tries = tries;
		this.bankBranch = bankBranch;
	}
	
	public Customer(){
		
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public byte[] getPinHash() {
		return pinHash;
	}
	public void setPinHash(byte[] pinHash) {
		this.pinHash = pinHash;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Branch getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(Branch bankBranch) {
		this.bankBranch = bankBranch;
	}
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	} 	
}
