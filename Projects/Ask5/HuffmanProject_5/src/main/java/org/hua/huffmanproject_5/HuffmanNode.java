package org.hua.huffmanproject_5;

import java.util.Comparator;

class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {

        return x.data - y.data;
    }
}
