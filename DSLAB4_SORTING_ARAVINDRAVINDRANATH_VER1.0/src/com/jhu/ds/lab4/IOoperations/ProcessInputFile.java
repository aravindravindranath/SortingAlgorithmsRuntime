/**
 * 
 */
package com.jhu.ds.lab4.IOoperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;

import com.jhu.ds.lab4.HeapSort.MyBinaryHeapTree;
import com.jhu.ds.lab4.ShellSort.MyShellSort;
import com.jhu.ds.lab4.StraightInsertionSort.MyInsertionSort;


/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          The class contains logic to read a file placed in the Project
 *          Folder. The input file would have the data in any order to be read
 *          and sorted. The output file will contain the sorted data, with the 
 *          total time taken for the sort. This class will take the role of
 *          the driver.
 *          One input file will lead to 7 output files, one for Heap Sort, 5 for Shell
 *          Sorts with different gap sequences and one for Insertion Sort. The output file name 
 *          provided in the program argument is suffixed with the type of sort and additionally 
 *          with gap number for shell sort run. 
 *
 */
public class ProcessInputFile {

	/**
	 * This is the main method which will be called in this project. The input
	 * file which contains data in any order and an output file name which contains the
	 * results are passed as arguments. These are passed into another method for
	 * the actual parsing of the input file data to instantiate arrays, after
	 * which the data goes through sorting process using heap sort, shell sort and insertion
	 * sort.
	 * 
	 * @param args
	 *            The normal dynamic arguments passed to the main. Two strings,
	 *            one representing the input file path along with the file name
	 *            and the other one the output file path along with the file
	 *            name. The output file name is used as a template and more output
	 *            files are generated by suffixing the name with the type of sort.
	 */
	public static void main(String[] args) {
        
		try {
			fileReader(args[0], args[1]);
			System.out.println("Processing Completed. Please Check the output files " + args[1] + "*");
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("Please specify valid file names as arguments");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter the input file and the output file as " + "the two arguments");
			System.exit(1);
		}

	}

	/**
	 * This is the method which will call File I/O JAVA library methods. The
	 * input file will be opened and using a buffered reader, the contents will
	 * be read line by line. A handle to output file will also be instantiated
	 * so that the results can be written into it as well. The string in each
	 * line will be traversed integer by integer and fed into a array data structure
	 * in the Binary Heap Tree and in the Shell Sort class. The methods in those class 
	 * then sorts the data using the respective algorithms.
	 * 
	 * @param InpFile
	 *            Input File which contains the string for analysis OutFile
	 *            Output file name which is suffixed with the type of sort generating
	 *            more files.
	 * 
	 */

	public static void fileReader(String InpFile, String OutFile ) 
																throws IOException {
		String line;
		FileReader inputStream = new FileReader(InpFile); // input file
		BufferedReader bReader = new BufferedReader(inputStream); // line reader
		
		int lines = (int)Files.lines(Paths.get(InpFile)).count();
		MyBinaryHeapTree heapTree = new MyBinaryHeapTree(lines);
		MyShellSort shellSort = new MyShellSort(lines);
		MyInsertionSort insSort =  new MyInsertionSort(lines);
		int i = 0;
		while ((line = bReader.readLine()) != null){
			int value = Integer.parseInt(line);
			heapTree.InsertElementsAdHoc(value, i);
			shellSort.InsertElementsAdHoc(value, i);
			insSort.InsertElementsAdHoc(value, i);
			i++;
		}
		bReader.close();
		FileWriter outputStream = new FileWriter(OutFile+"heapSort"); // output file
		outputStream.write(heapTree.sort_and_print(lines).toString());
		outputStream.close();
		for (int j = 0; j < 5; j++) {
			outputStream = new FileWriter(OutFile+"shellSortGap"+j);
			outputStream.write(shellSort.sort_and_print(shellSort.getGap(j)).toString());
			outputStream.close();
		}
		outputStream = new FileWriter(OutFile+"insSort"); // output file
		outputStream.write(insSort.sort_and_print().toString());
		outputStream.close();
			
	}

	/*
	 * Very similar to the method above, used in runtime measurements for data
	 * of any order.
	 */
	@SuppressWarnings("rawtypes")
	public static Vector fileReader(String InpFile) throws IOException {
		String line;
		Vector vect = new Vector();
		FileReader inputStream = new FileReader("Input/"+InpFile); // input file
		BufferedReader bReader = new BufferedReader(inputStream); // line reader

		int lines = (int) Files.lines(Paths.get("Input/"+InpFile)).count();
		MyBinaryHeapTree heapTree = new MyBinaryHeapTree(lines);
		MyShellSort shellSort = new MyShellSort(lines);
		MyInsertionSort insSort = new MyInsertionSort(lines);
		int i = 0;
		while ((line = bReader.readLine()) != null) {
			int value = Integer.parseInt(line);
			heapTree.InsertElementsAdHoc(value, i);
			shellSort.InsertElementsAdHoc(value, i);
			insSort.InsertElementsAdHoc(value, i);
			i++;
		}
		bReader.close();
		vect.addElement(heapTree);
		vect.addElement(shellSort);
		vect.addElement(insSort);
		vect.addElement(lines);
		return vect;
	}	
	
}
