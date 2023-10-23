package org.hua.huffmanproject_2;

import java.io.*;
import java.io.IOException;

public class Files {

    public void ReadFile(String ReadName, int[] asciitable, char[] array) throws IOException {
        int i = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(ReadName));
            String line = reader.readLine();
            while (true) {

                line = reader.readLine();
                if (line == null) {
                    break;

                }
                if (line.isBlank()) {
                    line = reader.readLine();
                }
                int index = line.indexOf("->");

                index += 3;
                String ans = line.substring(index);

                asciitable[i] = Integer.valueOf(ans);

                i++;

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        int temp;

        for (i = 127; i > 1; i--) {

            temp = asciitable[i - 1];
            asciitable[i] = asciitable[i - 1];

        }
        asciitable[0] = 0;

    }

    public static void writeToFile(char car, int data, String s) throws IOException {
        // For output to file
        File a = new File("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask2\\tree.dat");

        if (!a.exists()) {
            a.createNewFile();
        }
        FileWriter fw = new FileWriter(a.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(s + ">" + car + ":" + data);
        bw.newLine();
        bw.close();
    }// end of writeToFile()

    public static void writeToFile1(int data1, String s) throws IOException {
        // For output to file
        File a = new File("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask2\\tree.dat");

        if (!a.exists()) {
            a.createNewFile();
        }
        FileWriter fw = new FileWriter(a.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(s + "");

        bw.close();
    }// end of writeToFile()

}
