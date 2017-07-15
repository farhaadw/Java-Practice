package basic;

import java.util.Scanner;

public class CompoundInterest {
    
    public static void main(String[] args){
        calculateCompoundInterest();
    }
    
    public static void calculateCompoundInterest(){        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter invester amound: ");
        double invested = Double.parseDouble(sc.nextLine());
        System.out.println("Enter invested rate in %:");
        double interest = Double.parseDouble(sc.nextLine());
        System.out.println("Enter number of years: ");
        int years = Integer.parseInt(sc.nextLine());
        
        double compoundInterest = invested * Math.pow(1 + interest, years);
        System.out.println("The compound interest is " + compoundInterest);
    }
    
}
