
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
       
        //find(input
       String[][] netflixData2D = find(input);
        //
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + 
                "S -Search by show \n" + "H -Highest days in top ten");
        input = new Scanner(System.in);
        System.out.print("Choice: ");
        String choice = input.nextLine();

        //Switch selection Structure
        switch (choice) {
            case "S": {
                System.out.print("What tv or movie show would you like to search for: ");
                String show = input.nextLine();
                searchForShow(netflixData2D, show);
            }
        }

    }

//method that returns the data in a 2D array from file input
    public static String[][] find(Scanner fileInput) throws FileNotFoundException {
        //initialize 2D Array for the File
        String[][] netflixData = new String[7100][6];

        //Skipping top line of the file
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

    public static void searchForShow(String[][] netflixData, String Show) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter("searchResults.txt");
        //casting showChoice to only lowercase
        String showChoice = Show.toLowerCase();

        int weeks = 0;
        for (int row = 0; row < netflixData.length; row++) {
            //making the show in the 2D array lowercase
            String showLower = netflixData[row][2].toLowerCase();
            //comparing if showchoice and show in the array equal each other
            if (showLower.equals(showChoice)) {
                outputFile.print(netflixData[row][2]);
                //counting number of weeks show has aired 
                weeks++;

            }
        }
        System.out.println("The number of weeks " + Show + " appeared is: " + weeks);

    }
}
