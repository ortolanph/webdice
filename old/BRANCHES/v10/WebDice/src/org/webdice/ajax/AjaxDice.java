package org.webdice.ajax;

import org.webdice.beans.DiceResult;
import org.webdice.constants.DiceConstants;
import org.webdice.exception.DiceException;
import org.webdice.factory.DiceFactory;

public class AjaxDice {
	public AjaxDice() {
		super();
	}
	
	public DiceResult roll(int faces) {
		DiceResult result = new DiceResult();
		
		try {
			result.setResult(DiceFactory.createDice(faces).roll());
			result.setMessage(DiceConstants.SUCCESS_ROLL);
		} catch (DiceException e) {
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	public DiceResult rollMultipleTimes(int faces, int times) {
		DiceResult result = new DiceResult();
		
		try {
			result.setResult(DiceFactory.createDice(faces).roll(times));
			result.setMessage(DiceConstants.SUCCESS_ROLL);
		} catch (DiceException e) {
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	public DiceResult rollDiceCup(int[] faces) {
		DiceResult result = new DiceResult();
		
		try {
			for(int face : faces) {
				result.setResult(result.getResult() + DiceFactory.createDice(face).roll());
			}
			
			result.setMessage(DiceConstants.SUCCESS_ROLL);
		} catch (DiceException e) {
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	public DiceResult rollDiceCupMultipleTimes(int[] faces, int times) {
		DiceResult result = new DiceResult();
		
		try {
			for(int face : faces) {
				result.setResult(result.getResult() + DiceFactory.createDice(face).roll(times));
			}
			
			result.setMessage(DiceConstants.SUCCESS_ROLL);
		} catch (DiceException e) {
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
}
