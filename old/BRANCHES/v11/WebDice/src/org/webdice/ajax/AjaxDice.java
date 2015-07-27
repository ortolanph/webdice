package org.webdice.ajax;

import org.webdice.beans.DiceResult;
import org.webdice.constants.DiceConstants;
import org.webdice.exception.DiceException;
import org.webdice.factory.DiceFactory;

/**
 * The AjaxDice class is an implementation to the web front talk to logic layer. This class is declared on dwr.xml.
 * @author Paulo Ortolan
 * @since 06/14/2010
 */
public class AjaxDice {
	/**
	 * The main constructor of the AjaxDice class.
	 */
	public AjaxDice() {
		super();
	}
	
	/**
	 * This method executes a single dice roll by the number of faces.
	 * It will return 0 if the number of faces is different than 4, 6, 8, 10, 12 and 20.
	 * @param faces The dice number of faces.
	 * @return A single roll result.
	 */
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
	
	/**
	 * This method executes a times dice roll by the number of faces.
	 * It will return 0 if the number of faces is different than 4, 6, 8, 10, 12 and 20.
	 * @param faces The dice number of faces.
	 * @param times How many times the dice will roll.
	 * @return The sum of every dice result rolled a number of times. 
	 */
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
	
	/**
	 * This method executes a single roll for every dice in the dice cup.
	 * If some dice face is equals to 0 then 0 will be added to the sum taking no effect.
	 * @param faces An array containing valid dice faces.
	 * @return The sum of all single roll result for every dice in the dice cup. 
	 */
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
	
	/**
	 * This method executes a multiple roll for every dice in the dice cup.
	 * If some dice face is equals to 0 then 0 will be added to the sum taking no effect.
	 * @param faces An array containing valid dice faces.
	 * @param times How many times each dice will roll.
	 * @return The sum of all multiple roll result for every dice in the dice cup. 
	 */
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
