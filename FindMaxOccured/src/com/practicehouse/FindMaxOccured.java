/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicehouse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marifurr
 */
public class FindMaxOccured {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // CREATE A FILE READER TO READ FROM FILE
            FileReader fr = new FileReader("C:/Users/marifurr/Desktop/testingMax.txt");

            Scanner sc = new Scanner(fr);

            // CREATE A HASHMAP TO STORE 
            HashMap<String, Integer> list = new HashMap<>();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                System.out.println(line);
                String[] words = line.split("[ \n\r.,;]");

                for (String w : words) {
                    if (list.get(w) == null) {
                        list.put(w, 1);
                    } else {
                        int value = list.get(w).intValue();
                        list.put(w, value + 1);
                    }
                }

            }
            
            System.out.println("===============================================");
            
            int maxValueInMap = (Collections.max(list.values()));

            for (Entry<String, Integer> entry : list.entrySet()) {
                if (entry.getValue() == maxValueInMap) {
                    System.out.println("Most Occured word is : " + entry.getKey().toUpperCase() + " -> " + entry.getValue() + " Times");
                }
            }

            System.out.println("===============================================");

            for (Entry<String, Integer> entry : list.entrySet()) {
                System.out.println(entry.getKey().toUpperCase() + " -> Word is Occured = " + entry.getValue() + " Times");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FindMaxOccured.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
