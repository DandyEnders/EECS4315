/**
 * An exception that signals that the method bond is invoked 
 * by a thread different from Oxygen and Hydrogen.
 * 
 * @author Franck van Breugel
 */
public class IllegalMoleculeException extends Exception {

	/**
	 * Initializes this exception with the given error message.
	 * 
	 * @param errorMessage error message of this exception
	 */
	public IllegalMoleculeException(String errorMessage) {
		super(errorMessage);
	}
}