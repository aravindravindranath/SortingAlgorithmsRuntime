package com.jhu.ds.lab4.HeapSort;

/**
 * @author ARAVIND RAVINDRANATH
 * @version 1.0
 *
 *          The class contains the structure and methods to define and operate 
 *          binary search tree. The class uses an array based implementation
 *          to model the binary search tree.
 *
 */


public class MySeqArrayBinaryTree {

	int[] nodes;  //internal nodes and leafs of a tree,

	/*
	 * Constructor method to allocate memory for the array
	 * 
	 * @params	size  An integer which decides the number of keys in the binary tree
	 */
	public MySeqArrayBinaryTree(int size) {
		nodes = new int[size+2]; //2 more to avoid ArrayOutofBounds exception
								 //during building of the tree.
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = -2;
		}
	}

	/*
	 * Constructor when size is not specified, used for testing purposes
	 */
	public MySeqArrayBinaryTree() {
		this((int)Math.pow(2, 10));
	}

	/*
	 * Method to insert keys at certain index, using random access
	 * @param	value integer representing the key/record
	 * 			index integer representing the position where the value would be inserted
	 */
	public void InsertElementsAdHoc(int value, int index){
		try{
			this.nodes[index] = value;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}
		
	}
	
	/*
	 * Method which creates a tree or a subtree
	 * @params	index Integer which depicts the position of the root of the tree
	 * 			x     Integer depicting the value
	 */
	public void makeTree(int index, int x) {
		if (this.nodes[index] != -2) {
			System.out.println("Error situation; node already occupied.");
			System.out.println("First Delete, then insert");
		}
		this.nodes[index] = x;
	}

	/*
	 * Method which creates a tree or a subtree of type heap. This is used by another 
	 * class to build a max heap tree.
	 * 
	 * @params	index Integer which depicts the position of the root of the tree
	 * 			x     Integer depicting the value
	 */
	public void makeHeapTree(int index, int x) {
		this.nodes[index] = x;
	}
	
	/*
	 * Method which sets the left node of another internal node
	 * @params	index Integer which depicts the position of the parent node
	 * 			x     Integer depicting the value
	 */
	public void setLeftNode(int index, int x) {
		if (this.nodes[index] == -2) {
			System.out.println("Error situation; parent node empty.");
		} else {
			int leftChild = 2 * index + 1;
			makeTree(leftChild, x);
		}
	}
	
	/*
	 * Method which sets the left node of another internal node, for a heap
	 * @params	index Integer which depicts the position of the parent node
	 * 			x     Integer depicting the value
	 */
	public void setHeapLeftNode(int index, int x) {
		int leftChild = 2 * index + 1;
		makeHeapTree(leftChild, x);
	}

	/*
	 * Method which sets the right node of another internal node
	 * @params	index Integer which depicts the position of the parent node
	 * 			x     Integer depicting the value
	 */
	public void setRightNode(int index, int x) {
		if (this.nodes[index] == -2) {
			System.out.println("Error situation; parent node empty.");
		} else {
			int rightChild = 2 * index + 2;
			makeTree(rightChild, x);
		}
	}

	/*
	 * Method which sets the right node of another internal node, for a heap
	 * @params	index Integer which depicts the position of the parent node
	 * 			x     Integer depicting the value
	 */
	public void setHeapRightNode(int index, int x) {
		int rightChild = 2 * index + 2;
		makeHeapTree(rightChild, x);
	}
	
	/*
	 * Method which returns the left child node value of an internal node 
	 * @params	index Integer which depicts the position of the parent node
	 * 	
	 */
	public int getLeftNodeValue(int index) {
		int leftChild = 2 * index + 1;
		return nodes[leftChild];

	}

	/*
	 * Method which returns the right child node value of an internal node 
	 * @params	index Integer which depicts the position of the parent node
	 * 	
	 */
	public int getRightNodeValue(int index) {

		int rightChild = 2 * index + 2;
		return nodes[rightChild];

	}

	/*
	 * Method which returns the left child node index of an internal node 
	 * @params	index Integer which depicts the position of the parent node
	 * 	
	 */
	public int getLeftNodeIndex(int index) {
		return 2 * index + 1;
	}

	/*
	 * Method which returns the right child node index of an internal node 
	 * @params	index Integer which depicts the position of the parent node
	 * 	
	 */
	public int getRightNodeIndex(int index) {
		return 2 * index + 2;
	}
	
	/*
	 * Method which returns the root node of the binary tree 
	 * 	
	 */
	public int getRootNode() {
		return this.nodes[0];
	}
	
	/*
	 * Method which returns the key/record in the current node 
	 * @params	index Integer which depicts the position of the current node
	 * 	
	 */
	public int getCurrNodeValue(int index) {
		return this.nodes[index];
	}

	/*
	 * Method which returns the list of nodes 
	 * 	
	 */
	public int[] getSortedArray(){
		return this.nodes;
	}
	
	/*
	 * Method which displays the nodes in a tree format.
	 * 	
	 */
	public void display_nodes() {
		int levels = (int)Math.round( ( Math.log10(nodes.length) / Math.log10(2) ) );
		for (int i = 0; i < levels; i++) {
			for (int j = (int)Math.pow(2, i)-1; j < (int)Math.pow(2, i+1)-1; j++) {
				System.out.print(nodes[j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	/*
	 * Method which returns the count of the nodes in the tree.
	 * 	
	 */
	public int getSize(){
		return this.nodes.length;
	}

}
