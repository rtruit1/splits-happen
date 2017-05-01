import java.util.ArrayList;

public class ScoreCard {

	private ArrayList<Character> charMap = new ArrayList<Character>();
	private ArrayList<Integer> scoreMap = new ArrayList<Integer>();

	void addCharMap(char x){
		charMap.add(x);
	}
	
	void addScoreMap(int score){
		scoreMap.add(score);
	}
	
	void printAll(){
		System.out.println(charMap);
		System.out.println(scoreMap);
	}
	
	int computeScore(){
		int sum=0; 
		for(int i=0; i<charMap.size(); i++){
			if(charMap.get(i) =='x'&& i<8){
				System.out.println("Found a Strike");
				sum = sum+scoreMap.get(i)+scoreMap.get(i+1)+scoreMap.get(i+2);
			}
			else if(charMap.get(i) == '/' && i<8){
				System.out.println("found a spare");
				sum = sum+scoreMap.get(i)+scoreMap.get(i+1);
			}
			else if(charMap.get(i) == '-' && i<8){
				System.out.println("found a normal operator");
				sum = sum+scoreMap.get(i);
			}
			
			else if(i == 8 || i== 9){
				if(charMap.get(i) == 'x' && i == 8){
					System.out.println("Found a strike");
					sum = sum+scoreMap.get(i);
				}
				else if(charMap.get(i) == 'x' && i == 9){
					System.out.println("Found a strike");
					sum = sum+scoreMap.get(i);
				}
				
				if(charMap.get(i) == '/' && i == 8){
					System.out.println("Found a spare");
					sum = sum+scoreMap.get(i);
				}
				else if(charMap.get(i) == '/' && i == 9){
					System.out.println("Found a spare");
					sum = sum+scoreMap.get(i);
				}
				
				if(charMap.get(i) == '-' && i == 8){
					System.out.println("Found a normal");
					sum = sum+scoreMap.get(i);
				}
				else if(charMap.get(i) == '-' && i == 9){
					System.out.println("Found a normal");
					sum = sum+scoreMap.get(i);
				}
			}
		}
		return sum; 
		
	}
}
