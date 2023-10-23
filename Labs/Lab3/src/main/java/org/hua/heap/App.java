/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.heap;

import java.util.Random;

public class App {

	public static final int ELEMENTS = 100000;
	public static final int RANGE = 1000;

	public static void main(String args[]) {

		Random rng = new Random(17);
		Integer[] array = new Integer[ELEMENTS];
		for (int i = 0; i < ELEMENTS; i++) {
			array[i] = rng.nextInt(RANGE);
		}

		heapSort(array);
		
		for (int i = 1; i < ELEMENTS; i++) {
			if (array[i-1] > array[i]) { 
				System.out.println("Bug!");
			}
		}

	}

	public static void heapSort(Integer[] array) {
		MinHeap<Integer> h = new ArrayMinHeap<Integer>(array);
		int i = 0;
		while (!h.isEmpty()) {
			array[i++] = h.deleteMin();
		}
	}

}
