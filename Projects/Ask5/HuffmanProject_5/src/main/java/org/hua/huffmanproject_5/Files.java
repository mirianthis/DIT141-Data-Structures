package org.hua.huffmanproject_5;

import java.io.*;
import java.io.IOException;

public class Files {

    public void ReadFile(String ReadName, int[] asciitable, char[] array) throws IOException {
        int i = 0;
        char xar;
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
                int index, index2;

                index = line.indexOf("->");
                index2 = line.indexOf(":");

                index += 2;

                String ans = line.substring(index);
                String ans2;

                if (ans.isBlank()) {
                    if (cnt == 0) {
                        char a;
                        a = (char) 10;
                        ans = Character.toString(a);
                        cnt++;
                    } else {
                        char a;
                        a = (char) 15;
                        ans = Character.toString(a);
                    }

                }

                if (index2 == -1) {
                    ans2 = reader.readLine();
                } else {
                    index2 += 1;
                    ans2 = line.substring(index2);
                }
                xar = ans.charAt(0);
                array[i] = xar;

                if (ans2.charAt(0) == ':') {

                    ans2 = ans2.substring(1);

                }
                asciitable[i] = Integer.valueOf(ans2);

                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

    }

    public String ReadFile1(String[] args, int[] codes, char[] chars) throws IOException {
        boolean flag = true;
        String str = "";
        BufferedReader reader;
        String tmp = null, file = "";
        int i;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            int c;

            while ((c = reader.read()) != -1) {

                tmp = String.valueOf((char) c);

                file += tmp;

            }

            byte[] a = new byte[1];

            a = file.getBytes();

            str = new String(a);

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return str;
    }

    public void writeToFile(String args[], String str) throws IOException {

        File a = new File(args[1]);

        if (!a.exists()) {
            a.createNewFile();
        }

        FileWriter fw = new FileWriter(a.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);

        bw.close();
    }

}
