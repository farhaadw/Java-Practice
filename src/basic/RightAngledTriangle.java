package basic;

import java.util.Scanner;

/**
 *
 * Does three lengths form a right angled triangle?
 */
public class RightAngledTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 ");
        int side1 = sc.nextInt();
        System.out.print("Enter side 2 ");
        int side2 = sc.nextInt();
        System.out.print("Enter side 3 ");
        int side3 = sc.nextInt();
        int side1Squared = (side1 * side1);
        int side2Squared = (side2 * side2);
        int side3Squared = (side3 * side3);

        String result = "This does not form a right angle triangle";

        if (side1 > side2 && side1 > side3) {
            if (side2Squared + side3Squared == side1Squared) {
                result = "This is hypotenuse and " + side1 + " is hypotenuse";
            }
        } else if (side2 > side1 && side2 > side3) {
            if (side3Squared + side1Squared == side2Squared) {
                result = "This is hypotenuse and " + side2 + " is hypotenuse";
            }

        } else if (side3 > side1 && side3 > side2) {
            if (side1Squared + side2Squared == side3Squared) {
                result = "This is hypotenuse and " + side3 + " is hypotenuse";
            }
        }

        System.out.println(result);
    }

}
