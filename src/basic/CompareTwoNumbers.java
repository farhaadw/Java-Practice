package basic;

import java.util.Scanner;

public class CompareTwoNumbers {
    
    public static void main(String[] args){
        compareNumbers();
    }
    
    public static void compareNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number one: ");
        int no1 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter number two: ");
        int no2 = Integer.parseInt(sc.nextLine());
        
        if(no1 > no2){
            System.out.println(no1 + " is bigger than " + no2);
        }else if(no1 < no2){
            System.out.println(no2 + " is bigger than " + no1);
        }else{
            System.out.println("Both numbers are the same");
        }
    }   
}
