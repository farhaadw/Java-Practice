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
     *  Path to the Hangman-Words.text file
     */
    static String filePath = "src/simple_games/Hangman-Words.txt";
    
    /**
     * Add words to list on startup
     */
    static {
        addWordsToList();
    }
    
    public static void main(String[] args){

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
        System.out.println("Current words in list = " + words);
    }
    
    /**
     *  Method to read Hangman-Words.txt file and add to list
     */
    public static void readTextFile() throws IOException{
        BufferedReader br = null;
        System.out.print("Adding words");
        
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
     * Return true if word successfully retrieved
     */
    public static boolean getRandomWord(){
        words.removeAll(chosenWords);
        Random random = new Random();
        if(words.size() > 0){
            currentRandomWord = words.get(random.nextInt(words.size()));
            chosenWords.add(currentRandomWord);
            return true;
        }
        return false;
    }
    
    public static void playGame(){
        
        // Set random word
        boolean getWord = getRandomWord();
        
    }
         
 }
