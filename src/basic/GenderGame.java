/** 
Make a program which displays an appropriate name for a person, 
using a combination of nested ifs and compound conditions. 
 
Ask the user for a gender, first name, last name and age.

If the person is female and 20 or over, ask if she is married. 
If so, display "Mrs." in front of her name. 
If not, display "Ms." in front of her name. 
If the female is under 20, display her first and last name.

If the person is male and 20 or over, display "Mr." in front of his name. 
Otherwise, display his first and last name.
 */
package basic;

import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class GenderGame {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter gender (m/f)");
            String gender = sc.nextLine();
            
            while(!(gender.equalsIgnoreCase("m")) && !(gender.equalsIgnoreCase("f"))){
                System.out.println("Please enter a correct option... M for male and F for female");
                gender = sc.nextLine();
            }
           
            System.out.println("Enter first name");
            String firstName = sc.nextLine();
            
            System.out.println("Enter last name");
            String lastName = sc.nextLine();
            
            System.out.println("Enter age");
            int age = sc.nextInt();
           
            String fullName = "";
            
            if(gender.equalsIgnoreCase("f")){
                if(age > 20){
                    System.out.println("Are you married? (y/n)");
                    String isMarried = sc.nextLine();
                    if(isMarried.equalsIgnoreCase("y")){
                        fullName = "Mrs. " + firstName;             
                    }else{
                        fullName = "Ms. " + firstName;
                    }
                 }else{
                    fullName = firstName + " " + lastName;     
                 }
            }else if(gender.equalsIgnoreCase("m")){
                if(age > 20){
                    fullName += "Mr. " + firstName;
                }else{
                    fullName = firstName + " " + lastName;
                }
            }
            System.out.println("You shall be called " + fullName);
        }
}
