package org.hua.huffmanproject_5;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Files f1 = new Files();
        TreeMaker tree = new TreeMaker();
        HuffmanNode root = new HuffmanNode();
        Decode d = new Decode();
        Scanner s = new Scanner(System.in);

        int n = 128;
        int codes[];
        char chars[];

        codes = new int[128];
        chars = new char[128];
        String str;
        f1.ReadFile("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask5\\HuffmanProject_5\\src\\main\\java\\org\\hua\\huffmanproject_5\\tree.dat", codes, chars);

        String S = f1.ReadFile1(args, codes, chars);

        root = tree.create(codes, chars, n);
        str = d.decode(S, root);
        f1.writeToFile(args, str);
    }
}
