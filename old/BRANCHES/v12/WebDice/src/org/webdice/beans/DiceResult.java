package org.webdice.beans;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the bean used by AjaxDice class.
 * This class must be declared in the dwr.xml to avoid problems.
 * This class carries the results of the methods called to roll the dices.
 * @author PauloCPT01
 * @since 06/14/2010
 */
public class DiceResult {
	private String message;
	private int result;
	private int[] faces;
	private int[][] partialResults;
	
	/**
	 * The default constructor of the class.
	 */
	public DiceResult() {
		super();
	}

	/**
	 * Sets the message. The message is set on the AjaxDice class. 
	 * @param message The message to be set.
	 * @see org.webdice.constants.DiceConstants Constants class
	 * @see org.webdice.ajax.AjaxDice AjaxDice class
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the message. The message is often used on the jsp page.
	 * @return The message. 
	 * @see org.webdice.constants.DiceConstants Constants
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the result. The result is set on the AjaxDice class. 
	 * @param result The result to be set.
	 * @see org.webdice.ajax.AjaxDice#roll(int) <code>roll(int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollMultipleTimes(int, int) <code>rollMultipleTimes(int, int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCup(int[]) <code>rollDiceCup(int[])</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCupMultipleTimes(int[], int) <code>rollDiceCupMultipleTimes(int[], int)</code> method on AjaxDice class
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * Gets the result. The result is often used on the jsp page.
	 * @return The result.
	 * @see org.webdice.ajax.AjaxDice#roll(int) <code>roll(int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollMultipleTimes(int, int) <code>rollMultipleTimes(int, int)</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCup(int[]) <code>rollDiceCup(int[])</code> method on AjaxDice class
	 * @see org.webdice.ajax.AjaxDice#rollDiceCupMultipleTimes(int[], int) <code>rollDiceCupMultipleTimes(int[], int)</code> method on AjaxDice class
	 */
	public int getResult() {
		return result;
	}

	/**
	 * This method return the faces of the dices rolled.
	 * @return the faces of dices rolled
	 */
	public int[] getFaces() {
		return faces;
	}

	/**
	 * Sets the faces of the dices rolled.
	 * @param faces the faces to set
	 */
	public void setFaces(int[] faces) {
		this.faces = faces;
	}

	/**
	 * Gets the partial results matrix.
	 * @return the partialResults
	 */
	public int[][] getPartialResults() {
		return partialResults;
	}

	/**
	 * This method sets the rolled dices partial results.
	 * @param partialResults the partialResults to set
	 */
	public void setPartialResults(int[][] partialResults) {
		this.partialResults = partialResults;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faces == null) ? 0 : faces.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((partialResults == null) ? 0 : partialResults.hashCode());
		result = prime * result + this.result;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiceResult other = (DiceResult) obj;
		if (faces == null) {
			if (other.faces != null)
				return false;
		} else if (!faces.equals(other.faces))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (partialResults == null) {
			if (other.partialResults != null)
				return false;
		} else if (!partialResults.equals(other.partialResults))
			return false;
		if (result != other.result)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DiceResult [faces=" + faces + ", message=" + message
				+ ", partialResults=" + partialResults + ", result=" + result
				+ "]";
	}
}
