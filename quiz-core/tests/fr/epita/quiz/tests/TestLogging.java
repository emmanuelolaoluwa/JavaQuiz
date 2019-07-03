package fr.epita.quiz.tests;

import fr.epita.quiz.logger.Logger;

public class TestLogging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = new Logger("Test logging");
	
		logger.logDetails("This is a test message for information");
		logger.logAlert("This is an alert7777777777777777");
		logger.logBug("This is a bug");
		logger.logError("This is an error");
		
	}

}
