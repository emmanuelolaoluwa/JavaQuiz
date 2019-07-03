package fr.epita.quiz.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.exception.CreateFailedException;
import fr.epita.quiz.exception.DeleteFailedException;
import fr.epita.quiz.exception.SearchFailedException;
import fr.epita.quiz.services.data.QuizFileDAO;

public class TestQuizFileDAO {
	
	public static void main(String[] args) throws IOException {
		//given
		QuizFileDAO dao = new QuizFileDAO(new File("./home/java/quizTest.txt"));
		Quiz quiz = new Quiz("Intermediate Quiz for Java and OOP");

		//when
		try {
			dao.create(quiz);
		} catch (CreateFailedException e) {
			System.out.println("this Quiz was not created :" + e.getFaultInstance());
			e.printStackTrace();
		}
		
		//then ?
		/** try {
			List<Quiz> searchResults = dao.search(new Quiz("Java"));
			System.out.println(searchResults);
			if (searchResults.size() < 1) {
				System.out.println("error, got no result");
			}else {
				System.out.println("success!");
			}
		} catch (SearchFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} **/
		
		
		try {
			boolean test = dao.delete(new Quiz("Java"));
			System.out.println(test);
			if (test) {
				System.out.println("Deleted !");
			}else {
				System.out.println("Operation Failed!");
			}
		} catch (DeleteFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
