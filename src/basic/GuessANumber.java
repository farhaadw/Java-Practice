package basic;

import java.util.Scanner;

public class GuessANumber {

    public static final void main(String[] args) {
        
      double randomNumber = 10;     
      int chosenNumber;         
      int numberOfTries = 0;  
      boolean isSuccessful = false; 
 
      Scanner in = new Scanner(System.in);

      while (!isSuccessful) {
         ++numberOfTries;
         System.out.print("Enter your guess between 0 and 100: ");
         chosenNumber = in.nextInt();
         if (chosenNumber == randomNumber) {
            System.out.println("Congratulation");
            isSuccessful = true;
         } else if (chosenNumber < randomNumber) {
            System.out.println("Try higher");
         } else {
            System.out.println("Try lower");
         }
      }
      
      System.out.println("You got in " + numberOfTries +" trials");    
    }
}
