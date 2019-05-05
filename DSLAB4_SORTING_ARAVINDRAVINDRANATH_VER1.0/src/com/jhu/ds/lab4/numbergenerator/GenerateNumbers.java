/**
 * 
 */
package com.jhu.ds.lab4.numbergenerator;


import java.util.Scanner;




/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          The class contains logic to read a file placed in the Project
 *          Folder. The input file would have the square matrices of any order
 *          to be read. The output file will contain the square matrices along
 *          with its calculated determinant. This class will take the role of
 *          the driver.
 *
 */
public class GenerateNumbers {
	
	public static void main(String args[]){
		int size = 0;
		System.out.println("Enter the size: ");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			size = scan.nextInt();
			break;
		}
		scan.close();
		long arr[] = new long[size];
		for (int i = 0; i < arr.length; i++) {
			long num = Math.round(Math.random()/Math.random()*1000);
			for (int j = 0; j < i; j++) {
				if(num == arr[j]){
					num = Math.round(Math.random()/Math.random()*1000);
				}
			}

			arr[i] = num;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
		
	}

	
	
}
