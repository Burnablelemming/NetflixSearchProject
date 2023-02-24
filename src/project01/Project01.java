
package project01;

import java.util.*;
import java.io.*;
import javax.swing.*;


public class Project01 {
    public static void main(String[] args) throws FileNotFoundException {
        //setting up user to choose file
        JFileChooser myChooser = new JFileChooser();
            myChooser.showOpenDialog(null);
            File file = myChooser.getSelectedFile();

        //Create Scanner
        Scanner input = new Scanner(file);

        while (input.hasNext()) {

        }
        //}
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + 
                "S -Search by show \n" + "H -Highest days in top ten");
        input = new Scanner(System.in);
        System.out.print("Choice:");
        String name = input.nextLine();

    }

    
//method that returns the data in a 2D array from file input
    public static String[][] find(Scanner fileInput) throws FileNotFoundException {
        String[][] netflixData = new String[7100][6];
        //Choose the input File
        JFileChooser myChooser = new JFileChooser();
        myChooser.showOpenDialog(null);
        File file = myChooser.getSelectedFile();

        //Create Scanner
        Scanner input = new Scanner(file);
        int i=0;
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String[] fields = line.split(",");
             for(int j=0;j<6;j++){
                 netflixData[i][j]=fields[j];
             }
             i++;
        }
        return netflixData;
        
    }  
    
}