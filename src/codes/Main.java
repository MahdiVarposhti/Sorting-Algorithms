package codes;

import java.util.Scanner;

public class Main {
	
	private static Scanner input;
	final static int size = 100; // Size of the array

	public static void main(String[] args) {
		
		int choice, searchNum, searchIndex;
		int[] userArray = new int[size];
		
		input = new Scanner(System.in);
		
		// do-while loop for printing the menu
		do{
			System.out.println(" 0. Exit the program");
			
			System.out.println(" 1. Display the array");
			System.out.println(" 2. Populate the array sequentially");
			System.out.println(" 3. Populate the array randomly");
			System.out.println(" 4. Shuffle the array");
			System.out.println(" 5. Check if the array is sorted");
			
			System.out.println(" 6. Linear Search");
			System.out.println(" 7. Binary Search");
			
			System.out.println(" 8. Bubble Sort");
			System.out.println(" 9. Insertion Sort");
			System.out.println("10. Selection Sort");
			System.out.println("11. Radix Sort");
			
			// Take user's input for the menu selection
			choice = getInput();
			
			// Execute the corresponding methods for each menu item
			switch(choice){
			
				case 1: Arrays.printArray(userArray);
						System.out.println();
				break;
					
				case 2: userArray = Arrays.popSequential(userArray, 1);
				break;
					
				case 3:  userArray = Arrays.popRandom(userArray, 1, 100);
				break;
					
				case 4: userArray = Arrays.shuffle(userArray);
				break;
					
				case 5: System.out.println( (Arrays.isSorted(userArray)) ? "The array is sorted" : "The array is not sorted"  );
				break;
					
				case 6: System.out.println("What number are you looking for? ");
						searchNum = getInput();
						searchIndex = Arrays.linearSearch(userArray, searchNum);
						System.out.println( (searchIndex == -1) ?  "This number doesn't exist!" : "This number is located at " + searchIndex );
				break;
				
				case 7: System.out.println("What number are you looking for? ");
						searchNum = getInput();
						searchIndex = Arrays.binarySearch(userArray, searchNum);
						System.out.println( (searchIndex == -1) ?  "This number doesn't exist!" : "This number is located at " + searchIndex );
				break;
				
				case 8: userArray = Arrays.bubbleSort(userArray);
				break;
				
				case 9: userArray = Arrays.insertionSort(userArray);
				break;
				
				case 10: userArray = Arrays.selectionSort(userArray);
				break;
				
				case 11: userArray = Arrays.radixSort(userArray);
				break;
					
			}
			
		} while(choice!=0);
		
		// Close the input scanner to prevent memory leak
		input.close();

	}
	
	// Method for taking the user input and error-trapping it
	public static int getInput(){
		
		int num = 0;
		boolean valid = true;
		
		do {
			try{
				num = input.nextInt();
				valid = true;
					
			} catch(Exception e){
				
				System.out.println("Invalid Entry\nTry Again: ");
				input.next();
				valid = false;
				
			}
			
		} while(!valid);
		
		return num;
		
	}
	
}