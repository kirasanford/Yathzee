import java.util.Scanner;

public class Game {

	// I am a monster, would have moved into player class provided time
	static int ones, twos, threes, fours, fives, sixes, triple, quad, fullHouse, smallS, largeS, yahtzee, chance;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// create an array of players
		// int[] players = new int[6];

		// Keep track of rounds
		int round = 1;

		// initiate the dice
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		Dice die3 = new Dice();
		Dice die4 = new Dice();
		Dice die5 = new Dice();

		// check to see if category is filled
		boolean filledOnes = false, filledTwos = false, filledThrees = false, filledFours = false, filledFives = false,
				filledSixes = false, filledTriple = false, filledQuad = false, filledFH = false, filledSmallS = false,
				filledLargeS = false, filledYahtzee = false, filledChance = false;

//		System.out.print( "Welcome. How many players? Please no more than 6 (This does not do anything if the number is over 6) ");
//		int select = input.nextInt();

		// fills array with players
//		for (int i = 0; i < select; i++) {
//			players[i] = i;
//		}

		while (round < 13) {
			// variables here reset with every round
			// check if needs to be rerolled
			boolean rollCheck1 = true, rollCheck2 = true, rollCheck3 = true, rollCheck4 = true, rollCheck5 = true;

			boolean filled = false; // check if score is inputted for the round
			int rollTurn = 0; // resets rolls with each round

			System.out.print("Round " + (round) + ":\n");
			// rolls first set for user
			System.out.print("Press 1 - 5 to keep and again to reroll. Press 0 for scorecard and 9 to roll: \n");
			die1.roll();
			die2.roll();
			die3.roll();
			die4.roll();
			die5.roll();
			System.out.println("Die One: [" + die1.getDice() + "] Die Two: [" + die2.getDice() + "] Die Three: [" + die3.getDice()
							+ "] " + "Die Four: [" + die4.getDice() + "] " + "Die Five: [" + die5.getDice() + "]");
			rollTurn++;

			while (rollTurn < 3) {// during the 3 rounds players have to roll
				int select1 = input.nextInt();
				switch (select1) {
				case 0:
					Scorecard.scoreCard();
					System.out.println("Die One: [" + die1.getDice() + "] Die Two: [" + die2.getDice()
					+ "] Die Three: [" + die3.getDice() + "] " + "Die Four: [" + die4.getDice() + "] "
					+ "Die Five: [" + die5.getDice() + "]");
					break;
				case 1: // keeps or removed the dice
					if (rollCheck1) {
						rollCheck1 = false;
						System.out.print("Keeping [" + die1.getDice() + "]"); // prints the number on dice to make it
																				// less confusing
					} else {
						rollCheck1 = true;
						System.out.print("Rerolling [" + die1.getDice() + "]");
					}
					break;
				case 2:
					if (rollCheck2) {
						rollCheck2 = false;
						System.out.print("Keeping [" + die2.getDice() + "]");
					} else {
						rollCheck2 = true;
						System.out.print("Rerolling [" + die2.getDice() + "]");
					}
					break;
				case 3:
					if (rollCheck3) {
						rollCheck3 = false;
						System.out.print("Keeping [" + die3.getDice() + "]");
					} else {
						rollCheck3 = true;
						System.out.print("Rerolling [" + die3.getDice() + "]");
					}
					break;
				case 4:
					if (rollCheck4) {
						rollCheck4 = false;
						System.out.print("Keeping [" + die4.getDice() + "]");
					} else {
						rollCheck4 = true;
						System.out.print("Rerolling [" + die4.getDice() + "]");
					}
					break;
				case 5:
					if (rollCheck5) {
						rollCheck5 = false;
						System.out.print("Keeping [" + die5.getDice() + "]");
					} else {
						rollCheck5 = true;
						System.out.print("Rerolling [" + die5.getDice() + "]");
					}
					break;
				case 9:
					System.out.println(
							"Press 1 - 5 to save dice and again to reroll. Press 0 for scorecard and 9 to roll: \n");
					if (rollCheck1) {
						die1.roll();
					}
					if (rollCheck2) {
						die2.roll();
					}
					if (rollCheck3) {
						die3.roll();
					}
					if (rollCheck4) {
						die4.roll();
					}
					if (rollCheck5) {
						die5.roll();
					}
					System.out.println("Die One: [" + die1.getDice() + "] Die Two: [" + die2.getDice()
							+ "] Die Three: [" + die3.getDice() + "] " + "Die Four: [" + die4.getDice() + "] "
							+ "Die Five: [" + die5.getDice() + "]");
					rollTurn++;
					break;
				default:
					System.out.print("Error! \n");
				}
			}
			round++;

			// makes array for scoreCard to use to test cases easier
			int[] arr = { die1.setDice(), die2.setDice(), die3.setDice(), die4.setDice(), die5.setDice() };

			// user enters on Scorecard
			while (filled != true) {
				System.out.print("\n Select where you would like to place your score: \n");
				Scorecard.scoreCard();
				int select1 = input.nextInt();
				switch (select1) {
				// chooses 1s
				case 1:
					if (filledOnes == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 1)
								ones++;
						}
						filledOnes = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses 2s
				case 2:
					if (filledTwos == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 2)
								twos++;
						}
						filledTwos = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses 3s
				case 3:
					if (filledThrees == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 3)
								threes++;
						}
						filledThrees = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses 4s
				case 4:
					if (filledFours == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 4)
								fours++;
						}
						filledFours = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses 5s
				case 5:
					if (filledFives == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 5)
								fives++;
						}
						filledFives = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses 6s
				case 6:
					if (filledSixes == false) {
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 6)
								sixes++;
						}
						filledSixes = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses triple
				case 7:
					if (filledTriple == false) {
						int onesT = 0, twosT = 0, threesT = 0, foursT = 0, fivesT = 0, sixesT = 0;
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 1)
								onesT++;
							if (arr[i] == 2)
								twosT++;
							if (arr[i] == 3)
								threesT++;
							if (arr[i] == 4)
								foursT++;
							if (arr[i] == 5)
								fivesT++;
							if (arr[i] == 6)
								sixesT++;
						}
						if (onesT >= 3 || twosT >= 3 || threesT >= 3 || foursT >= 3 || fivesT >= 3 || sixesT >= 3)
							triple = (onesT) + (twosT * 2) + (threesT * 3) + (foursT * 4) + (fivesT * 5) + (sixesT * 6);
						else
							triple = 0;
						filledTriple = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses quad
				case 8:
					if (filledQuad == false) {
						int onesQ = 0, twosQ = 0, threesQ = 0, foursQ = 0, fivesQ = 0, sixesQ = 0;
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 1)
								onesQ++;
							if (arr[i] == 2)
								twosQ++;
							if (arr[i] == 3)
								threesQ++;
							if (arr[i] == 4)
								foursQ++;
							if (arr[i] == 5)
								fivesQ++;
							if (arr[i] == 6)
								sixesQ++;
						}
						if (onesQ >= 4 || twosQ >= 4 || threesQ >= 4 || foursQ >= 4 || fivesQ >= 4 || sixesQ >= 4) {
							quad = (onesQ) + (twosQ * 2) + (threesQ * 3) + (foursQ * 4) + (fivesQ * 5) + (sixesQ * 6);
						} else
							quad = 0;
						filledQuad = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses full house
				case 9:
					if (filledFH == false) {
						int onesFH = 0, twosFH = 0, threesFH = 0, foursFH = 0, fivesFH = 0, sixesFH = 0;
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == 1)
								onesFH++;
							if (arr[i] == 2)
								twosFH++;
							if (arr[i] == 3)
								threesFH++;
							if (arr[i] == 4)
								foursFH++;
							if (arr[i] == 5)
								fivesFH++;
							if (arr[i] == 6)
								sixesFH++;
						}
						if ((onesFH == 3 // there has to be an easier wa :/
								&& (twosFH == 2 || threesFH == 2 || foursFH == 2 || fivesFH == 2 || sixesFH == 2))
								|| (twosFH == 3 && (onesFH == 2 || threesFH == 2 || foursFH == 2 || fivesFH == 2
										|| sixesFH == 2))
								|| (threesFH == 3
										&& (onesFH == 2 || twosFH == 2 || foursFH == 2 || fivesFH == 2 || sixesFH == 2))
								|| (foursFH == 3 && (onesFH == 2 || threesFH == 2 || twosFH == 2 || fivesFH == 2
										|| sixesFH == 2))
								|| (fivesFH == 3 && (onesFH == 2 || threesFH == 2 || foursFH == 2 || twosFH == 2
										|| sixesFH == 2))
								|| (sixesFH == 3 && (onesFH == 2 || threesFH == 2 || foursFH == 2 || fivesFH == 2
										|| twosFH == 2))) {
							fullHouse = 25;
							filled = true; // notifies that the user has a score for the round
						} else {
							fullHouse = 0;
						}
						filledFH = true;
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses small straight
				case 10:
					if (filledSmallS == false) {
						int onesSS = 0, twosSS = 0, threesSS = 0, foursSS = 0, fivesSS = 0, sixesSS = 0;
						for (int i = 0; i < 5; i++) {
							if (arr[i] == 1)
								onesSS++;
							if (arr[i] == 2)
								twosSS++;
							if (arr[i] == 3)
								threesSS++;
							if (arr[i] == 4)
								foursSS++;
							if (arr[i] == 5)
								fivesSS++;
							if (arr[i] == 6)
								sixesSS++;
						}
						if ((onesSS >= 1 && twosSS >= 1 && threesSS >= 1 && foursSS >= 1)
								|| (twosSS >= 1 && threesSS >= 1 && foursSS >= 1 && fivesSS >= 1)
								|| (threesSS >= 1 && foursSS >= 1 && fivesSS >= 1 && sixesSS >= 1))
							smallS = 30;
						else {
							smallS = 0;
						}
						filledSmallS = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses large straight
				case 11:
					if (filledLargeS == false) {
						int onesLS = 0, twosLS = 0, threesLS = 0, foursLS = 0, fivesLS = 0, sixesLS = 0;
						for (int i = 0; i < 5; i++) {
							if (arr[i] == 1)
								onesLS++;
							if (arr[i] == 2)
								twosLS++;
							if (arr[i] == 3)
								threesLS++;
							if (arr[i] == 4)
								foursLS++;
							if (arr[i] == 5)
								fivesLS++;
							if (arr[i] == 6)
								sixesLS++;
						}
						if ((onesLS >= 1 && twosLS >= 1 && threesLS >= 1 && foursLS >= 1 && fivesLS >= 1)
								|| (twosLS >= 1 && threesLS >= 1 && foursLS >= 1 && fivesLS >= 1 && sixesLS >= 1)) {
							largeS = 40;
						} else {
							largeS = 0;
						}
						filledLargeS = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses yahtzee
				case 12:
					if (filledYahtzee == false) {
						boolean yahtzeeCheck = true;
						int first = arr[0];
						for (int i = 1; i < arr.length; i++) {
							if (arr[i] != first)
								yahtzeeCheck = false;
						}
						if (yahtzeeCheck)
							yahtzee = 50;
						else
							yahtzee = 0;
						filledYahtzee = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				// chooses chance
				case 13:
					// Iterate through all elements and adds
					if (filledChance == false) {
						for (int i = 0; i < arr.length; i++) {
							chance += arr[i];
						}
						filledChance = true;
						filled = true; // notifies that the user has a score for the round
					} else {
						System.out.println("Already filled");
					}
					break;
				default:
					System.out.print("Error! \n");
				}
			}
		}
		// ends game and prints final scorecard
		System.out.print("Game Over \n Final Score: \n");
		Scorecard.scoreCard();
	}
}