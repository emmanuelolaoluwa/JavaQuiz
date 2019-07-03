/**
 * 
 */
package fr.epita.quiz.exception;

/**
 * @author emmanuel
 *
 */
public class DeleteFailedException extends DataAccessException{
	
	public DeleteFailedException(Object badInput) {
		super(badInput);
	}

	public DeleteFailedException(Object badInput, Exception initialCause) {
		super(badInput,initialCause);
	}
}
