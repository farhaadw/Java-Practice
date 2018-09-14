package intermediate.BankSystem.service;

import intermediate.BankSystem.model.Account;

public interface IAccount {
	
	Account getAccount(String accountId);
	
	boolean isAccountActive(String accountId);
	
	void withdraw();
	
	

}
