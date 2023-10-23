package org.hua.huffmanproject_4;

import java.io.*;
import java.io.IOException;

public class Files {

    public void ReadFile(String ReadName, String[] codes, char[] chars) throws IOException {
        int i = 0;
        char xar;
        String tmp;
        int cnt = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ReadName));
            String line;
            while (true) {

                line = reader.readLine();
                if (line == null) {
                    break;

                }
                if (line.isBlank()) {
                    line = reader.readLine();
                }
                int index;
                if (i == 48) {
                    index = line.indexOf("->");
                    tmp = line.substring(0);
                    xar = tmp.charAt(0);

                    index += 2;

                    String ans = line.substring(index);
                    xar = (char) 10;
                    chars[i] = xar;
                    codes[i] = ans;
                } else {

                    index = line.indexOf("->");
                    tmp = line.substring(0);
                    xar = tmp.charAt(0);

                    index += 2;

                    String ans = line.substring(index);

                    chars[i] = xar;
                    codes[i] = ans;
                }

                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

    }

    public void ReadFile1(String args[], String[] codes, char[] chars) throws IOException {
        boolean flag = true;
        BufferedReader reader;
        String tmp = null, file = "";
        int i;

        Files f1 = new Files();

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            int c = 0;

            while ((c = reader.read()) != -1) {

                for (i = 0; i < 128; i++) {
                    if (c == chars[i]) {
                        tmp = codes[i];

                    }

                }

                file += tmp;

            }

            byte[] a = new byte[1];

            a = file.getBytes();

            String str = new String(a);

            f1.writeToFile(a, args, str);

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeToFile(byte[] array, String args[], String str) throws IOException {

        File a = new File(args[1]);

        if (!a.exists()) {
            a.createNewFile();
        }

        FileWriter fw = new FileWriter(a.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Number of bits for the Huffman code is: " + array.length * 8);
        bw.newLine();
        bw.write(str);

        bw.close();
    }

}
