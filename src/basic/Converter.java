package basic;

import java.util.Scanner;

public class Converter {
    
    public static void main(String[] args){
        milesToKms();
        fahrenheitToCelcius();
    }
    
    public static void milesToKms(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter miles you have travelled: ");
        double miles = Double.parseDouble(sc.nextLine());
        double kms =  1.609 * miles; 
        System.out.println("The KMS is " + kms); 
    }
    
    public static void fahrenheitToCelcius(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter tempreture in fahrenheit: ");
      double fahrenheit = Double.parseDouble(sc.nextLine());
      double celcius = (fahrenheit - 32) * 5/9;
      System.out.println("Celcius is " + celcius);
    }
    
    public static void metersToMiles(){
        // convert meters into miles 
    }
    
}
