package domesdedomenon;

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

public class domesDedomenon {
	
	class Graph 
	{ 
		private int V; // No. of vertices 
		private LinkedList<Integer> adj[]; //Adjacency Lists 

		// Constructor 
		Graph(int v) 
		{ 
			V = v; 
			adj = new LinkedList[v]; 
			for (int i=0; i<v; ++i) 
				adj[i] = new LinkedList(); 
		} 

		// Function to add an edge into the graph 
		void addEdge(int v,int w) 
		{ 
			adj[v].add(w); 
		} 

		// prints BFS traversal from a given source s 
		void BFS(int s) 
		{ 
			// Mark all the vertices as not visited(By default 
			// set as false) 
			boolean visited[] = new boolean[V]; 

			// Create a queue for BFS 
			LinkedList<Integer> queue = new LinkedList<Integer>(); 

			// Mark the current node as visited and enqueue it 
			visited[s]=true; 
			queue.add(s); 

			while (queue.size() != 0) 
			{ 
				// Dequeue a vertex from queue and print it 
				s = queue.poll(); 
				System.out.print(s+" "); 

				// Get all adjacent vertices of the dequeued vertex s 
				// If a adjacent has not been visited, then mark it 
				// visited and enqueue it 
				Iterator<Integer> i = adj[s].listIterator(); 
				while (i.hasNext()) 
				{ 
					int n = i.next(); 
					if (!visited[n]) 
					{ 
						visited[n] = true; 
						queue.add(n); 
					} 
				} 
			} 
		}
	}
	
	public static void main(String[] args) throws Exception {
	    String filePath = "/home/it218110/Downloads/wiki-Vote.txt";
	    HashMap<String, String> map = new HashMap<String, String>();
	    
	    ArrayList<Integer> thread = new ArrayList<>();
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
                    Graph g = new Graph(4); 
                    for (String key : map.keySet())
                    {
                        g.addEdge(key, map.get(key)); 
                    }
                    g.BFS(2);
	        } else {
	            System.out.println("ignoring line: " + line);
	        }
	    }

	    for (String key : map.keySet())
	    {
	        System.out.println(key + "\t" + map.get(key));
	    }
	    /*
	    Graph g = new Graph(4); 
	    for (String key : map.keySet())
	    {
	    	g.addEdge(key, map.get(key)); 
	    }
	    g.BFS(2); */
	    reader.close();
	} */
}
