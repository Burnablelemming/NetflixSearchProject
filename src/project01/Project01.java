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

        while (input.hasNext()) {

        }

        //
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + "S -Search by show \n" + "H -Highest days in top ten");
        input = new Scanner(System.in);
        System.out.print("Choice:");
        String name = input.nextLine();

    }

    if (name.equalsIgnoreCase ( 
        "D")) {
            System.out.print("What week would you like to search for (mm/dd/yyyy): ");
        String date = input.nextLine();

    }

    public static String[][] find(Scanner fileInput) throws FileNotFoundException {
        String[][] netflixData = new String[7100][6];
        //Choose the input File
        JFileChooser myChooser = new JFileChooser();

        myChooser.showOpenDialog(null);

        File file = myChooser.getSelectedFile();

        //Create Scanner
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String date = input.next(",");
            System.out.println(date);
        }

    
}
