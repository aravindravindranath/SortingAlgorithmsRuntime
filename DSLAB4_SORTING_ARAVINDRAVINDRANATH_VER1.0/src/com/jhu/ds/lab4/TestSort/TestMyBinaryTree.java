package com.jhu.ds.lab4.TestSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jhu.ds.lab4.HeapSort.*;

public class TestMyBinaryTree {
	
	MyBinaryHeapTree cut = new MyBinaryHeapTree();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDisplay_tree() {
		cut.insertTree(20);
		cut.insertTree(24);
		cut.insertTree(18);
		cut.insertTree(28);
		cut.insertTree(10);
		cut.insertTree(20);
		cut.display_tree();
		//fail("Not yet implemented"); // TODO
	}

	
	@Test
	public final void testSearch_tree() {
		cut.insertTree(20);
		cut.insertTree(24);
		cut.insertTree(18);
		cut.insertTree(28);
		cut.insertTree(10);
		cut.insertTree(20);
		assertEquals(2, cut.search_tree(24));
		assertEquals(3, cut.search_tree(10));
		assertEquals(-2, cut.search_tree(29));
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testTraverse_tree() {
		cut.insertTree(20);
		cut.insertTree(24);
		cut.insertTree(18);
		cut.insertTree(28);
		cut.insertTree(10);
		cut.insertTree(20);
		cut.Traverse(0);
		assertEquals(2, cut.search_tree(24));
		assertEquals(3, cut.search_tree(10));
		assertEquals(-2, cut.search_tree(29));
		//fail("Not yet implemented"); // TODO
	}

	
	@Test
	public final void testheapify() {
		MyBinaryHeapTree cut = new MyBinaryHeapTree(7);
		cut.InsertElementsAdHoc(49, 0);
		cut.InsertElementsAdHoc(62, 1);
		cut.InsertElementsAdHoc(88, 2);
		cut.InsertElementsAdHoc(73, 3);
		cut.InsertElementsAdHoc(20, 4);
		cut.InsertElementsAdHoc(94, 5);
		cut.InsertElementsAdHoc(68, 6);
		cut.heapify();
		cut.display_tree();
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testheapSort() {
		MyBinaryHeapTree cut = new MyBinaryHeapTree(7);
		cut.InsertElementsAdHoc(49, 0);
		cut.InsertElementsAdHoc(62, 1);
		cut.InsertElementsAdHoc(88, 2);
		cut.InsertElementsAdHoc(73, 3);
		cut.InsertElementsAdHoc(20, 4);
		cut.InsertElementsAdHoc(94, 5);
		cut.InsertElementsAdHoc(68, 6);
		cut.heapify();
		cut.heapSort();
		cut.display_tree();
		//fail("Not yet implemented"); // TODO
	}
	
	
}
