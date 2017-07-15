package basic;

import java.util.Scanner;

/**
 * Improvement
 * 1. Fault in program. 1990 is not a leap year. 
 */
public class LeapYear {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year: ");
        
        int year = sc.nextInt();
        
        if(year % 4 == 0){
            System.out.println("This is a leap year");
        }else{
            System.out.println("This is not a leap year");
        }
        
    }
    
}
