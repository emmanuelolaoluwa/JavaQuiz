/**
 * 
 */
package fr.epita.quiz.exception;

/**
 * @author emmanuel
 *
 */
public class DeleteFailedException extends DataAccessException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -217007312198536628L;

	public DeleteFailedException(Object badInput) {
		super(badInput);
	}

	public DeleteFailedException(Object badInput, Exception initialCause) {
		super(badInput,initialCause);
	}
}
