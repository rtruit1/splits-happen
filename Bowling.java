import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Bowling {
	

	public static void main(String[] args) {
		LinkedList<Frame> frameList = new LinkedList<Frame>();
		LinkedList<Frame2> numberList = new LinkedList<Frame2>();

		Scanner input = new Scanner(System.in);
		System.out.println("Bowling score generator, please use the following symbols for scoring");
		System.out.println("If you get a strike, enter a lowercase x");
		System.out.println("If you get a spare, enter a / for the second symbol");
		System.out.println("If you completely miss for the roll, enter a zero");
		System.out.println();
		System.out.println();

		for (int i = 1; i <= 10; i++) {
			char roll_1 = ' ', roll_2 = ' ', roll_3 = ' ';

			if (i == 10) {
				System.out.println("10th Frame, enter first roll");
				roll_1 = input.nextLine().charAt(0);
				if (roll_1 == 'x') {
					System.out.println("Strike, enter second roll");
					roll_2 = input.nextLine().charAt(0);
					if (roll_2 == 'x') {
						System.out.println("Strike, enter final roll");
						roll_3 = input.nextLine().charAt(0);
					} else {
						System.out.println("Enter value for final roll");
						roll_3 = input.nextLine().charAt(0);
					}
				} else {
					System.out.println("Enter roll for ball 2");
					roll_2 = input.nextLine().charAt(0);
					if (roll_2 == '/') {

						System.out.println("Spare! enter the final ball");
						roll_3 = input.nextLine().charAt(0); 
					}
				}
			} else {
				System.out.println("please enter score for roll 1");
				roll_1 = input.nextLine().charAt(0);
				if (roll_1 == 'x') {
					System.out.println("Strike bowling next round");
					roll_2 = '0';
				} else {
					System.out.println("Enter score for roll 2");
					roll_2 = input.nextLine().charAt(0);
					if (roll_2 == '/') {
						System.out.println("Spare");
						roll_2 = '/';
					}
				}

			}
			frameList.add(new Frame(roll_1, roll_2, roll_3));
		}

		//numberize the linked list of characters
		numberList = numberize(frameList);

		//compute and print the final score. 
		System.out.println("Your score will be: " +calculateScore(numberList));
		
	}
	
	
	//========================start of functions==========================//
	
	//numberize will take a linked list of characters, and turn it into a linked list of integers to be sent to calculation//
	public static LinkedList<Frame2> numberize(LinkedList<Frame> list) {
		int r1 = 0, r2 = 0, r3 = 0;
		LinkedList<Frame2> numberList = new LinkedList<Frame2>();//new LinkedList for integers

		for (int i = 0; i <= 9; i++) {
			if (i == 9) {
				if (list.get(i).roll_1 == 'x') {
					r1 = 10;
					if (list.get(i).roll_2 == 'x') {
						r2 = 10;

						if (list.get(i).roll_3 == 'x') {
							r3 = 10;
						} else {
							r3 = (int) Character.getNumericValue(list.get(i).roll_3);
						}

					} else {
						r2 = (int) Character.getNumericValue(list.get(i).roll_2);
						r3 = (int) Character.getNumericValue(list.get(i).roll_3);
					}
				} else if (list.get(i).roll_2 == '/') {
					r1 = (int) Character.getNumericValue(list.get(i).roll_1);
					r2 = 10 - (int) Character.getNumericValue(list.get(i).roll_1);
					r3 = (int) Character.getNumericValue(list.get(i).roll_3);

				} else {
					r1 = (int) Character.getNumericValue(list.get(i).roll_1);
					r2 = (int) Character.getNumericValue(list.get(i).roll_2);
				}

				numberList.add(new Frame2(r1, r2, r3));

			} else {
				if (list.get(i).roll_1 == 'x') {
					numberList.add(new Frame2(10, 0, 0));
				} else if (list.get(i).roll_2 == '/') {
					numberList.add(new Frame2((int) Character.getNumericValue(list.get(i).roll_1),
							(10 - (int) Character.getNumericValue(list.get(i).roll_1)), 0));
				} else {
					numberList.add(new Frame2((int) Character.getNumericValue(list.get(i).roll_1),
							(int) Character.getNumericValue(list.get(i).roll_2), 0));
				}
			}
		}
		return numberList;
	}


	private static int calculateScore(LinkedList<Frame2> numberList) {
		int scoreSoFar = 0;
		for (int i = 0; i <= 9; i++) {
			if (i == 9) {
				if (numberList.get(i).roll_1 == 10)
					scoreSoFar = scoreSoFar + 10 + numberList.get(i).roll_2 + numberList.get(i).roll_3;
				else if (numberList.get(i).roll_1 + numberList.get(i).roll_2 == 10)
					scoreSoFar = scoreSoFar + 10 + numberList.get(i).roll_2;
				else
					scoreSoFar = scoreSoFar + numberList.get(i).roll_1 + numberList.get(i).roll_2;
			}else {

				if (numberList.get(i).roll_1 == 10 && numberList.get(i + 1).roll_1 == 10 && i < 8) {
					scoreSoFar = scoreSoFar + 10 + 10 + numberList.get(i + 2).roll_1;
				} else if (numberList.get(i).roll_1 == 10) {
					scoreSoFar = scoreSoFar + 10 + numberList.get(i + 1).roll_1 + numberList.get(i + 1).roll_2;
				} else if ((numberList.get(i).roll_1 + numberList.get(i).roll_2 == 10)) {
					scoreSoFar = scoreSoFar + 10 + numberList.get(i + 1).roll_1;
				}

				else {
					scoreSoFar = scoreSoFar + numberList.get(i).roll_1 + numberList.get(i).roll_2;
				}
			}
		}
		return scoreSoFar;
	}
}
