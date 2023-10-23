/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject_2;

import java.util.Comparator;

/**
 *
 * @author 35797
 */
class MyComparator implements Comparator<HuffmanNode> {

    public int compare(HuffmanNode x, HuffmanNode y) {

        return x.data - y.data;
    }
}
