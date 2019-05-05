package com.jhu.ds.lab4.HeapSort;

/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          The class models a max heap and then provides methods
 *          to execute creation of a max heap and then do a sort on 
 *          the max heap. An object of the binary search tree 
 *          MySeqArrayBinaryTree is the main driving attribute on which building
 *          of a heap and sorting is performed. 
 *
 */

public class MyBinaryHeapTree {

	private MySeqArrayBinaryTree binArr = null; //BST on which the heap is built
	
	/*
	 * Constructor to instantiate the BST. 
	 * @params	size An integer which allocates memory to hold the nodes
	 */
	public MyBinaryHeapTree(int size) {
		binArr = new MySeqArrayBinaryTree(size);
	}

	/*
	 * Constructor to instantiate the BST, default size used. Not used
	 * productively.
	 */
	public MyBinaryHeapTree() {
		binArr = new MySeqArrayBinaryTree();
	}

	/*
	 * Method to insert keys at certain index, using random access
	 * @param	value integer representing the key/record
	 * 			index integer representing the position where the value would be inserted
	 */
	public void InsertElementsAdHoc(int value, int index) {
		binArr.InsertElementsAdHoc(value, index);
	}

	/*
	 * Method to insert keys at the right index, following the IOT sequence
	 * @param	x integer representing the key/record
	 *
	 */
	public void insertTree(int x) {
		if (binArr.getRootNode() == -2) {
			binArr.makeTree(0, x);
			return;
		} else {
			int index = 0;
			int parent = 0;
			int value = 0;
			while ((value = binArr.getCurrNodeValue(index)) != -2) {
				parent = index;
				if (value != -2 && x < value) { //left node
					index = index * 2 + 1;
				} else if (value != -2 && x >= value) { //right node
					index = index * 2 + 2;
				}

			}
			if (x < binArr.getCurrNodeValue(parent)) { //left node
				binArr.setLeftNode(parent, x);
			} else {
				binArr.setRightNode(parent, x); //right node
			}
		}
	}

	
	/*
	 * Method to find the index of a given record/key. If not found, value is a -2.
	 * @param	x integer value depicting the value to be searched in the tree. 
	 * 
	 */
	public int search_tree(int x) {
		int index = 0;
		int value = 0;
		while ((value = binArr.getCurrNodeValue(index)) != -2 && value != x) {
			if (x < value) {
				index = index * 2 + 1;
			} else if (x > value) {
				index = index * 2 + 2;
			}

		}
		if (value == -2) {
			return -2;
		} else {
			return index;
		}

	}
	
	/*
	 * Method to traverse the BST tree in order and then print the keys in IOT sequence.
	 * The call is recursive, navigating to the leftmost node of the tree and then
	 * coming back up to the root and then going all the way to the rightmost node.
	 * Used for testing purposes only.
	 * 
	 * @param	index integer representing the position of the current node in the 
	 * 			traversal algorithm.
	 */
	public void Traverse(int index) {
		if (binArr.getCurrNodeValue(index) != -2) {
			Traverse(binArr.getLeftNodeIndex(index));
			System.out.println(binArr.getCurrNodeValue(index));
			Traverse(binArr.getRightNodeIndex(index));
		}
	}

	/*
	 * Method to display the internal nodes in a tree format
	 */
	public void display_tree() {
		binArr.display_nodes();
	}

	/*
	 * Method to get the array which is expected to be sorted.
	 */
	public int[] getSortedArray(){
		return binArr.getSortedArray();
	}
	
	/*
	 * This method builds a max heap binary tree. Starting from the largest internal 
	 * node index, percolating down to every successor internal node, doing a swap 
	 * if the max heap condition is violated. The idea of the logic is borrowed from zybooks. 
	 * After every node is visited, compared and swapped if necessary, a max heap binary
	 * tree is built. Reused some logic from zybooks
	 *  
	 */
	public void heapify() {
		int maxIndex = (int) Math.floor(binArr.getSize() / 2) - 1;
		for (int i = maxIndex; i >= 0; i--) {
			for (int j = i; j <= maxIndex; j++) {
				if (binArr.getRightNodeValue(j) > binArr.getCurrNodeValue(j)) {
					int temp = binArr.getCurrNodeValue(j);
					binArr.nodes[j] = binArr.getRightNodeValue(j);
					binArr.setHeapRightNode(j, temp);
				}
				if (binArr.getLeftNodeValue(j) > binArr.getCurrNodeValue(j)) {
					int temp = binArr.getCurrNodeValue(j);
					binArr.nodes[j] = binArr.getLeftNodeValue(j);
					binArr.setHeapLeftNode(j, temp);
				}

			}

		}
	}
	
	/*
	 * This method is similar to the method above, except that the number of node
	 * is passed from the caller.
	 * 
	 * @params	size An integer value representing the count of records/keys.
	 */
	public void heapify(int size) {
		int maxIndex = (int) Math.floor(size / 2) - 1;
		for (int i = maxIndex; i >= 0; i--) {
			for (int j = i; j <= maxIndex; j++) {
				if (binArr.getRightNodeValue(j) > binArr.getCurrNodeValue(j) &&
						binArr.getRightNodeIndex(j) < size ) {
					int temp = binArr.getCurrNodeValue(j);
					binArr.nodes[j] = binArr.getRightNodeValue(j);
					binArr.setHeapRightNode(j, temp);
				}
				if (binArr.getLeftNodeValue(j) > binArr.getCurrNodeValue(j) && 
						binArr.getLeftNodeIndex(j) < size ) {
					int temp = binArr.getCurrNodeValue(j);
					binArr.nodes[j] = binArr.getLeftNodeValue(j);
					binArr.setHeapLeftNode(j, temp);
				}

			}

		}
	}
	
	/*
	 * This method continuously swaps the maximum number with the number in 
	 * the last index. Then the array index is reduced by 1 and a heapify is executed 
	 *  again, but this time the end index is out. This process is repeated until the
	 *  end index is 0.
	 */
	
	public void heapSort() {
		for (int i = binArr.getSize() - 1; i > 0; i--) {
			int temp = binArr.nodes[0];
			binArr.nodes[0] = binArr.nodes[i];
			binArr.nodes[i] = temp;
			heapify(i);
		}
	}
	
	/*
	 * Method which does the sorting and returns a string with the sorted data
	 * and the total runtime in nanoseconds.
	 * 
	 * @param	size An integer representing the size of the data
	 */
	public StringBuilder sort_and_print(int size){
		StringBuilder sb = new StringBuilder();
		sb.append("Sorting performed using Heap Sort\n");
		sb.append("----------------------------------\n");			
		long runtime = executeHeapSortwRm(size);
		sb.append("Time taken to execute the sort: " + runtime + " nanoseconds\n");
		sb.append("----------------------------------------------------------------------\n");
		sb.append("\n");
		sb.append("Sorted Data\n").append("------------").append("\n");
		int[] array = binArr.getSortedArray();
		for (int k = 0; k < array.length; k++) {
			/*
			 * There could be 1 or 2 empty nodes in the tree due to 2*index + 2 access made.
			 * Size can be greater than the keys by 1 or 2 nodes.  
			 */
			if (array[k] == -2){  
				continue;      
			}
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
	private long executeHeapSortwRm(int size) {
		long start;
		long end;
		long totalTime = 0;
		start = System.nanoTime();
		heapify(size);
		heapSort();
		end = System.nanoTime();
		totalTime = end - start;
		return totalTime;
	}
	
}
