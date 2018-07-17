package intermediate.EmailApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity;
	private String alternativeEmail;
	
	public Email(){
		
	}
	
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
	}
	
	/* Method to set department */
	private String setDepartment(){
		System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		String choice = "";
		try{
			int depChoice = in.nextInt();
			if(depChoice == 1){
				choice = "sales";
			}else if(depChoice == 2){
				choice = "dev";
			}else if(depChoice == 3){
				choice = "acct";
			}else{
				choice = "none";
			}
		}catch(InputMismatchException e){
			 System.out.println("Invalid option");
			 choice = "none";
		}
		System.out.println("Department set to: " + choice);
		return choice;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}
		
}