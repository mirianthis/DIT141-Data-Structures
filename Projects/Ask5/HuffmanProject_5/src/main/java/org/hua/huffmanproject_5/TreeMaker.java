package org.hua.huffmanproject_5;

import java.util.PriorityQueue;

public class TreeMaker {

    public HuffmanNode create(int charfreq[], char charArray[], int n) {

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            // second min extarct.
            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;

            f.left = x;

            f.right = y;

            root = f;

            q.add(f);
        }
        return root;

    }
}
