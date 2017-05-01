import java.util.Scanner;

public class Bowl {
	Scanner input = new Scanner(System.in);
	
	ScoreCard scoreCard = new ScoreCard(); 
	
	public void bowlFrame(){
		char roll_two;
		char roll_one;
		int roundScore = 0; 
		System.out.println("Enter first ball score: ");
		roll_one = input.next().charAt(0); 
		
		
		if(roll_one == 'X'||roll_one == 'x'){
			roll_one ='9'; 
			roll_two='1';
			int one = (int)Character.getNumericValue(roll_one);
			int two = (int)Character.getNumericValue(roll_two);
			int three =  (one + two); 
			System.out.println("Strike! added "+three);
			
			
			scoreCard.addCharMap('x');
			scoreCard.addScoreMap(three);
		}
		else{
			System.out.println("Enter second ball score");
			roll_two = input.next().charAt(0);
			
			int one = (int)Character.getNumericValue(roll_one);
			int two = (int)Character.getNumericValue(roll_two);
			int three =  (one + two); 
			
			
			if(two == 10 -(int)Character.getNumericValue(roll_one)){
				System.out.println("Spare!");
				scoreCard.addCharMap('/');
				scoreCard.addScoreMap(three);
			}
			else{
				scoreCard.addCharMap('-');
				scoreCard.addScoreMap(three);
			}

			
		} 
		
		scoreCard.printAll(); 
	}
	
	
	
	public void bowlLastFrame(){
		
	}
	
	
	int computeScore(){
		return scoreCard.computeScore(); 
	}
	
	

}
