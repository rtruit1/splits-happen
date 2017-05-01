
public class Main {

	public static void main(String[] args){
		
		Bowl bowling = new Bowl(); 
		
		for(int i=0; i<10; i++){
			if(i<=8)
				bowling.bowlFrame(); 
			else{
				System.out.println("Bowl Last frame");
				System.out.println(i);
				bowling.bowlLastFrame();
			}
		} 
		System.out.println(); 
		System.out.println(); 
		System.out.println("Final Score is: "+bowling.computeScore()); 
	}
}
