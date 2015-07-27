package org.webdice.model;

import org.webdice.constants.DiceConstants;
import org.webdice.exception.DiceException;

/**
 * This is the enum for the dices.
 * This class is the core of the project.
 * @author Paulo Ortolan
 * @since 06/14/2010 
 */
public enum Dice {
	/**
	 * The d4 dice.
	 */
	DICE_D4(4),
	/**
	 * The d6 dice.
	 */
	DICE_D6(6),
	/**
	 * The d8 dice.
	 */
	DICE_D8(8),
	/**
	 * The d10 dice.
	 */
	DICE_D10(10),
	/**
	 * The d12 dice.
	 */
	DICE_D12(12),
	/**
	 * The d20 dice.
	 */
	DICE_D20(20),
	/**
	 * The Unknown Dice.
	 */
	DICE_UNKNOWN(0);

	private int faces;
	private int[] partialResults;

	/**
	 * The default constructor of the Dice enum.
	 * @param faces The dice number of faces.
	 */
	private Dice(int faces) {
		partialResults = new int[1];
		this.faces = faces;
	}

	/**
	 * Rolls a single time a dice.
	 * @return The dice face result rolled a single time.
	 * @throws DiceException It is thrown when the dice face is unknown.
	 * @see Dice#DICE_UNKNOWN The Unknown Dice
	 * @see org.webdice.ajax.AjaxDice#roll(int) <code>roll(int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCup(int[]) <code>rollDiceCup(int[])</code> method on AjaxDice class
	 */
	public int roll() throws DiceException {
		try {
			int result = (int) (Math.random() * faces) + 1;
			
			partialResults[0] = result;
			
			return result;
		} catch (Exception e) {
			throw new DiceException(DiceConstants.FAIL_ROLL + e.getMessage());
		}
	}

	/**
	 * Rolls a dice multiple times.
	 * @param times Times to roll the dice.
	 * @return The sum of dice faces result rolled multiple times.
	 * @throws DiceException DiceException It is thrown when the dice face is unknown.
	 * @see Dice#DICE_UNKNOWN The Unknown Dice
	 * @see org.webdice.ajax.AjaxDice#rollMultipleTimes(int, int) <code>rollMultipleTimes(int, int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCupMultipleTimes(int[], int) <code>rollDiceCupMultipleTimes(int[], int)</code> method on AjaxDice class
	 */
	public int roll(int times) throws DiceException {
		partialResults = new int[times];
		int result = 0;

		for (int i = 0; i < times; i++) {
			int pres = roll();
			
			partialResults[i] = pres;
			
			result += roll();	
		}

		return result;
	}
	
	/**
	 * Gets the partial results of the call of the roll methods.
	 * @return the partial results
	 */
	public int[] getPartialResults() {
		return partialResults;
	}
}
