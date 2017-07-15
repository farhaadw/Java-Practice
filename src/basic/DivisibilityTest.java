package basic;

import java.util.Scanner;

public class DivisibilityTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int no1 = sc.nextInt();
        System.out.print("Enter number 2: ");
        int no2 = sc.nextInt();

        if (no1 > no2) {
            if (no1 % no2 == 0) {
                System.out.println("The numbers are divisible");
            } else {
                System.out.println("The numbers are not divisible");
            }
        } else {
            if (no2 % no1 == 0) {
                System.out.println("The numbers are divisible");
            } else {
                System.out.println("The numbers are not divisible");
            }
        }

    }

}
