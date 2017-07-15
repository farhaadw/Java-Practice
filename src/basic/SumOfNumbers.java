package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class SumOfNumbers {
    
    public static void main(String[] args){
       //factorial();
       //perfectSquare();
        factorOfNo();
    }
    
    public static void sumBetweenOneAndTen(){
        int total = 0; 
        
        for(int i=1; i<=10; i++){
            System.out.println(i);
            total = total + i;
        }
        
        System.out.println("The sum of numbers from 1 to 10 is " + total);   
    }
    
    public static void factorial(){
        int no = 5;
        int fact = 1;
        
        for(int i=1; i<=no; i++){
            fact = fact * i;
        }
        
        System.out.println(fact);
     }
    
    public static void perfectSquare(){
        double root = 0; 
        
        for(int i=1; i <= 100; i ++){
            
            int no = i;
            root = Math.sqrt(no);
            
            if(root == Math.ceil(root)){
                System.out.println(no + " - Perfect square ");
            }
        }
    }
    
    public static void powerOfNo(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base number: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent ");
        int exponent = sc.nextInt();
        int power = 0; 
        
       
    }
    
    public static void factorOfNo(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Get factor of number: ");
        int no = sc.nextInt();
        
        List<Integer> factors = new ArrayList<Integer>();
        
        for(int i =1; i<=no; i++){
           
            double answer = (double) no / i;
            double rounded = Math.ceil(answer);

            if(rounded == answer){
                factors.add(i);
            }
            
        }
        
        System.out.println("\nThe factors of the number are: ");
        
        for(int i = 0; i < factors.size(); i ++){
            System.out.println(factors.get(i));
        } 
    }
}
