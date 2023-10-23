/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        Files f1 = new Files();

        f1.ReadUrl("https://www.gutenberg.org/files/1342/1342-0.txt");
        f1.ReadUrl("https://www.gutenberg.org/files/11/11-0.txt");
        f1.ReadUrl("https://www.gutenberg.org/files/2701/2701-0.txt");
        f1.WriteFile("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\frenquencies.dat");
        

    }
}

