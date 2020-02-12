//Kaiya Hogg
//Homework #4
//02/11/2020

import java.io.*;
import java.util.*;


public class HW4{

    public static void main(String[] args){

    }
    //fill array method
    public static void fillArray(int[] array){

        //Defining the text file as a variable
        String fileName = "number_list.txt";

        //try catch
        try{
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            //int count = 0;
            
            //while loop to establish array size
            
            System.out.println("yo");

            scanner.close();
            reader.close();
        }
        catch(IOException ioe){
            //Prints the error message
            System.out.println("Cannot find the file");
        }
    }
    
}