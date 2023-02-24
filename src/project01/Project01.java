/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01;

import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author
 */
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //setting up user to choose file
        JFileChooser myChooser = new JFileChooser();

        myChooser.showOpenDialog(null);

        File file = myChooser.getSelectedFile();

        //Create Scanner
        Scanner input = new Scanner(file);
        find(input);
        //
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + "S -Search by show \n" + "H -Highest days in top ten");
        input = new Scanner(System.in);
        System.out.print("Choice:");
        String name = input.nextLine();

    }

//method that returns the data in a 2D array from file input
    public static String[][] find(Scanner fileInput) throws FileNotFoundException {
        //initialize 2D Array for the File
        String[][] netflixData = new String[7100][6];

        fileInput.nextLine();

        //reading the file and splitting by commas
        while (fileInput.hasNext()) {
            //Double for loop to iterate through each index in the 2D Array
            for (int row = 0; row < netflixData.length; row++) {

                //moves the cursor to the next line for each row
                String line = fileInput.nextLine();
                for (int col = 0; col < netflixData[row].length; col++) {

                    //splits the row line read by ","
                    String[] fields = line.split(",");

                    //assigned each index to split by ","
                    netflixData[row][col] = fields[col];
                }
            }

        }
        return netflixData;
    }
}
