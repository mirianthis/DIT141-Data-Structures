package org.hua.huffmanproject_4;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int i;

        Files f1 = new Files();

        String codes[];
        char chars[];

        codes = new String[128];
        chars = new char[128];

        f1.ReadFile("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask4\\HuffmanProject_4\\src\\main\\java\\org\\hua\\huffmanproject_4\\code.dat", codes, chars);
        f1.ReadFile1(args, codes, chars);

    }
}
