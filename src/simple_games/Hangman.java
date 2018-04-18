/**
 * Write a program to play a word-guessing game like Hangman.

It must randomly choose a word from a list of words.
It must stop when all the letters are guessed.
It must give them limited tries and stop after they run out.
It must display letters they have already guessed (either only the incorrect guesses or all guesses).
 */
package simple_games;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author farhaad
 */
public class Hangman {
    
    /**
     *  List to hold the random words
     */
    static List<String> words = new ArrayList<String>();
    
    /**
     *  List to hold the ramdom words that have already been chosen
     */
    static List<String> chosenWords = new ArrayList<String>();
    
    /**
     *  Current random word in-play
     */
    static String currentRandomWord = "";
    
    /**
     * Current random word as asterisks displayed to user
     */
    static String currentRandomWordAsterisks = ""; 
    
    /**
     *  Path to the Hangman-Words.text file
     */
    static String filePath = "src/simple_games/Hangman-Words.txt";
    
    /**
     *  Variable to keep the game running
     */
    static boolean isGameRunning = true;
        
    
    /**
     * Add words to list on startup
     */
    static {
        addWordsToList();
    }
    
    public static void main(String[] args){
        playGame();
    }

    /**
     *  Method to add random words to list
     */
    public static void addWordsToList(){
        try {
            // Read file and to list
            readTextFile();
        } catch (IOException ex) {}
        // Could not read from file, add them programically
        if(words.isEmpty()){
            addRandomWords();
        }
        // Shuffle the words in list
        Collections.shuffle(words);
    }
    
    /**
     *  Method to read Hangman-Words.txt file and add to list
     */
    public static void readTextFile() throws IOException{
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(filePath));
            // Each line
            String line;
            while ((line = br.readLine()) != null) {
                // Add word to array list
                // TODO add some validation to words added
                if(line.length() >= 6){
                    words.add(line.trim());   
                }
            }
        } finally {
            if (br != null) {
                 br.close();
             }
        }
    }
    
    /**
     * Add random words to list programmically
     */
    public static void addRandomWords(){
        String[] wordsList = {
           "communicated", "absolutely"
        };
        for(String word : wordsList){
            if(word.length() > 6){
                words.add(word);   
            }
        }
    }
    
    /**
     * Randomly choose a word from list
     * Return true if word successfully retrieved,
     * False if no more words left to display in list
     */
    public static boolean getRandomWord(){
        currentRandomWord = "";
        words.removeAll(chosenWords);
        Random random = new Random();
        if(words.size() > 0){
            currentRandomWord = words.get(random.nextInt(words.size()));
            chosenWords.add(currentRandomWord);
            return true;
        }
        return false;
    }
    
    /**
     * Proccess users guess by checking if the word contains the 
     * charachter
     */
    public static String processUsersChoice(String word) {
         char chosenChar = word.charAt(0);        
         String displayedWord = "";
         
         for(int i = 0; i < currentRandomWord.length(); i++){
             char currentChar = currentRandomWord.charAt(i);
             if(currentChar == chosenChar){
                  currentRandomWordAsterisks += currentChar + " ";
             }else{
                 currentRandomWordAsterisks += " _ ";
             }
         }
        
         displayedWord = currentRandomWordAsterisks;
         return displayedWord;
    }
    
    /**
     * 
     */
    public static void playGame(){
        
        // While the game is still running
        while(isGameRunning){            
            Scanner scanner = new Scanner(System.in);
            // Retrieve random word from list
            boolean currentWordExists = getRandomWord();
            // Display initial asterisks
            if(!currentWordExists){
                // Exit the game!
                System.out.println("There is no words left to display!");
                isGameRunning = false;
            }else{
                System.out.print("Word: ");
                for(int i = 0; i < currentRandomWord.length(); i++){
                    currentRandomWordAsterisks += " _ "; 
                }
                System.out.println(currentRandomWordAsterisks);
            }
            // The hanngman word that is displayed to user
            String wordDisplayed = "";
            // While there is a word to display
            while(currentWordExists){
                // Proccess users request
                System.out.print("\nPick a word: ");
                String chosenChar = scanner.next();
                if(chosenChar.length() > 1 || chosenChar.equals("")){
                    // TODO FiX
                    System.out.println("You must specify 1 charachter only, try again: ");
                    chosenChar = scanner.next();
                }
                wordDisplayed =  processUsersChoice(chosenChar);
                System.out.println(wordDisplayed);
            }
        }
    }    
 }
