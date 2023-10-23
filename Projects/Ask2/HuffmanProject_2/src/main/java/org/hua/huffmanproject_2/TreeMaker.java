/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject_2;

import java.util.PriorityQueue;

/**
 *
 * @author 35797
 */
public class TreeMaker {
    
    public HuffmanNode create(int charfreq[], char charArray[], int n){
      
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            // creating a Huffman node object 
            // and add it to the priority queue. 
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            // add functions adds 
            // the huffman node to the queue. 
            q.add(hn);
        }

        // create a root node 
        HuffmanNode root = null;

        
        while (q.size() > 1) {

            // first min extract. 
            HuffmanNode x = q.peek();
            q.poll();

            // second min extarct. 
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal 
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes 
            // assigning values to the f node. 
            f.data = x.data + y.data;
            

            // first extracted node as left child. 
            f.left = x;

            // second extracted node as the right child. 
            f.right = y;

            // marking the f node as the root node. 
            root = f;

            // add this node to the priority-queue. 
            q.add(f);
        }
        return root;
    
}
}
