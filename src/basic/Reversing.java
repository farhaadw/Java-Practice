package basic;

import java.util.Scanner;

public class Reversing {

    public static void main(String[] args) {
        reverseNumber();
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
}
