package simple_games.Blackjack;

import java.util.Random;

/**
 * 
Write a program that allows a human user to play a single hand of "blackjack" against a dealer.

Pick two values from 1-10 for the player. These are the player's "cards".
Pick two more values from 1-10 for the dealer.
Whoever has the highest total is the winner.
There is no betting, no busting, and no hitting. Save that for real blackjack.

 */

public class Blackjack {
	
	public static void main(String[] args){
		
		// Very simple just to get started to help understand game play
	
		// Pick 2 values for player
		int player1 = pickValue(10);
		int player2 = pickValue(10);
			
		// Pick 2 values for dealer
		int dealer1 = pickValue(10);
		int dealer2 = pickValue(10);
		
		int playerTotal = player1 + player2;
		int dealerTotal = dealer1 + dealer2;
		
		if(playerTotal > dealerTotal){
			// player won
		}else if(dealerTotal > playerTotal){
			// dealer won
		}else{
			// both draw
		}	
	}
	
	/** Pick random value */
	public static int pickValue(int upperLimit){
	  Random ran = new Random();
	  return 1 + ran.nextInt(10);
	}
	
}
