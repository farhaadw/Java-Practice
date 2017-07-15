package basic;

import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class DecimalToBinary {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int no = sc.nextInt();
        
        StringBuilder build = new StringBuilder();
        
        while(no != 0){    
            int rem = no % 2;
            build.append(rem);
            no = no / 2;
        }
        
        System.out.println(build.reverse().toString());
    }
}