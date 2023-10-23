package org.hua.huffmanproject_3;

import java.io.IOException;

public class Print {

    public static void printCode(HuffmanNode root, String s) throws IOException {
        Files f1 = new Files();

        if (root.left == null && root.right == null) {

            f1.writeToFile(root.c, s);

            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}