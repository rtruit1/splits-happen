
public class Main {

	public static void main(String[] args){
		
		Bowl bowling = new Bowl(); 
		
		for(int i=0; i<=8; i++){
			bowling.bowlFrame(); 
		}
		bowling.bowlLastFrame(); 
		
		System.out.println("Final Score is: "+bowling.computeScore()); 
	}
}
