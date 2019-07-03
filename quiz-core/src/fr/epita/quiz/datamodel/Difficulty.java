package fr.epita.quiz.datamodel;
/**
 * 
 * @author emmanuel
 *	This Class is not used to get the difficulty as it keeps the question class into a loop due to unknown errors
 *but the method remains in the main class and queries the database when needed
 */
public enum Difficulty {
	VERY_EASY(0),
	EASY(1),
	MEDIUM(2),
	HARD(3),
	VERY_HARD(4),
	EXTREMELY_HARD(5),
	
	;
	
	private Integer numericDifficulty;
	
	
	private Difficulty(Integer difficulty) {
		this.numericDifficulty = difficulty;
	}
	
	public Integer getDifficulty() {
		return this.numericDifficulty;
	}

}