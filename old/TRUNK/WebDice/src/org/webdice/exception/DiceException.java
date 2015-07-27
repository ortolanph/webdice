package org.webdice.exception;

/**
 * This is the default DiceException class.
 * It is thrown only when the given number of faces is 0.
 * @author Paulo Ortolan
 * @since 06/14/2010
 */
public class DiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The default constructor of the Dice Exception class.
	 * @param message The message that should be carried to the other layers.
	 * @see org.webdice.constants.DiceConstants#SUCCESS_ROLL The success roll message
	 * @see org.webdice.constants.DiceConstants#FAIL_ROLL The fail roll message
	 */
	public DiceException(String message) {
		super(message);
	}
}
