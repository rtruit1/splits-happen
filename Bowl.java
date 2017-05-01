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
		char roll_two;
		char roll_one;
		char roll_three;
		int add, one, two, three, one1, two1, three1; 
		int roundScore = 0; 
		System.out.println("Enter first ball scoreeee: ");
		roll_one = input.next().charAt(0); 
		
		
		if(roll_one == 'X'||roll_one == 'x'){
			roll_one ='9'; 

			System.out.println("Enter second ball score");
			roll_two = input.next().charAt(0);
			one = (int)Character.getNumericValue(roll_one);
			two = (int)Character.getNumericValue(roll_two);
			add =  ((one+1) + two);
			
			if(roll_two =='x'||roll_two=='X'){
				System.out.println("Enter final ball score");
				roll_three = input.next().charAt(0);
				one  = (int)Character.getNumericValue(roll_one);
				two = (int)Character.getNumericValue(roll_two);
				three = (int)Character.getNumericValue(roll_three); 
				
				add =  (add+three);
				
			}
			 
			
			
			scoreCard.addCharMap('-');
			scoreCard.addScoreMap(add);
			
		}
		else{
			System.out.println("Enter second ball score");
			roll_two = input.next().charAt(0);
			
			one1 = (int)Character.getNumericValue(roll_one);
			two1 = (int)Character.getNumericValue(roll_two);
			three1 =  (one1 + two1); 
			
			
			if(two1 == 10 -(int)Character.getNumericValue(roll_one)){
				System.out.println("Spare!");
				scoreCard.addCharMap('/');
				scoreCard.addScoreMap(three1);
			}
			else{
				scoreCard.addCharMap('-');
				scoreCard.addScoreMap(three1);
			}

			
		} 
		
		scoreCard.printAll(); 
	}
	
	
	int computeScore(){
		return scoreCard.computeScore(); 
	}
	
	

}
