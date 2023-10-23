package org.hua.huffmanproject_3;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Files f1 = new Files();
        TreeMaker tree = new TreeMaker();
        HuffmanNode root = new HuffmanNode();

        Scanner s = new Scanner(System.in);

        int n = 128;
        int charfreq[];
        char charArray[];

        charfreq = new int[128];
        charArray = new char[128];
        Print print = new Print();
        f1.ReadFile("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask3\\tree.dat", charfreq, charArray);
        
        
        root = tree.create(charfreq, charArray, n);
        print.printCode(root, "");
    }
}