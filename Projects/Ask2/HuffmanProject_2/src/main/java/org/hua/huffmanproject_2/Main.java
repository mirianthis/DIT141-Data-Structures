package org.hua.huffmanproject_2;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    // recursive function to print the 
    // huffman-code through the tree traversal. 
    // Here s is the huffman - code generated. 
    public static void printCode(HuffmanNode root, String s) throws IOException {

        Files f2 = new Files();

        if (root.left == null && root.right == null) {

            f2.writeToFile1(root.data, s);
            f2.writeToFile(root.c, root.data, "");

           

            return;
        }

        printCode(root.left, s + root.data + "-");

        printCode(root.right, s + root.data + "-");

    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        HuffmanNode root;
        
        // number of characters. 
        int n = 128;
        char[] charArray;
        int[] charfreq;
        charfreq = new int[128];
        charArray = new char[128];

        for (int i = 0; i < 128; i++) {
            charArray[i] = (char) i;
        }

        Files f1 = new Files();
        TreeMaker tree = new TreeMaker();
        f1.ReadFile("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask2\\frequencies.dat", charfreq, charArray);
        root = tree.create(charfreq, charArray, n);
        

        // print the codes by traversing the tree 
        printCode(root, "");
    }
}
