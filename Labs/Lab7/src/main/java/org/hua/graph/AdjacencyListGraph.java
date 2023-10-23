package org.hua.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyListGraph implements Graph {

	private ArrayList<LinkedList<Integer>> adj;
	private int numVertices;
	private int numEdges;

	public AdjacencyListGraph() {
		adj = new ArrayList<>();
		numVertices = 0;
		numEdges = 0;
	}

	@Override
	public void addVertex(int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVertex(int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsVertex(int v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addEdge(int u, int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEdge(int u, int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsEdge(int u, int v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> outgoingIterator(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegree(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
