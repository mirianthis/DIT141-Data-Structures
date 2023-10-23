package org.hua.exam;

import java.io.*; 
import java.util.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
	
	
	
	public static void main(String[] args) throws Exception {
	    String filePath = "C:\\Users\\35797\\Desktop\\hi.txt";
	    HashMap<String, String> map = new HashMap<String, String>();
	    
	    
	    String line;
	    BufferedReader reader = new BufferedReader(new FileReader(filePath));
	    while ((line = reader.readLine()) != null)
	    {
	    	String[] parts = line.split("\t", 2);
	        if (parts.length >= 2)
	        {
                    String key = parts[0];
                    String value = parts[1];
	            map.put(key, value);
	        } else {
	            System.out.println("ignoring line: " + line);
	        }
	    }

	    for (String key : map.keySet())
	    {
	        System.out.println(key + "\t" + map.get(key));
	    }
	    
	    Graph g = new Graph(4);             
	    for (String key : map.keySet())
	    {
                int temp1 = Integer.parseInt(key);
                int temp2 = Integer.parseInt(map.get(key));
	    	g.addEdge(temp1, temp2); 
	    }
	    g.BFS(2); 
	    reader.close();
	}
}
