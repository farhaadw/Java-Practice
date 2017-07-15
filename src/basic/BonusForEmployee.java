
package basic;

import java.util.Scanner;

public class BonusForEmployee {
    
    public static void main(String[] args){
        calculateBonus();
        calculateBonusAndRise();
    }
    
    public static void calculateBonus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your salary ");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Enter bonus in percentage ");
        double bonus = Double.parseDouble(sc.nextLine());
        double finalSalary = (bonus / 100 * salary) + salary;
        System.out.println("Final salary after bonus is " + finalSalary);
    }
    
    public static void calculateBonusAndRise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("The normal worked hours for the week is 40.");
        System.out.println("");
        
        System.out.print("Enter your worked hours:");
        int workedHours = sc.nextInt();
        System.out.print("Enter hourly rate");
        int hourlyRate = sc.nextInt();
        double pay = 0; 
        
        if(workedHours <= 40){
            pay = workedHours * hourlyRate;
        }else{
            int difference = workedHours - 40;
            double bonusAmount = difference * (0.5 * hourlyRate); 
            pay = (workedHours * hourlyRate) + bonusAmount;
        } 
        System.out.println("Final pay is " + pay);
    }
}
