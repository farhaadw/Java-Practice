package Intermediate.BankSystem.models;

import java.util.List;

/**
 *
 * @author farhaadwasim
 */
public class Customer {
    
    private String customerId;
    private String username;
    private String firstName;
    private String surName;
    private String password;
    private List<Account> accounts;
    private Branch bankBranch;
    
    public Customer(){
        
    }

    public Customer(String customerId, String username, String firstName, String surName, String password, 
                    List<Account> accounts, Branch brankBranch) {
        this.customerId = customerId;
        this.username = username;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.accounts = accounts;
        this.bankBranch = bankBranch;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", username=" + username + ", firstName=" + firstName + ", surName=" + surName + ", password=" + password + ", accounts=" + accounts + ", bankBranch=" + bankBranch + '}';
    }
    
}
