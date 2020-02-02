//Kaiya Hogg
//Asks user for first and last name
//Returns characters individually and their numeric values, the sum of the numeric values, and the characters
//concatenated as strings

import java.util.*;

public class Initials{

    public static void main (String[] args){

        Scanner nameReader = new Scanner (System.in);   //Using same method to read input as in Primitves assignment

        System.out.println("Enter your first and last name: ");
        String name = nameReader.nextLine(); //sets both names to single variable as a string

        char first = name.charAt(0);
        char last = name.charAt(name.indexOf(" ")+1); //looks for the " " in the input and +1 in the index
        //to find the first charcter in the last name

        System.out.println("First: "+ first + "\nLast: " + last + "\nNumeric values: " + (int)first + ", " + (int)last);
        System.out.println((int)first + (int)last); //if a string is concatenated before the numerics, then integers
        //are concatenated

        //String initials = (String)first+(String)last;
        System.out.println("Initials concatenated: " + first+last);
        

        nameReader.close();
    }
}