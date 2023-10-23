/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.io.FileWriter;

/**
 *
 * @author 35797
 */
public class Files {

    int i;
    int asciitable[];
    char array[];

    public Files() {
        asciitable = new int[128];
        array = new char[128];

        for (i = 0; i < 128; i++) {
            array[i] = (char) i;
        }
    }

    public void ReadUrl(String ReadName) throws IOException {

        try {

            URL oracle = new URL(ReadName);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            int c = 0;

            while ((c = in.read()) != -1) {
                char character = (char) c;

                if ((c >= 0) && (c <= 127)) {

                    for (i = 0; i < c; i++) {
                    }

                    asciitable[i]++;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public void WriteFile(String WriteName) throws IOException {
        int i;
        FileWriter writer = new FileWriter(WriteName);

        for (i = 0; i < 128; i++) {
            writer.write(array[i] + " -> " + asciitable[i] + "\n");
        }

        writer.close();
    }

}
