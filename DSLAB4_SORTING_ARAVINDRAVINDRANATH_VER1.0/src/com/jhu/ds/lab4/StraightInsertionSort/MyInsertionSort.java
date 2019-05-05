package com.jhu.ds.lab4.StraightInsertionSort;
/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          The class contains methods to execute straight insertion sort.
 *          Data is stored in an array and then the insertion sort is performed 
 *          on the array elements 
 *
 */
public class MyInsertionSort {

	private int[] array;  //Data structure to hold the data

	/*
	 * Constructor method allocating memory to the array to store data
	 * 
	 * @param	size An integer to define the number of data records
	 */
	public MyInsertionSort(int size) {
		array = new int[size];
	}

	/*
	 * Overloaded Constructor method receiving data from an array.
	 * Used for testing.
	 * 
	 * @param	input An integer array which holds data in any order
	 */
	
	public MyInsertionSort(int[] input){
		array = input;
	}
	
	/*
	 * Method to insert keys at certain index, using random access
	 * @param	value integer representing the key/record
	 * 			index integer representing the position where the value would be inserted
	 */
	public void InsertElementsAdHoc(int value, int index) {
		this.array[index] = value;
	}

	/*
	 * The main method which performs the insertion sort. The logic works by partitioning the data
	 * list into ordered and unordered sections. Starts with the first element considered sorted.
	 * Then the second element, which is the first element in the unordered part is compared against
	 * the first one and if less, it is swapped. Then this is repeated for the 3rd element, but this 
	 * time the number of comparisons increase to 2. For the 4 th element to 3 comparisons and so on 
	 * and so forth. The coding idea has been obtained from zybooks.
	 */
	public void InsertionSort() {
		for (int i = 1; i < array.length; ++i) {
			int j = i;
			// Insert numbers[i] into sorted part
			// stopping once numbers[i] in correct position
			while (j > 0 && array[j] < array[j - 1]) {
				// Swap numbers[j] and numbers[j - 1]
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				--j;
			}
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String str = "";
		for (int i = 0; i < this.array.length; i++) {
			str = str + this.array[i] + " "; 
		}
		return str;
		
	}

	/*
	 * Method which does the sorting and returns a string with the sorted data
	 * and the total runtime in nanoseconds.
	 * 
	 * @param	size An integer representing the size of the data
	 */
	public StringBuilder sort_and_print(){
		StringBuilder sb = new StringBuilder();
		sb.append("Sorting performed using Insertion Sort\n");
		sb.append("--------------------------------------\n");			
		long runtime = executeInsertionSortwRm();
		sb.append("Time taken to execute the sort: " + runtime + " nanoseconds\n");
		sb.append("----------------------------------------------------------------------\n");
		sb.append("\n");
		sb.append("Sorted Data\n").append("------------").append("\n");
		for (int k = 0; k < this.array.length; k++) {
			sb.append(array[k]).append("\n");
		}
		return sb;
	}

   /*
	* This method allows measurement of run time by segregating the actual execution of 
	* heap sort algorithm.
	* 
	* @params	size An integer holding the size of the data
	*/
	private long executeInsertionSortwRm() {
		long start;
		long end;
		long totalTime = 0;
		start = System.nanoTime();
		InsertionSort();
		end = System.nanoTime();
		totalTime = end - start;
		return totalTime;
	}	
	
	
}
