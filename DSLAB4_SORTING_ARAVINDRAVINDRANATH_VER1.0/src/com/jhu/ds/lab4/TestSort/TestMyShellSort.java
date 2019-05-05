package com.jhu.ds.lab4.TestSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jhu.ds.lab4.ShellSort.*;

public class TestMyShellSort {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testShellSort() {
		 
		int[] input = new int[2000];
		for (int i = 0; i < 2000; i++) {
			input[i] = (int)(Math.random()*1000);
			while (input[i] == 0){
				input[i] = (int)(Math.random()*1000);
			}
		}
		MyShellSort oSort = new MyShellSort(input);
		oSort.shellSort();
		//fail("Not yet implemented"); // TODO
	}

}
