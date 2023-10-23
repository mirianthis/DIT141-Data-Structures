package org.hua.exams2021;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String args[]) throws IOException {

        int i = 0;
        ArrayList<String> rate = new ArrayList<String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("ratings.dat"));

            String line;
            while ((line = reader.readLine()) != null) {

                rate.add(line);
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        int j = 0;
        ArrayList<String> movie = new ArrayList<String>();
        BufferedReader reader1;
        try {
            reader1 = new BufferedReader(new FileReader("movies.dat"));

            String line;
            while ((line = reader1.readLine()) != null) {

                movie.add(line);
                j++;
            }
            reader1.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        for (i = 0; i < rate.size(); i++) {
            for (j = 0; j < movie.size(); j++) {
                String[] arrOfStr = rate.get(i).split("::");
                String[] arrOfStr1 = movie.get(j).split("::");
                if (arrOfStr[1].equals(arrOfStr1[0])) {
                    System.out.println(rate.get(i) + movie.get(j));
                }
            }
        }

    }

}
