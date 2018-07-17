/**
 * Write a program to play a word-guessing game like Hangman.

It must randomly choose a word from a list of words.
It must stop when all the letters are guessed.
It must give them limited tries and stop after they run out.
It must display letters they have already guessed (either only the incorrect guesses or all guesses).
 */
package simple_games.Hangman;

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
     * Current random word as charachters
     */
    static char[] currentRandomWordDisplayed;
    
    /**
     *  Path to the Hangman-Words.text file
     */
    static String filePath = "src/simple_games/Hangman-Words.txt";
    
    /**
     *  Variable to keep the game running
     */
    static boolean isGameRunning = true;
    
    /**
     *  List of possibly words to add to the words list
     */
    static String[] wordsList = { "communicated", "absolutely" };
        
    
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
           for(String word : wordsList){
            if(word.length() > 6){
                words.add(word);   
            }
           }   
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
     * Randomly choose a word from list
     * Return true if word successfully retrieved,
     * False if no more words left to display in list
     */
    public static boolean getRandomWord(){
        // Remove words that have already been displayed
        words.removeAll(chosenWords);
        // Pick a random word from the list
        Random random = new Random();
        if(words.size() > 0){
            // Get random word from list
            currentRandomWord = words.get(random.nextInt(words.size()));
            // Add to chosen words array
            chosenWords.add(currentRandomWord);
            // Set the random words to display char
            currentRandomWordDisplayed = new char[currentRandomWord.length()];
            // Word has been found
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
         String displayedLine = "";
         
         for(int i = 0; i < currentRandomWord.length(); i++){
             // Current charachter in word 
             char currentChar = currentRandomWord.charAt(i);
             // Current charachter in char array
             char currentCharDisplayed = currentRandomWordDisplayed[i];
             
             // Recreate the display line
             if(currentChar == chosenChar){
                 displayedLine += chosenChar + " ";
                 currentRandomWordDisplayed[i] = currentChar;
             }else if(currentCharDisplayed != '*'){
                 displayedLine += currentCharDisplayed + " ";
             }else if(Character.isWhitespace(currentChar)){
                 displayedLine += "  ";                
             }else {
                 displayedLine += "_ ";
             }
         }
         
         return displayedLine;
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
            // Display initial underscores
            if(!currentWordExists){
                // Exit the game!
                System.out.println("There is no words left to display!");
                isGameRunning = false;
            }else{
                System.out.print("Word: ");
                for(int i = 0; i < currentRandomWord.length(); i++){
                    char cc = currentRandomWord.charAt(i);
                    if(!Character.isWhitespace(cc)){
                         System.out.print("_ ");
                    }else{
                         System.out.print("  ");
                    }
                    currentRandomWordDisplayed[i] = '*';
                }
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
                wordDisplayed = processUsersChoice(chosenChar);
                System.out.println(wordDisplayed);
            }
        }
    }    
 }
