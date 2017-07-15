package basic;

import java.util.Scanner;

// improvement 
// 1. Add subtraction, division, multiplication. 
public class DumbCalculator {

    public static void main(String[] args) {
        calculator();
        averageAndDistance();
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        int current, total = 0;
        
        do {
            System.out.println("Type in a number?");
            System.out.println("We will stop adding if you enter 0");
            current = sc.nextInt();
            total = total + current;
            System.out.println("The current total is " + total);
            
        }while(current != 0);
        
    }

    public static void averageAndDistance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Average and distance between two numbers!");
        System.out.println("First number ...");
        int no1 = sc.nextInt();
        System.out.println("Second number ...");
        int no2 = sc.nextInt();
        double average = ((double) no1 + no2) / 2;
        int distance = 0;

        if (no1 > no2) {
            distance = no1 - no2;
        } else {
            distance = no2 - no1;
        }
      
        System.out.println("The average of the two numbers is " + average);
        System.out.println("The distance is " + distance);
    }
}
