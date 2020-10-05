package paths.pathWays;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import paths.Paths;

public class Trap{

	HashMap<String, String> riddles = new HashMap<>();	
	Random random = new Random();
	Scanner input = new Scanner(System.in);
	
	//Questions (in order)
	String[] questions = {("Type the next letter in this sequence: J F M A M J J A S O N _?")
			,("I’m an odd number. If you take away one of the letters in my name I become even. What number am I?")
			,("There are three apples on a table and you take away two of them. How many apples do you have now?")
			,("Name three consecutive days without using the words “Wednesday” “Friday” or “Sunday”?")
			,("How many cats can you put in an empty box placing them one at a time?")
			,("What starts with “e” ends with “e” and contains one letter?")
			,("What has one head, one foot, and four legs?")
			,("What kind of coat is always wet when you put it on?")
			,("21 * 3 = ?")
			,("(1 + 4) * 3 - (1 * 8) = ?")
			,("7-2*5+1")
			,("The answer is easy. Don’t overthink this. The way to answer is to divide one silver coin between three people.")};
	
	//Answers (in order)
	String[] answers = {("D")
			,("7.seven")
			,("2.two")
			,("yesterday today and tomorrow.")
			,("1.one")
			,("envelope")
			,("bed")
			,("coat of paint")
			,("63")
			,("7")
			,("-2")
			,("easy")};

	//Add riddles to the hash-map
	public void mapKeysToValues(){
		for(int i = 0; i < questions.length; i++){
			riddles.put(questions[i], answers[i]);
		}	
	}
	public boolean getRiddle(){
		//Load key/value into the hashmap if it hasn't been done already
		if (riddles.isEmpty()) mapKeysToValues();
		
		String question = questions[random.nextInt(questions.length)];
		System.out.println(question);
		String ans = input.nextLine();
		if(riddles.get(question).startsWith("7")){
			if(ans.equals("7") || ans.equalsIgnoreCase("Seven")) return true;
		}
		if(riddles.get(question).startsWith("2")){
			if(ans.equals("2") || ans.equalsIgnoreCase("Two")) return true;
		}
		if(riddles.get(question).startsWith("1")){
			if(ans.equals("1") || ans.equalsIgnoreCase("One")) return true;
		}
		if(riddles.get(question).startsWith("y")){
			if(ans.toLowerCase().contains("yesterday") && ans.toLowerCase().contains("today") && ans.toLowerCase().contains("tomorrow")) return true;
		}
		if(riddles.get(question).startsWith("e")){
			if(ans.toLowerCase().contains("envelope")) return true;
		}
		if(riddles.get(question).startsWith("b")){
			if(ans.toLowerCase().contains("bed")) return true;
		}
		if(riddles.get(question).startsWith("c")){
			if(ans.toLowerCase().contains("paint")) return true;
		}
		if(riddles.get(question).equalsIgnoreCase(ans)) return true;
		return false;		
	}
	
}
