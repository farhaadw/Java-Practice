package basic;

import java.util.Scanner;

public class BMICalculator {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("IMPERIAL MEASURMENTS");
        System.out.println("1. Mass and Meters");
        System.out.println("2. Inches and Pounds");
        System.out.println("3. Feet and Inches");
        int answer = Integer.parseInt(sc.nextLine());
  
        switch(answer){
            case 1:
                runMassAndMeters();
                break;
            case 2:
                runInchesAndPounds();
                break;
            case 3: 
                runFeetAndInches();
                break;
            default:
                System.out.println("Please select a correct option.");
                 break;
        }
    }
    
    public static void runMassAndMeters(){
        System.out.print("You height in m: ");
        double height = Double.parseDouble(sc.nextLine());
        System.out.print("Your height in kg: ");
        double weight = Double.parseDouble(sc.nextLine());
        double bmi = weight / (Math.pow(height, 2));
        System.out.println("Your BMI is " + bmi);
        displayCategories(bmi);
    }
    
    public static void runInchesAndPounds(){
        // TODO 
    }
    
    public static void runFeetAndInches(){
         // TODO    
    }
    
    public static void displayCategories(double bmi){
        
        System.out.println("");
        System.out.println("=== BMI ====");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal: Between 18.5 and 24.9");
        System.out.println("Overweight: Between 25 and 29.9");
        System.out.println("Obese: Over 30");
        System.out.println("=============");
        System.out.println("");
        
        String result = "You are ";
        if(bmi < 18.5){
            result += " Underweight";
        }else if(bmi < 25){
            result += " Normal (healhy weight)";
        }else if(bmi < 30){
             result += " Overweight";
        }else {
            result += " Obese";
        }
        
        System.out.println(result);
    }
    
}
