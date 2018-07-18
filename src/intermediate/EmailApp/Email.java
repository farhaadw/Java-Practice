package intermediate.EmailApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity;
	private int defaultPasswordLength = 8;
	private String alternativeEmail;
	private String companySuffix = "company.com";
	
	public Email(){
		
	}
	
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		System.out.println("Department set to: " + this.department);
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your random password is " + this.password);
		
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
			
		System.out.println("Email is: " + email);	
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
		return choice;
	}
	
	/* Generate random password from password set */
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@$%";
		char[] password = new char[length];
		for(int i =0; i < length; i++){
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
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