package org.webdice.factory;

import org.webdice.model.Dice;

public class DiceFactory {
	private DiceFactory() {
		super();
	}
	
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
