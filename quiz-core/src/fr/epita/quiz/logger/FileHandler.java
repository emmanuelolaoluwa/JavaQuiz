/**
 * 
 */
package fr.epita.quiz.logger;

/**
 * @author emmanuel
 *
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.util.Date;

/**
 * @author emmanuel
 *The file handler writes and logs into the database 
 *
 *FileHandler Creates a simple date and throws an error if the file cannot be connected
 *
 */
public class FileHandler {
	
	public String information;
	
	public FileHandler(String information) {
		this.information = information;
	}

	Date currentDate = new Date();
	SimpleDateFormat datesimple = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
	
	public void filer() throws IOException {
		
		File file = new File("./LogDetails/LogDetails.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		
		PrintWriter writer = new PrintWriter(fileWriter);
		writer.write( information + "\n");
		writer.flush();
		writer.close();

	}
	
	
}
