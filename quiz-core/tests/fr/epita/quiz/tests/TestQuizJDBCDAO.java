package fr.epita.quiz.tests;

import java.util.List;
import java.util.Scanner;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Difficulty;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.services.ConfigurationService;
import fr.epita.quiz.services.data.QuizJDBCDAO;

public class TestQuizJDBCDAO {
	
	public static void main(String[] args) throws Exception {
		//Given
		QuizJDBCDAO dao = new QuizJDBCDAO();
		ConfigurationService conf = ConfigurationService.getInstance();
		boolean confInit = conf.isInit();
		if (!confInit) {
			System.out.println("problem while initializing the conf");
			return;
		} 	
		Scanner scanner = new Scanner(System.in);
	 
		System.out.println("Quiz creation ...");
		System.out.println("Enter Quiz");
		String qu = scanner.nextLine();
		qu.toLowerCase();
		
		
		System.out.println("Enter your Question");
		String quest = scanner.nextLine();
		
		System.out.println("Enter your your answer");
		String ans = scanner.nextLine();
		
		System.out.print("The length of topics for this question > ");
		int length = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Topics");
		String[] topics = new String[length];
		
		for(int i = 0; i < length; i++) {
			String word = scanner.nextLine();
			topics[i] = word;
		}
		
		Question question = new Question(quest, topics , Difficulty.EASY.getDifficulty()) ;
		Quiz quiz = new Quiz(qu);
		Answer answer = new Answer(ans);
		
		answer.setQuestion(question);
		answer.setQuiz(quiz);
		
		System.out.println(answer.getQuiz()+ " " + answer.getQuestion() + " " + answer.getText());
	
	    dao.createAll(quiz, answer, question);

			dao.create(quiz) ;
	
		
		//thenJAVA
			
		List<String> list = dao.singleAnswerQuestion("math");	
			System.out.println(list);
			
			int countTotal = 0;
			int countCorrect = 0;
			int countWrong = 0;
			
		String questiontype = "math";
		
			for (int i = 0; i < dao.singleAnswerQuestion(questiontype).size(); i++) {
			
					 String question1 =	dao.singleAnswerQuestion(questiontype).get(i);
					 i++;
					 System.out.println(i);
					 String option = 	dao.singleAnswerQuestion(questiontype).get(i);
					System.out.println(i);
					
					 System.out.println(question1);
					 System.out.println(option);
					 
						 System.out.println("Enter option");
						 String opt = scanner.nextLine();
						 opt = opt.toLowerCase();
						 
						 if ( opt.equals(option)) {
								System.out.println("------------------------------");
								System.out.println("Correct Answer");
								System.out.println("------------------------------");
								countCorrect++;
							
							}	else {
								
								System.out.println("------------------------------");
								System.out.println("Wrong Answer");
								System.out.println("------------------------------");
								countWrong++;
								
							}	
						 
					
			}
			
			System.out.println(countCorrect +" / " + countTotal);
			
			scanner.close();
		
		//System.out.println(dao.getAllQuiz());
		
		
		//if (list.isEmpty()) {
		//	throw new Exception("the list was empty");
		//}
		//List<String> list = dao.search("math");	
		//System.out.println(list);
		//System.out.println(list);
		
		//List<String> topics = dao.searchTopic("math");
		//System.out.println(topics);
		
		System.out.println("Enter quiz to update from");
		System.out.println("Enter new name");
		
		String updateFrom = scanner.nextLine();
		String updateTo = scanner.nextLine();
		
		dao.update(updateFrom, updateTo);
		
	}

}
