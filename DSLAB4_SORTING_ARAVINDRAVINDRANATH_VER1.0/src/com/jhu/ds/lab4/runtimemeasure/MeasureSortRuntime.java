package com.jhu.ds.lab4.runtimemeasure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import com.jhu.ds.lab4.HeapSort.MyBinaryHeapTree;
import com.jhu.ds.lab4.IOoperations.ProcessInputFile;
import com.jhu.ds.lab4.ShellSort.MyShellSort;
import com.jhu.ds.lab4.StraightInsertionSort.MyInsertionSort;

/*package com.jhu.ds.lab4.runtimemeasure;

import com.jhu.ds.lab3.MatrixOperations.Iterative.*;

*//**
 * @author Aravind Ravindranath
 * @version 1.0
 * 
 * This class contains methods which reads input files containing data 
 * of different sizes and orders and then calls the sorting algorithms to sort
 * and in the process measure the time taken for the operation in nano seconds.
 * 
 */


public class MeasureSortRuntime{

	private static SortRuntime[] runtime = new SortRuntime[225];
	
	public static void main(String args[]){
		int k = 0;
		File folder = new File("Input");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				try {
					Vector vect = ProcessInputFile.fileReader(listOfFiles[i].getName());
					//int size = (int)Files.lines(Paths.get(listOfFiles[i].getName())).count();
					int size = (int)vect.elementAt(3);
					measure_heap_sort_run(k, size, (MyBinaryHeapTree)vect.elementAt(0), 
					listOfFiles[i].getName());
					k++;
					MyShellSort shellsort = (MyShellSort)vect.elementAt(1);
					for (int j = 0; j < 5; j++) {
						measure_shell_sort_run(k, size, shellsort, listOfFiles[i].getName(), shellsort.getGap(j));
						k++;
					}
					measure_ins_sort_run(k, size, (MyInsertionSort)vect.elementAt(2), 
					listOfFiles[i].getName());
					k++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Size    ").append("Runtime in nanoseconds         ").append(
				  "Sort Algorithm(H, S or I)   ").append("GAP data for S   ").append(
						  "Name of File").append("\n");
		for (int i = 0; i < runtime.length; i++) {
			if(runtime[i] == null){
				continue;
			}
			sb.append(runtime[i].getSize()).append("\t").append(runtime[i].getRuntime()).append(
					"\t").append(runtime[i].getSortType()).append("\t").append(
							runtime[i].print_gap().toString()).append("\t").append(
									runtime[i].getFilename()).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static void measure_heap_sort_run(int i, int size, MyBinaryHeapTree heapTree,
														String filename){
		long start;
		long end;
		long totalTime;
		start = System.nanoTime();
		heapTree.heapify(size);
		heapTree.heapSort();
		end = System.nanoTime();
		totalTime = end - start;
		runtime[i] = new SortRuntime(size, totalTime, SortRuntime.heapSort, filename);
        
	}

	private static void measure_shell_sort_run(int i, int size, MyShellSort shellSort, 
												String filename, int[] gap){
		long start;
		long end;
		long totalTime;
		start = System.nanoTime();
		shellSort.executeShellSort(gap);
		end = System.nanoTime();
		totalTime = end - start;
		runtime[i] = new SortRuntime(size, totalTime, SortRuntime.shellSort, filename, gap);
		shellSort.restoreArray();
        
	}
	
	private static void measure_ins_sort_run(int i, int size, MyInsertionSort insSort, 
																	String filename ) {
		long start;
		long end;
		long totalTime;
		start = System.nanoTime();
		insSort.InsertionSort();
		end = System.nanoTime();
		totalTime = end - start;
		runtime[i] = new SortRuntime(size, totalTime, SortRuntime.insSort, filename);
	}	
	
	
}
