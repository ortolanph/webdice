package org.webdice.factory;

import org.webdice.model.Dice;

/**
 * The dice factory class will create for <code>AjaxDice</code> a dice based on the number of faces.
 * If the number of faces given is different than 4, 6, 8, 10, 12 and 20, it will return a DICE_UNKNOWN Dice.  
 * @author Paulo Ortolan
 * @since 06/14/2010
 * @see org.webdice.model.Dice#DICE_UNKNOWN The Unknown Dice.
 */
public class DiceFactory {
	private DiceFactory() {
		super();
	}
	
	/**
	 * Creates a dice using a given number of faces.
	 * If the number of faces given is different than 4, 6, 8, 10, 12 and 20, it will return a DICE_UNKNOWN Dice.
	 * @param faces The number of faces.
	 * @return The Dice based on the number of faces.
	 * @see org.webdice.ajax.AjaxDice#roll(int) <code>roll(int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollMultipleTimes(int, int) <code>rollMultipleTimes(int, int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCup(int[]) <code>rollDiceCup(int[])</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCupMultipleTimes(int[], int) <code>rollDiceCupMultipleTimes(int[], int)</code> method on AjaxDice class
	 * @see org.webdice.model.Dice#DICE_D4 The d4 dice
	 * @see org.webdice.model.Dice#DICE_D6 The d6 dice
	 * @see org.webdice.model.Dice#DICE_D8 The d8 dice
	 * @see org.webdice.model.Dice#DICE_D10 The d10 dice
	 * @see org.webdice.model.Dice#DICE_D12 The d12 dice
	 * @see org.webdice.model.Dice#DICE_D20 The d20 dice
	 * @see org.webdice.model.Dice#DICE_UNKNOWN The Unknown Dice
	 */
	public static Dice createDice(int faces) {
		Dice dice = null;
		
		switch(faces) {
		case 4:
			dice = Dice.DICE_D4;
			break;
		case 6:
			dice = Dice.DICE_D6;
			break;
		case 8:
			dice = Dice.DICE_D8;
			break;
		case 10:
			dice = Dice.DICE_D10;
			break;
		case 12:
			dice = Dice.DICE_D12;
			break;
		case 20:
			dice = Dice.DICE_D20;
			break;
		default:
			dice = Dice.DICE_UNKNOWN;
		}
		
		return dice;
	}
}
