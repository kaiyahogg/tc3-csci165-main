//Kaiya Hogg

import java.util.*;

public class Primitives{

    public static void main (String[] args){
        byte bite = 1;
        short small = 128;
        int integer = 5;
        long large = 10;
        float decimal = 1;
        double smallerdecimal = .01;
        
        char letter = 'A';
        boolean valid = bite <= integer;

        Scanner sc = new Scanner(System.in); //System.in is a standard input string
        //whatever is scanned is read as a string

        String format = "Byte: %s\nShort: %d\nInteger: %d\nLong: %d\nFloat: %f\nDouble: %f\nChar: %s\nChar (as integer): %d\nBoolean: %b\n \n";
        System.out.printf(format, bite, small, integer, large, decimal, smallerdecimal, letter, (int)letter, valid);
        //using printf() method, the format is called first then the corresponding variables to be plugged in

        System.out.print("Enter a number: "); //prints prompt
        
        //Reads the next line (in other words line created by the user) sets this to n
        int x = Integer.valueOf(sc.nextLine()); //must be converted to an integer as it is still a string
        
        for(int i = 2 ; i <= 4 ; i++) //loop that raises the power of the inputed value by one, ends after 4
            System.out.println(x +" to the power of " + i + " is: " + Math.pow(x, i));
            System.out.println("\n");
        

        int max = Integer.MAX_VALUE; //both variables set as ints and min/max values are specifed for ints
        int min = Integer.MIN_VALUE;

        System.out.println("Max: " + max + "\nMin: " + min);

        int Signed_num = Integer.compare(min,max);  
        int Unsigned_num = Integer.compareUnsigned(min,max);
        //One issue regarding comparing max/min values is that the signs for the results of both are flipped
        //For instance the unsigned number becomes signed in compareUnsigned if (max,min)

        System.out.println("Comparing signed integers: " + Signed_num + "\nComparing unsigned integers: " + Unsigned_num);

        //Prompts the user to input an integer, reads that line, then converts it to an integer
        Scanner dividendReader = new Scanner(System.in);
        System.out.print("Enter a dividend: ");
        int dividend = Integer.valueOf(dividendReader.nextLine());

        //Same block of code but asks for a divisor
        Scanner divisorReader = new Scanner(System.in);
        System.out.print("Enter a divisor: ");
        int divisor = Integer.valueOf(divisorReader.nextLine());

        double modulus = dividend % divisor;
        
        double divided = dividend / divisor;
        double floor = Math.floor(divided);

        String formatTwo = "Result using modulus divison (The Remainder): %s\nResult using floor division: %s";
        System.out.printf(formatTwo, modulus, floor);

        //Scanners closed
        sc.close(); //scanner must be closed to prevent memory leak
        dividendReader.close(); 
        divisorReader.close();
    }
}