/**
 * Program to store meter readings.
 * 1. Store and display meter readings (basic).
 * 2. Save to file or store in DB (Intermediate).
 * 3. Convert to OOP (Intermediate)
 * 3. Mechanism to show differences in readings (advanced).
 */
package Intermediate;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeterReadings {

    private static Scanner sc = new Scanner(System.in);
    // show date and reading
    private static Map<String, Double> meterReadings = new HashMap<String, Double>();

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("== Meter Readings ==");
        System.out.println("===================");
        System.out.println("");
        showInstructions();
    }

    public static int showInstructions() {
        System.out.println("Please select your options");

        int answer = 0;
        boolean correctChoice = false;

        do {
            System.out.println("1. Display readings");
            System.out.println("2. Add new reading");
            System.out.println("3. Export reading");

            try {
                answer = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("This is not a number! ");
            }

            if (answer == 1) {
                System.out.println("You selected 1");
                correctChoice = true;
                displayReadings();
            } else if (answer == 2) {
                System.out.println("You selected 2");
                addReading();
                correctChoice = true;
            } else if (answer == 3) {
                System.out.println("You selected 3");
                correctChoice = true;
            } else {
                System.out.println("Please select a correct option!");
            }

        } while (!correctChoice);

        return answer;
    }

    public static int displayReadings() {

        if (meterReadings.isEmpty()) {
            System.out.println("There are no readings to display!");
        } else {
            for (int i = 0; i < meterReadings.size(); i++) {
                System.out.println(i);
            }
        }

        return 1;
    }

    public static int addReading() {

        System.out.println("==== To add a new reading: ====");
        System.out.println("Enter date: (format: 01/03/30)");
        String selectedDate = validateDate(sc.nextLine());
        String addDate = "";

        if (selectedDate.equalsIgnoreCase(":t")) {
            addDate = getTodaysDate();
        } else {

        }

        return 1;
    }

    public static String getTodaysDate() {
        return new Date().toString();
    }

    public static String validateDate(String input) {

        boolean isValid = false;

        while (!isValid) {

            try {
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(2) == '/' && input.charAt(5) == '/') {
                        isValid = true;
                    } else {
                        System.out.print("Please use the format: dd/mm/yyyy");       
                    }
                }
            } catch (Exception e) {
                System.out.print("This is not a valid input. Please try again");
            }

        }
        return input;
    }

}
