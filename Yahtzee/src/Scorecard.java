
public class Scorecard {

	//was going to place the cases for scores here, but could not get it to work
	
	public static void scoreCard() {
		int bonus;
		// bonus if upper section is >= 63 points
		if ((Game.ones + Game.twos + Game.threes + Game.fours + Game.fives + Game.sixes) >= 63) {
			bonus = 35;
		} else {
			bonus = 0;
		}
		
		// calculates grand total
		int total = Game.ones + Game.twos + Game.threes + Game.fours + Game.fives + Game.sixes + bonus
				+ Game.triple + Game.quad + Game.fullHouse + Game.smallS + Game.largeS + Game.yahtzee + Game.chance;

		// makes the score card
		System.out.print("1. Ones: [" + Game.ones + "] \n" + "2. Twos: [" + Game.twos * 2 + "] \n" + "3. Threes: [" + Game.threes * 3
				+ "] \n" + "4. Fours: [" + Game.fours * 4 + "] \n" + "5. Fives: [" + Game.fives * 5 + "] \n" + "6. Sixes: ["
				+ Game.sixes * 6 + "] \n" + "   Bonus: " + bonus + "\n7. Triple: [" + Game.triple + "] \n" + "8. Quad: [" + Game.quad
				+ "] \n" + "9. Full House: [" + Game.fullHouse + "] \n" + "10. Small Straight: [" + Game.smallS + "] \n"
				+ "11. Large Straight: [" + Game.largeS + "] \n" + "12. Yahtzee: [" + Game.yahtzee + "] \n" + "13. Chance: ["
				+ Game.chance + "] \n" + "--------------------------- \n" + "Total:" + total + "\n");
	}
}
