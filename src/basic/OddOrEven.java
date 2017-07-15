package basic;

import java.util.Scanner;

/*
Even number is divisible by 2. 
*/
public class OddOrEven {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        if(num % 2 == 0){
            System.out.println("The number is even");
        }else{
            System.out.println("The number is odd");
        }   
    }
}
