package org.webdice.constants;

/**
 * The Constants class.
 * This has two pre-defined message.
 * It should be replaced in the future by an enum where it will contain the key to a Resource Bundle to internationalization.
 * @author Paulo Ortolan
 * @since 06/14/2010
 */
public abstract class DiceConstants {
	private DiceConstants() {
		super();
	}
	
	/**
	 * The success message.
	 */
	public static final String SUCCESS_ROLL = "The dice was rolled with sucess!";
	/**
	 * The fail message.
	 */
	public static final String FAIL_ROLL = "It was impossible to roll the dice: ";
}
