/**
 * 
 */
package fr.epita.quiz.logger;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import fr.epita.quiz.logger.FileHandler;


/**
 * @author emmanuel
 *
 *class Logger
 *logs the date and errors  communicates with the file handler class to have access to write a file
 *LogDetails
 *Log bug
 *Log error
 *Log alert
 *
 *
 */
public class Logger {
	
	private String details;
	
	public Logger(String details) {
		this.details = details;
	}
	

	public void log(String information, String message) {
		
		Date currentDate = new Date();
		SimpleDateFormat datesimple = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
		String writethis = datesimple.format(currentDate) + " - " + details + " - [" + information + "] --- " + message;
		
		FileHandler handler = new FileHandler(writethis);
		
		try {
			handler.filer();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Did not work");
		}
		
		
	}
	
	public void logDetails(String details) {
		log(details, "INFO" );
	}
	public void logError(String details) {
		log(details, "ERROR" );
	}
	public void logBug(String details) {
		log(details, "DEBUG");
	}
	public void logAlert(String details) {
		log(details, "ALERT");
	}
	
	
	
	
	
	
}
