package basic;

import java.util.Scanner;

public class ForgetfulMachine {
    
    public static void main(String[] args){
       simpleInput();
       ageIn5Years();
    }
    
    public static void simpleInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me a word");
        System.out.println(sc.nextLine());
        System.out.println("Enter second word");
        System.out.println(sc.nextLine());
        System.out.println("Great, now enter your favourite number?");
        System.out.println(sc.nextInt());
        System.out.println("And your second-favourite number...");
        System.out.println(sc.nextInt());
    }
   
    public static void ageIn5Years(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name?");
        String name = sc.nextLine();
        System.out.println("Hi, " + name + "!");
        System.out.print("How old are you?");
        int age = Integer.parseInt(sc.nextLine());
        int ageIn5 = age + 5;
        System.out.println("Did you know you will be " + ageIn5 + " in 5 years");
    }
}