package org.hua.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class AdjacencyMatrixGraph implements Graph {

    private byte[][] adj;
    private int numEdges;

    public AdjacencyMatrixGraph(int numberOfVertices) {
        adj = new byte[numberOfVertices][numberOfVertices];
        numEdges = 0;
    }

    @Override
    public void addVertex(int v) {

    }

    @Override
    public void removeVertex(int v) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsVertex(int v) {

        return v >= 0 && v < adj.length;
    }

    @Override
    public void addEdge(int u, int v) {
        checkVertex(u);
        checkVertex(v);
        if(adj[u][v] == 0){
            numEdges++;
        }
    }

    @Override
    public void removeEdge(int u, int v) {
        checkVertex(u);
        checkVertex(v);
        if(adj[u][v] == 1){
            adj[u][v] = 0;
            numEdges--;
        }

    }

    @Override
    public boolean containsEdge(int u, int v) {
        checkVertex(u);
        checkVertex(v);
        return adj[u][v] == 1;
    }

    @Override
    public int numVertices() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Iterator<Integer> iterator() {
        
        return IntStream.range(0,adj.length).iterator();
    }

    @Override
    public Iterator<Integer> outgoingIterator(int v) {
    }

    @Override
    public int outDegree(int v) {
        checkVertex(v);
        int counter = 0;
        for(int i=0;i<adj.length;i++){
            if(adj[v][i] !=0){
                counter++;
            }        
        }
        return counter;
    }

    private void checkVertex(int v) {
        if (v < 0) {
            throw new NoSuchElementException("Vertices are non-negative");
        }
        if (v >= adj.length) {
            throw new NoSuchElementException("No vertex " + v);
        }
    }
    
    public class OutIterator implements Iterator<Integer> {
        private int v;
        private int cur;
        
        @Override
        public boolean hasNext() {
            while(cur < adj.length && adj[v][cur] == 0) {
                cur++;
            }
            return cur <adj.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return cur++;
        }
        
    }

}
