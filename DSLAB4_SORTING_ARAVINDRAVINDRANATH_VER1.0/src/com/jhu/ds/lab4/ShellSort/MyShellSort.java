package com.jhu.ds.lab4.ShellSort;

/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          This class has all the necessary methods to perform a shell sort.
 *          The data structure used is arrays, since there are lots of
 *          random accesses and swapping happening due to intermediate insertion sorts.
 *			
 *			Based on some gap, virtual sub lists are created out of the main list, 
 *			each of these sublists go through an insertion sort. Then another gap value is 
 *			chosen which is less than the previous one and insertion sort is performed on
 *			the sublists. This is repeated until we reach a gap value of 1.
 */

import java.util.Arrays;

public class MyShellSort {

	private int[] array;   // data structure on which the sorting is performed
	private int[] origArray; //Backup data for restore

    /*
     * Different gap intervals used in Shell Sort
     */
	private final int[][] gaps = { 
			{ 1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524 }, //Knuth's sequence	
			{ 1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341 },
			{ 1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160 },
			{ 1, 7, 19, 67, 131, 371, 1211, 3353, 9851, 29651 },
			{ 1, 3, 23, 71, 143, 379, 1237, 3413, 10433, 31001 },
	};

	/*
	 * Constructor method to allocate size to the array
	 */
	public MyShellSort(int size) {
		array = new int[size];
		origArray = new int[size];
	}

	/*
	 * Overloaded constructor used for testing
	 * 
	 * @params	input An integer array with data to be sorted
	 */
	
	public MyShellSort(int[] input) {
		origArray = Arrays.copyOf(input, input.length);
		array = Arrays.copyOf(input, input.length);
	}

	/*
	 * Method to insert keys at certain index, using random access
	 * @param	value integer representing the key/record
	 * 			index integer representing the position where the value would be inserted
	 */
	public void InsertElementsAdHoc(int value, int index){
		try{
			this.array[index] = value;
			this.origArray[index] = value;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}
		
	}
	
	/*
	 * Method which performs insertion sort on a sublist formed by taking
	 * indexes separated by a constant value. Uses the standard insertion sort
	 * algorithm. Reused coding structure from zybooks assignment
	 * 
	 *  @params	startIndex	An integer stating the startIndex of the sublist
	 *  		gap			An integer which represents the constant value separating
	 *  					the indices		
	 */
	
	public void InsertionSortInterleaved(int startIndex, int gap) {
		int temp = 0; 
		for (int i = startIndex + gap; i < this.array.length; i = i + gap) {
			int j = i;
			while (j - gap >= startIndex && this.array[j] < this.array[j - gap]) {
				temp = this.array[j];
				this.array[j] = this.array[j - gap];
				this.array[j - gap] = temp;
				j = j - gap;
			}
		}
	}
	
	/*
	 * Method which performs the shell sort, starting from the first found gap, then
	 * repeating the process until the gap value reaches 1. For each gap value, Insertion 
	 * sorts are performed on all the sublists formed. Each of the sublists then get
	 * sorted. As the gap value reduces, the entire list gets closer to a sorted order.
	 * 
	 */
	
	public void shellSort(){
		int gapStartIndex = 0;
		for (int i = 0; i < gaps.length; i++) {
			for (int j = 0; j < gaps[i].length; j++) {
				if ( this.array.length < gaps[i][j] ){
					gapStartIndex = j - 2;
					break;
				}
			}
			for (int j = gapStartIndex; j >= 0; j--) {
				for (int j2 = 0; j2 < gaps[i][j]; j2++) {
					InsertionSortInterleaved(j2, gaps[i][j]);
				}
			}
			System.out.println("Shell Sort, GAP "+ i);
			System.out.println(display_array());
			array = Arrays.copyOf(origArray, origArray.length);
			
		}
	}
	
	/*
	 * Method to get a gap sequence from the 2d array of gaps
	 */
	public int[] getGap( int index ){
		if(index >= 5){
			return null;
		}
		return gaps[index];
	}
	
	/*
	 * Overloaded method similar to ShellSort(), but executed only for one gap sequence
	 * passed to the method. 
	 * 
	 * @param	gap An integer array holding the gap sequence.
	 */
	public int[] shellSort(int[] gap) {
		array = Arrays.copyOf(origArray, origArray.length);
		return executeShellSort(gap);
	}
	
   /*
	* This method segregates the actual execution of shell sort algorithm.
	* 
	* @params	gap An integer array holding the gap sequence
	*/
	public int[] executeShellSort(int[] gap) {
		int gapStartIndex = 0;
		for (int j = 0; j < gap.length; j++) {
			if (this.array.length < gap[j]) {
				gapStartIndex = j - 2;
				break;
			}
		}
		for (int k = gapStartIndex; k >= 0; k--) {
			for (int j2 = 0; j2 < gap[k]; j2++) {
				InsertionSortInterleaved(j2, gap[k]);
			}
		}
		return this.array;
	}
	
	   /*
		* This method allows measurement of run time by segregating the actual execution of 
		* shell sort algorithm.
		* 
		* @params	gap An integer array holding the gap sequence
		*/
		private long executeShellSortwRm(int[] gap) {
			int gapStartIndex = 0;
			long start;
			long end;
			long totalTime = 0;
			start = System.nanoTime();
			for (int j = 0; j < gap.length; j++) {
				if (this.array.length < gap[j]) {
					gapStartIndex = j - 2;
					break;
				}
			}
			for (int k = gapStartIndex; k >= 0; k--) {
				for (int j2 = 0; j2 < gap[k]; j2++) {
					InsertionSortInterleaved(j2, gap[k]);
				}
			}
			end = System.nanoTime();
			totalTime = end - start;
			return totalTime;
		}
	
	/*
	 * Method which restores the original data order back onto the data structure
	 * undergoing sorting.
	 */
	public void restoreArray(){
		array = Arrays.copyOf(origArray, origArray.length);
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
	 * Method to print the contents of the array into a string
	 */
	private String display_array(){
		String str = "";
		for (int i = 0; i < this.array.length; i++) {
			str = str + this.array[i] + " "; 
			if ( i != 0 && i % 20 == 0){
				str = str + "\n";
			}
		}
		return str;
		
	}
	
	/*
	 * Method which does the sorting and returns a string with the sorted data
	 * and the total runtime in nanoseconds.
	 * 
	 * @param	gap An integer array representing the gap sequence used in the shell sort
	 */
	
	public StringBuilder sort_and_print(int[] gap){
		StringBuilder sb = new StringBuilder();
		sb.append("Sorting performed using Shell Sort\n");
		sb.append("----------------------------------\n");
		sb.append( "GAP SEQUENCE USED: { ");
		for (int k = 0; k < gap.length; k++) {
			sb.append( gap[k] + " ");
		}
		sb.append("}\n");		
		sb.append(
	"----------------------------------------------------------------------------------\n");
		sb.append("\n");
		
		long runtime = executeShellSortwRm(gap);
		sb.append("Time taken to execute the sort: " + runtime + " nanoseconds\n");
		sb.append("----------------------------------------------------------------------\n");
		sb.append("\n");
		sb.append("Sorted Data\n").append("------------").append("\n");
		for (int k = 0; k < this.array.length; k++) {
			sb.append(this.array[k]).append("\n");
		}
		restoreArray();
		return sb;
	}

}
