import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CombinatorialApplications {
	
	public void redOrBlack() {
		Scanner user = new Scanner(System.in);
		Random rand = new Random();
		int points = 0;
		int numberOfCards = 52;
		double red, black;
		red = 26;
		black = 26;
		double spade, club, diamond, heart;
		spade = 13;
		club = 13;
		diamond = 13;
		heart = 13;
		int cardsHigher, cardsLower;
		cardsHigher = 0;
		cardsLower = 0;
		int initialChoice = 0;
		int indexOfCardsPulled = -1;
		ArrayList<Integer> choiceArray = new ArrayList<Integer>();
		ArrayList<Integer> cardPulledRank = new ArrayList<Integer>();
		ArrayList<Integer> cardPulledSuit = new ArrayList<Integer>();
		int[] rank =  {4,4,4,4,4,4,4,4,4,4,4,4,4}; 
		System.out.println("Welcome to red or black algrothim; Here we use probability to guess best chances "
				+ "for the game!");
		while(points < 3) {
			if(initialChoice == 0) {
				initialChoice++;
				boolean firstPick = rand.nextBoolean();
				if(firstPick == true) {
					System.out.println("Choose red");
					choiceArray.add(0);
				} else {
					System.out.println("Choose black");
					choiceArray.add(1);
				}
			} else {
				if(points == 0) {
					if(red/numberOfCards > black/numberOfCards) {
						System.out.println("Choose red");
						choiceArray.add(0);
					} else { // can make another branch for if they equal each other
						System.out.println("Choose black");
						choiceArray.add(1);
					}	
				} else if(points == 1) {
					for(int j = cardPulledRank.get(indexOfCardsPulled)-1; j < rank.length; j++) { 
						cardsHigher += rank[j];
					}
					for(int k = 0; k < cardPulledRank.get(indexOfCardsPulled)-1; k++) {
						cardsLower += rank[k];
					}
					if(cardsHigher > cardsLower) {
						System.out.println("Choose higher");
						choiceArray.add(2);
						cardsHigher = 0;
						cardsLower = 0;
					} else if(cardsLower >= cardsHigher) {
						System.out.println("Choose lower");
						choiceArray.add(3);
						cardsHigher = 0;
						cardsLower = 0; 
					}
				} else if(points == 2) {
					if(spade/numberOfCards > club/numberOfCards && spade/numberOfCards > diamond/numberOfCards && spade/numberOfCards > heart/numberOfCards) {
						System.out.println("Choose spade");
						choiceArray.add(4);
					} else if(club/numberOfCards > spade/numberOfCards && club/numberOfCards > diamond/numberOfCards && club/numberOfCards > heart/numberOfCards) {
						System.out.println("Choose club");
						choiceArray.add(5);
					} else if(diamond/numberOfCards > spade/numberOfCards && diamond/numberOfCards > club/numberOfCards && diamond/numberOfCards > heart/numberOfCards) {
						System.out.println("Choose diamond");
						choiceArray.add(6);
					} else if (heart/numberOfCards > spade/numberOfCards && heart/numberOfCards > club/numberOfCards && heart/numberOfCards > diamond/numberOfCards) {
						System.out.println("Choose heart");
						choiceArray.add(7);
					} else {
						System.out.println("Choose spade"); // fix logic; other options like to suits equalling each other being greater than other suits
						choiceArray.add(4);
					}
					
				}
			}
			
			System.out.print("What rank was pulled? (1-13; Ace at bottom) ");
			int rankPulled = user.nextInt();
			if(rankPulled < 1 || rankPulled > 13) {
				throw new IllegalArgumentException("Pick number within bounds");
			}
			rank[rankPulled-1]--;
			cardPulledRank.add(rankPulled);
			System.out.print("What suit was pulled? Pick number 1-4 (Spade-1, Club-2, Diamond-3, Heart-4) ");
			int suitPulled = user.nextInt();
			if(suitPulled == 1) {
				spade--;
				black--;
			} else if(suitPulled == 2) {
				club--;
				black--;
			} else if(suitPulled == 3) {
				diamond--;
				red--;
			} else if(suitPulled == 4) {
				heart--;
				red--;
			} else {
				throw new IllegalArgumentException("Pick number within bounds");
			}
			cardPulledSuit.add(suitPulled);
			
			numberOfCards--;
			indexOfCardsPulled++;
			
			if(points == 0) {
				if((choiceArray.get(indexOfCardsPulled) == 0 && (cardPulledSuit.get(indexOfCardsPulled) == 3 || cardPulledSuit.get(indexOfCardsPulled) == 4)) || (choiceArray.get(indexOfCardsPulled) == 1 && (cardPulledSuit.get(indexOfCardsPulled) == 1 || cardPulledSuit.get(indexOfCardsPulled) == 2))) {
					points++;
				} else {
					points = 0;
				}		
			} else if(points == 1) {
				if((choiceArray.get(indexOfCardsPulled) == 2 && cardPulledRank.get(indexOfCardsPulled-1) < cardPulledRank.get(indexOfCardsPulled)) || (choiceArray.get(indexOfCardsPulled) == 3 && cardPulledRank.get(indexOfCardsPulled-1) > cardPulledRank.get(indexOfCardsPulled))) {
					points++;
				} else {
					points = 0;
				}
				
			} else if(points == 2) {
				if(choiceArray.get(indexOfCardsPulled) == 4 && cardPulledSuit.get(indexOfCardsPulled) == 1) {
					points++;
				} else if(choiceArray.get(indexOfCardsPulled) == 5 && cardPulledSuit.get(indexOfCardsPulled) == 2) {
					points++;
				} else if(choiceArray.get(indexOfCardsPulled) == 6 && cardPulledSuit.get(indexOfCardsPulled) == 3) {
					points++;
				} else if(choiceArray.get(indexOfCardsPulled) == 7 && cardPulledSuit.get(indexOfCardsPulled) == 4){
					points++;
				} else {
					points = 0;
				}
			}
			
		}
		
		System.out.println("Congradulations you beat red or black using probability!");
		
	}
	
	



}
