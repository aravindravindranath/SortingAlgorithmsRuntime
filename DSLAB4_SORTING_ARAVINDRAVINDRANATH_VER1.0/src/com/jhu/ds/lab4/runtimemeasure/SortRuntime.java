package com.jhu.ds.lab4.runtimemeasure;

/**
 * @author Aravind Ravindranath
 * @version 1.0
 * 
 * This class contains attributes and methods to store
 * measurements done on sorting algorithms.
 * 
 */
public class SortRuntime {

	private long runtime;
	private int size;
	private char sorttype;
	private int[] gap;
	private String filename;
	
	public final static char shellSort = 'S';
	public final static char heapSort = 'H';
	public final static char insSort = 'I';
	
	SortRuntime( int size, long runtime, char sorttype, String filename){
		this.size = size;
		this.runtime = runtime;
		this.sorttype = sorttype;
		this.filename = filename;
	}
	
	SortRuntime( int size, long runtime, char sorttype, String filename, int[] gap){
		this(size, runtime, sorttype, filename);
		this.gap = gap;
	}
	
	public String getFilename() {
		return this.filename;
	}

	public long getRuntime(){
		return this.runtime;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public char getSortType(){
		return this.sorttype;
	}
	
	public int[] getGap(){
		return this.gap;
	}
	
	public StringBuilder print_gap(){
		StringBuilder sb = new StringBuilder();
		if (gap == null || gap.length == 0){
			return sb;
		}
		sb.append( "{ ");
		for (int i = 0; i < gap.length; i++) {
			sb.append(gap[i] + ", ");
		}
		sb.replace(sb.length()-2, sb.length(), "");
		sb.append( "}");
		return sb;
	}
	
	
}
