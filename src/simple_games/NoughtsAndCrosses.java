package simple_games;

import java.util.Scanner;
import static simple_games.NoughtsAndCrosses.GameState.GAME_END;
import static simple_games.NoughtsAndCrosses.GameState.GAME_STARTED;
import static simple_games.NoughtsAndCrosses.GameState.IN_PROGRESS;
import static simple_games.NoughtsAndCrosses.GameState.POSITION_EXISTS;
import static simple_games.NoughtsAndCrosses.GameState.SUCCESS_ADDED;
import static simple_games.NoughtsAndCrosses.GameState.TIE;

/**
 *
 * @author farhaad
 */
public class NoughtsAndCrosses {
    
    static int columns = 3;
    static int rows = 3;    
    static String[][] board = new String[rows][columns];
    
    static String cross = "x";
    static String naught = "o";
    static String currentPlayer = "PLAYER 1";

    enum GameState{
        GAME_STARTED, SUCCESS_ADDED, GAME_END, IN_PROGRESS, POSITION_EXISTS, TIE
    }
       
    public static void main(String[] args){
        playGame();
    }
    
    /**
     * Method to create board
     * Accepts row position, column position and (x or o) choice 
     * which is placed on board
     */
    public static String createBoard(int rowPos, int colPos, String choice){
        
        String message = SUCCESS_ADDED.name(); 
        
        System.out.println("");
        
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                
                if(rowPos != 0 && colPos != 0){
                    if(i == rowPos - 1 && j == colPos -1){
                        if(!board[rowPos - 1][colPos - 1].equals(" * ")){
                             message = POSITION_EXISTS.name();
                        }else{
                             board[rowPos - 1][colPos - 1] = " " + choice + " ";    
                        }
                    }    
                }else{
                    board[i][j] = " * "; 
                }
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        
        System.out.println("");
        return message;
    }
    
    /**
     * Create blank board
     */
    public static String createBlankBoard(){
        return createBoard(0, 0, null);
    }
    
    /**
     * Change current players turn
     */
    public static void changePlayer(){
        if(currentPlayer.equals("PLAYER 1")){
            currentPlayer = "PLAYER 2";
        }else{
            currentPlayer = "PLAYER 1";
        }
    }
    

   /*
    * Check if player has won by checking vertical, horizontal or diagonal
    * choices are equal
    */
    public static boolean checkMatches(int row, int column){
        
        boolean isEqual = false;
        
        if((column == 0) && (row == 0 || row == 1 || row == 2)){
             if(board[row][0].trim().equals("o") && board[row][1].trim().equals("o")
                     && board[row][2].trim().equals("o")){
                 isEqual =  true;
              } else if(board[row][0].trim().equals("x") && board[row][1].trim().equals("x")
                     && board[row][2].trim().equals("x")){
                 isEqual = true;
             }
        }
        
        if(row == 0 && (column == 0 || column == 1 && column == 2)){
            if(board[0][column].trim().equals("o") && board[1][column].trim().equals("o")
                    && board[2][column].trim().equals("o")){
                  isEqual = true;
            } else if(board[0][column].trim().equals("x") && board[1][column].trim().equals("x")
                        && board[2][column].trim().equals("x")){
                  isEqual = true;
            }
        }
        
        if(row == 0 && column == 0){
            if(board[0][0].trim().equals("o") && board[1][1].trim().equals("o") 
                       && board[2][2].trim().equals("o")){
                isEqual= true;
            }else if(board[0][0].trim().equals("x") && board[1][1].trim().equals("x") 
                       && board[2][2].trim().equals("x")){
                isEqual = true;
            }
        }else if(row == 2 && column == 0){
            if(board[2][0].trim().equals("o") && board[1][1].trim().equals("o") 
                       && board[0][2].trim().equals("o")){
                isEqual= true;
            }else if(board[2][0].trim().equals("x") && board[1][1].trim().equals("x") 
                       && board[0][2].trim().equals("x")){
                isEqual = true;
            }
        }
        
        return isEqual;
    }
    
    /**
     * Update game play to either in progress or end 
     * if player has won
     */
    public static String updateGameState(){
        int count = 0;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(checkMatches(i, j)) {;
                    return GAME_END.name();
                }
                if(!board[i][j].trim().equals("*") ){
                    count ++;
                }
            }
        }
        if(count == 9){
            return TIE.name();
        }
        return IN_PROGRESS.name();
    }
    
    /**
     *  Main method to control game play
     */
    public static void playGame(){
        
        Scanner sc = new Scanner(System.in);
        String state = GAME_STARTED.name(); 
        String player1 = "";
        String player2 = "";
        
        do{
            if(state.equals(GAME_STARTED.name())){
                createBlankBoard();
                boolean isCorrectOption = false;
                
                System.out.print("Choose Naughts or Crosses ( o or x )... ");
                String choice = sc.nextLine();
                
                // Ensure user selects correct option
                while(!isCorrectOption){
                    if(choice.equals(naught)){
                        player1 = naught;
                        player2 = cross;
                        isCorrectOption = true;   
                    }else if(choice.equals(cross)){
                        player1 = cross;
                        player2 = naught;
                        isCorrectOption = true;   
                    }else{
                        System.out.print("Incorrect choice, try again ( o or x )... ");
                        choice = sc.nextLine();   
                    }   
                }
                // Change game state to in-progress
                state = IN_PROGRESS.name();
            }else{
                System.out.println(currentPlayer  + " Choose positions ... ");
                
                System.out.print("Row ");
                int row = sc.nextInt();
                System.out.print("Column ");
                int column = sc.nextInt();
                
                // Check if user selects correct positions
                if((row >= 1 && row <= 3) 
                        && (column >= 1 && column <= 3)){
                    
                    String choice = player1;
                    if(!currentPlayer.equals("PLAYER 1")){
                        choice = player2;
                    }       
                    String result = createBoard(row, column, choice);
                    
                    if(result.equals(POSITION_EXISTS.name())){
                        System.out.println("Position already filled, try again ");
                    }else{
                        // Change game state
                        state = updateGameState();
                        if(state.equals(GAME_END.name())){
                            System.out.println("====================================");
                            System.out.println(currentPlayer + " has won the game !!!");
                            System.out.println("====================================");
                        }else if(state.equals(TIE.name())){
                            System.out.println("====================================");
                            System.out.println("The game is a tie !!!");
                            System.out.println("====================================");
                        }else{
                            changePlayer();
                        }
                    }
                } else{
                    System.out.println("Wrong choice, try again ...");
                } 
            }
        }while(!state.equals(GAME_END.name()));
    }
}
