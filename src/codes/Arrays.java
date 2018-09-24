/*
 * Author: Mahdi Varposhti
 * Version: 1.0
 * 
 */

package codes;

//A class which includes methods for searching and sorting arrays using different algorithms

public class Arrays {
	
	// Method for generating a random number in the specified range
	public static int generateRand(int min, int max){
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	// Method for printing the array
	public static void printArray(int[] array){
		
		System.out.println();
		
		for(int i=0; i < array.length; i++){
			
			System.out.print(array[i] + " ");
			
			// Line break every 10 lines
			if((i+1)%10 == 0){
				System.out.println();
			}
		}
	}
	
	// Method for populating the array sequentially
	public static int[] popSequential(int[] array, int start){
		
		for(int i=0; i < array.length; i++){
			array[i] = start + i;
		}
		
		return array;
	}
	
	// Method for populating the array randomly
	public static int[] popRandom(int[] array, int min, int max){
		
		for(int i=0; i < array.length; i++){
			array[i] = generateRand(min, max);
		}
		
		return array;
		
	}
	
	// Method for shuffling the array
	public static int[] shuffle(int array[]){
		
		for(int i=0; i < array.length; i++){
			int temp = array[i];
			int index = generateRand(0, array.length-1);
			array[i] = array[index];
			array[index] = temp;
		}
		
		return array;
	}
	
	// Method for checking if the array is sorted
	public static boolean isSorted(int array[]){
		
		for(int i=1; i < array.length; i++){
			if(array[i] < array[i-1]){
				return false;
			}
		}
		
		return true;
	}
	
	// Method for searching for a value in the array using linear search 
	public static int linearSearch(int array[], int num){
		
		for(int i=0; i < array.length; i++){
			if(array[i] == num){
				return i ; // If found, return the location of the number
			}
		}
		
		return -1; // If nothing found, return -1
	}
	
	// Method for searching for a value in the array using binary search algorithm
	public static int binarySearch(int array[], int num){
		
		// Sort the array first
		array = insertionSort(array);
		
		int low = 0;
		int high = array.length;
		
		while (low <= high){
			int mid = (low + high)/2;
			
			if(array[mid] == num){
				
				return mid; // If the number is in the middle, it's found, return its location
				
			}else if(num < array[mid]){
				
				high = mid-1; // Select the lower half
				
			}else{
				low = mid+1; // Select the higher half
			}
		}
		
		return -1; // Return -1, if not found
	}
	
	// Method for sorting the array using the bubble sort algorithm
	public static int[] bubbleSort(int[] array){
		
		boolean isSorted = false;
		
		while (!isSorted){
			isSorted = true;
			
			for(int i=0; i < array.length-1; i++){
				if(array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					isSorted = false;
				}
			}
		}
		
		return array;
	}
	
	// Utility method for shifting the array
	public static int[] shift(int[] array, int start, int end, int num){
		for( ; end>start; end--){
			array[end] = array[end-1];
		}
		array[start] = num;
		
		return array;
	}
	
	// Method for sorting the array using the insertion sort algorithm
	public static int[] insertionSort(int[] array){
		
		for(int i=1; i < array.length; i++){
			
			for(int j=1; j<=i; j++){
				
				if(array[i] >= array[j-1] && array[i] < array[j]){
					
					array = shift(array, j, i, array[i]);
					break;
					
				}else if(array[i] < array[0]){
					
					array = shift(array, 0, i, array[i]);
					break;
					
				}else if(array[i] == array[j]){
					
					array = shift(array, j, i, array[i]);
					break;
					
				}
			}
		}
		
		return array;
	}
	
	// Method for sorting the array using the selection sort algorithm
	public static int[] selectionSort(int[] array){
		
		for(int i=0; i < array.length-1; i++){
			int min = array[i];
			int minPos = i;
			for(int j=i+1; j < array.length; j++){
				if(array[j] < min){
					min = array[j];
					minPos = j;
				}
			}
			
			array[minPos] = array[i];
			array[i] = min;
		}
		
		return array;
	}
	
	// Utility method for getting the nth digit of a given number
	public static int getDigit(int num, int place){
		return (int) Math.floor( num % (int)(Math.pow(10, place)) / ((int)(Math.pow(10, place-1))) );
	}
	
	// Utility method for getting the number of digits of a given number
	public static int getNumOfDigits(int num){
		return (int) Math.floor(Math.log10(num)) + 1;
	}
	
	// Utility method for getting the maximum number of digits in an array
	public static int getMaxDigits(int[] array){
		int maxDigits = 0;
		
		for(int i=0; i < array.length; i++){
			if( getNumOfDigits( array[i] ) > maxDigits){
				maxDigits = getNumOfDigits( array[i] );
			}
		}
		
		return maxDigits;
	}
	
	// Method for sorting the array using the radix sort algorithm
	public static int[] radixSort(int[] array){
		
		int maxDigits = getMaxDigits(array);
		
		for(int digit=1; digit <= maxDigits; digit++){
			for(int i=0; i < array.length; i++){
				for(int j=0; j < i; j++){
					
					if(getDigit(array[i], digit) < getDigit(array[j], digit)){
						array = shift(array, j, i, array[i]);
						break;
					}
					
					if(getDigit(array[i], digit) == getDigit(array[j], digit)){
						if(j == array.length-1 && getDigit(array[i], digit) < getDigit(array[j+1], digit)){
							int tempj = j+1;
							array = shift(array, tempj, i, array[i]);
							break;
						}
					}
				}
			}
		}
		
		return array;
	}
	
}
