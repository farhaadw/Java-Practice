package basic;

import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class SquareRoot {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Find out a square root of a number");
        
        System.out.println("Are you ready?");
        String answer = (String) sc.nextLine();
        boolean isReady = !(answer.equalsIgnoreCase("yes"));
        
        while(isReady){
             System.out.println("Let me know when you are ready ...");
             answer = sc.nextLine();         
        }
        
        System.out.println("Now, enter a number to find a square root");
       
        double number = sc.nextDouble();
        
        while(number < 0){
            System.out.println("Please enter a number greater than 0");
            number = sc.nextDouble();
        }
        
        int squareRoot = (int) Math.sqrt(number);
        System.out.println("The square root is " + squareRoot);
 
    }   
}
