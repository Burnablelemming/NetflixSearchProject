/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01;
import java.util.*;
/**
 *
 * @author
 */
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("What would you like to do.");
        System.out.println("Menu  (Choose one of the following or Q to quit:");
        System.out.println("F - Filter on Type \n" +"D -Filter on Data\n"+ "S -Search by show \n"+"H -Highest days in top ten");
        Scanner input = new Scanner(System.in);
        System.out.print("Choice:");
        String name=input.nextLine();
        

        
         if (name.equalsIgnoreCase("D")) {
            System.out.print("What week would you like to search for (mm/dd/yyyy): ");
            String date = input.nextLine();

        
        
                 
                 
                 
                 

        }
        
}
}