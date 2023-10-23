/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.bst;

import java.util.Scanner;
import java.util.StringTokenizer;

public class App {

	public static void main(String args[]) {

		Dictionary<String, Integer> dict = new BinarySearchTree<>();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while(scanner.hasNext()) { 
				String line = scanner.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) { 
					String word  = st.nextToken();
					Integer curFreq = dict.get(word);
					if (curFreq == null) { 
						curFreq = 1;
					} else { 
						curFreq++;
					}
					dict.put(word, curFreq);
				}
			}
		}
		
		for(String key: dict) { 
			System.out.println("Word " + key + " appeared " + dict.get(key) + " times");
		}

	}

}
