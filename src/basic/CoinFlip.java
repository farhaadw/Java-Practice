package basic;

import java.util.Scanner;

/**
 *
 * @author farhaadwasim
 */
public class CoinFlip {
    
    public static void main(String[] args){
        coinFlip();
    }
    
    public static void coinFlip(){
        Scanner sc = new Scanner(System.in);
        String coin, flipAgain = "";
        int streak = 0;
        boolean goHeads;
                
        do{
            goHeads = Math.random() < 0.5;
            
            if(goHeads){
                coin = "HEADS";
            }else {
                coin = "TAILS";
            }
          
            System.out.println("You flipped " + coin);
            
            if(coin.equals("HEADS")){
                streak ++;
                System.out.println("You rolled heads " + streak + " times");
                System.out.println("flip again? y/n");
                flipAgain = sc.nextLine();
            }else {
                flipAgain = "n";
                streak = 0;
            }
            
            
        }while(flipAgain.equals("y"));
        
        
        
    }
    
}
