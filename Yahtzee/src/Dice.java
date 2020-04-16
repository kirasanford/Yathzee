public class Dice {
	protected int diceValue;
	protected int sides;

	// Default constructor that makes a 6-sided die
	public Dice() {
		diceValue = 6;
	}

	// Parameterized constructor that lets you make any sided die you might want
	public void diceSides(int sides) {
		diceValue = sides;
	}

	// Method to roll the die
	public int roll() {
		diceValue = (int)(Math.random() * 6) + 1;
		return diceValue;
	}

	// Set die value
	public int setDice() {
		return diceValue;
	}

	// Get die value
	public int getDice() {
		return diceValue;
	}

}