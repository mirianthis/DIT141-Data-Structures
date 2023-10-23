package org.hua.huffmanproject_3;

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

    public static void writeToFile(char car, String s) throws IOException {

        File a = new File("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask3\\code.dat");

        if (!a.exists()) {
            a.createNewFile();
        }
        FileWriter fw = new FileWriter(a.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(car + "->" + s);
        bw.newLine();
        bw.close();
    }

}