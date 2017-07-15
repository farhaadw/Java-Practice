/**
 * Prime number is number divisible by 1 and number.
 */
package basic;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        isPrimeAlternative();
    }

    public static void isPrime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int no = sc.nextInt();
        int count = 0;

        for (int j = 2; j < no; j++) {
            for (int i = 1; i <= no; i++) {
                double division = (double) j / i;
                double rounded = Math.ceil(division);

                if (division == rounded) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(j);
            }
            count = 0;
        }
    }

    public static void isPrimeAlternative() {
        for (int j = 2; j < 100; j++) {
            int count = 0;
            int no = j;
            for (int i = 1; i <= no; i++) {
                int divide = (int) no % i;
                if (divide == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(j);
            }
        }
    }
}
