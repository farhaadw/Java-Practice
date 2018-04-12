package basic;

import java.util.Scanner;

public class Reversing {

    public static void main(String[] args) {
        countOccurances();
    }

    public static void reverseNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick a number ");
        int num = sc.nextInt();
        String finalNum = "";
        
        while(num != 0){
            int lastNum = num % 10;
            finalNum = finalNum + lastNum;
            num = num / 10;
        }
        System.out.println("Reversed num is " + finalNum);
    }
    
    
    public static void reverseString(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick a string ");
        String str = sc.next();
        
        String reversed = "";
        
        for(int i = str.length()-1 ; i >= 0; i--){
            reversed += str.charAt(i);
        }
        
        System.out.println(reversed);
        
        StringBuilder builder = new StringBuilder(str).reverse();
        
        System.out.println(builder);
    }
    
    public static void countOccurances(){
        // Count most occurances of a char in a string
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick a string ");
        String str = sc.next();
       
        int totalOcc = 0;
        char charMost = 0;
        
        for(int i = 0; i < str.length() - 1; i++){
            char currentChar = str.charAt(i);
            int occ = 0;
            if(currentChar == str.charAt(i + 1)){
                occ++;
            }
            if(occ > totalOcc){
                totalOcc = occ;
                charMost = currentChar;
            }
        }
        
        if(charMost == 0){
            System.out.println("No occurances found");
        }else{
            System.out.println("Char with most occurances " + charMost + 
                    " with " + totalOcc + " occurances");
        }
    }
}
