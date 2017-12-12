package simple_games;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class RockPaperScissors {


    static int computerWins = 0;
    static int playerWins = 0;
    static int draws = 0;
    static int currentStreak = 0;
    static int hightestWinStreak = 0;
    static double percentageWin = 0.0;

    public static void main(String[] args) {

        boolean isGamePlaying = false;

        while (!isGamePlaying) {
            Scanner sc = new Scanner(System.in);
            int choice = displayUserChoice();

            if (choice != -1) {
                int computerChoice = displayComputerChoice();
                System.out.println("Computer chose: " + getChoiceInfo(computerChoice));
                String result = getResult(choice, computerChoice);
                updateInformation(result);

                System.out.println("Do you want to continue playing? (enter Y for Yes and N for No)");

                try {
                    String continuePlaying = sc.nextLine();

                    if ((continuePlaying.equalsIgnoreCase("N")) || continuePlaying.equalsIgnoreCase("No")) {
                        isGamePlaying = true;
                        showFinalScore();
                    }

                    if (continuePlaying.equalsIgnoreCase("Y") || continuePlaying.equalsIgnoreCase("Yes")) {
                        System.out.println("");
                    } else {
                        System.out.println("You have not selected a correct option. Have another go..");
                        System.out.println("");
                    }

                } catch (Exception e) {
                    System.out.print("Try again ...");
                }
            }
        }
    }

    public static void updateInformation(String result) {

        if (result.equalsIgnoreCase("D")) {
            draws++;
            currentStreak = 0;
        } else if (result.equalsIgnoreCase("W")) {
            playerWins++;
            currentStreak++;
        } else if (result.equalsIgnoreCase("L")) {
            computerWins++;
            currentStreak = 0;
        }

        if (currentStreak > hightestWinStreak) {
            hightestWinStreak = currentStreak;
        }
        
        float total = (float) draws + playerWins + computerWins;
        float playerWin = (float) playerWins; 
        percentageWin = Math.round((float) playerWin / total * 100);   
    }

    public static void showFinalScore() {
        System.out.println("");
        System.out.println("======= Final Score =======");
        System.out.println("Player Wins " + playerWins);
        System.out.println("Computer Wins " + computerWins);
        System.out.println("Draws " + draws);
        System.out.println("Percentage Win " + percentageWin + "%");
        System.out.println("Win Streak " + currentStreak);
        System.out.println("Higest Win Streak " + hightestWinStreak);
        System.out.println("============================");
        System.out.println("");
    }

    public static String getResult(int choice, int computerChoice) {
        String result = "";
        if (choice == computerChoice) {
            // its a draw 
            System.out.println("It's a draw");
            return "D";
        } else if (choice == 1 && computerChoice == 3 || choice == 2 && computerChoice == 1
                || choice == 3 && computerChoice == 2) {
            System.out.println("You win");
            // player wins
            return "W";
        } else if (computerChoice == 1 && choice == 3 || computerChoice == 2 && choice == 1
                || computerChoice == 3 && choice == 2) {
            System.out.println("Computer wins");
            // computer wins
            return "L";
        }
        return result;
    }

    public static int displayUserChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select: 1 for rock, 2 for paper, 3 for scissors ");

        try {

            int choice = sc.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println("You chose: " + getChoiceInfo(choice));
                return choice;
            } else {
                System.out.println("Please enter 1, 2 or 3");
            }

        } catch (Exception e) {
            System.out.println("Please enter letter");
        }

        return -1;
    }

    public static int displayComputerChoice() {
        Random ran = new Random();
        int randomNum = (int) ran.nextInt((3 - 1) + 1) + 1;
        return randomNum;
    }

    public static String getChoiceInfo(int choice) {
        String name = "";
        switch (choice) {
            case 1:
                name = "Rock";
                break;
            case 2:
                name = "Paper";
                break;
            case 3:
                name = "Scissors";
                break;
        }
        return name;
    }

}
