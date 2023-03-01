
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
<<<<<<< Updated upstream

        while (input.hasNext()) {
            
            

        }
       
        //find(input
       String[][] netflixData2D = find(input);
        //
=======
        //Storing the original file in a 2D array
        String[][] netflixData2D = find(input);
        //menu choices
>>>>>>> Stashed changes
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + 
                "S -Search by show \n" + "H -Highest days in top ten");
        input = new Scanner(System.in);
        System.out.print("Choice: ");
        String choice = input.nextLine();

        //Switch selection Structure
        while (!choice.equals("Q")) {

            if (choice.equals("F")) {
                System.out.print("What TV Show or Movie would you like to search for: ");
                String type = input.nextLine();
                filterOnType(netflixData2D, type);

            } else if (choice.equals("D")) {
                System.out.print("What week would you like to search for (mm/dd/yyyy): ");
                String day = input.nextLine();
                filterOnDate(netflixData2D, day);

            } else if (choice.equals("S")) {
                System.out.print("What tv or movie show would you like to search for: ");
                String show = input.nextLine();
                searchForShow(netflixData2D, show);
            }
            System.out.println("Menu  (Choose one of the following or Q to quit:");
            System.out.println("F - Filter on Type \n" + "D -Filter on Data\n" + "S -Search by show \n" + "H -Highest days in top ten");
            input = new Scanner(System.in);
            System.out.print("Choice: ");
            choice = input.nextLine();
            System.out.println("");

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

        outputFile.println("Results for: tv show");

        int weeks = 0;
        int ShowLocation = 0;
        //running through each index number in the array
        for (int row = 0; row < netflixData.length; row++) {
            //making the show in the 2D array lowercase
            String showLower = netflixData[row][2].toLowerCase();
            //comparing if showchoice and show in the array equal each other
            if (showLower.equals(showChoice)) {
                ShowLocation = row;
                weeks++;
                for (int col = 0; col < 6; col++) {
                    outputFile.print(netflixData[ShowLocation][col] + " ");
                }
                outputFile.println();
            }
        }
        //printing out the shows location to the file
        //if show is found through numebr of weeks write to file, else not found
        if (weeks > 0) {
            System.out.println("The number of weeks " + Show + " appeared is: " + weeks);
            System.out.println("");
            outputFile.close();

        } else {
            System.out.println("Show not found");
        }
    }

    public static void filterOnDate(String[][] netflixData, String date) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter("date.txt");

        outputFile.println("Results for: tv show");
        int ifFound = 0;
        //running through each index number in the array
        for (int row = 0; row < netflixData.length; row++) {
            //turning the date into a string for a boolean operator
            String showDate = netflixData[row][0];
            //comparing if showchoice and show in the array equal each other
            if (date.equals(showDate)) {
                int dateLocation = row;
                for (int col = 0; col < 6; col++) {
                    outputFile.print(netflixData[dateLocation][col] + " ");
                    ifFound++;

                }
                outputFile.println();
            }
        }
        if (ifFound == 0) {
            System.out.println("Show not found");
            System.out.println();
        }
        outputFile.close();
    }

    public static void filterOnType(String[][] netflixData, String type) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter("type.txt");

        outputFile.println("Results for: tv show");
        int ifFound = 0;
        //running through each index number in the array
        for (int row = 0; row < netflixData.length; row++) {
            //turning the showType into a String for boolean operator
            String showType = netflixData[row][3];
            //comparing if showchoice and show in the array equal each other
            if (type.equalsIgnoreCase(showType)) {
                int typeLocation = row;
                for (int col = 0; col < 6; col++) {
                    outputFile.print(netflixData[typeLocation][col] + " ");
                    //variable to check if a show type has been found
                    ifFound++;

                }
                outputFile.println();
            }
        }
        if (ifFound == 0) {
            System.out.println("Show not found");
            System.out.println();
        }
        outputFile.close();
        System.out.println();
    }
}
