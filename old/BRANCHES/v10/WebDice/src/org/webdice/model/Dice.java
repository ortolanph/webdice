package org.webdice.model;

import org.webdice.constants.DiceConstants;
import org.webdice.exception.DiceException;

public enum Dice {
	DICE_D4(4), 
	DICE_D6(6), 
	DICE_D8(8), 
	DICE_D10(10), 
	DICE_D12(12), 
	DICE_D20(20), 
	DICE_UNKNOWN(0);
	
	private int faces;
	
	private Dice(int faces) {
		this.faces = faces;
	}
	
	public int roll() throws DiceException {
		try {
			return (int)(Math.random() * faces) + 1;
		} catch(Exception e) {
			throw new DiceException(DiceConstants.FAIL_ROLL + e.getMessage());
		}
	}
	
	public int roll(int times) throws DiceException {
		int result = 0;
		
		for(int i = 0; i < times; i++) {
			result += roll();
		}
		
		return result;
	}
}
