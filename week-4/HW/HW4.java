//Kaiya Hogg
//Homework #4
//02/11/2020

import java.io.*;
import java.util.*;


public class HW4{
     
    //Defining the array as a final static int
    final static int count = 1000;
    final static int[] numbers = new int[count];
    final static int[][] twoDimensional = new int[50][20];
    
    //fillArray method
    public static void fillArray(int[] array){
        
        //Try catch
        try{
            final File fileName = new File("number_list.txt");
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

                //for loop that fills the array
                for(int i = 0; i < count; i++){
                    int line = scanner.nextInt();
                    numbers[i] += line;
                    //System.out.println(numbers[i]);
                    //System.out.println(i);
                    } 

            reader.close();
            scanner.close();
        }
        catch (final IOException ioe) {
            // Prints the error message
            System.out.println("Cannot find the file");
        }
    }

    //findMax method
    public static int findMax(int[] array){
        
        //Defining variables for while loop
        int max = numbers[0];
        int i = 0;
        
        //While loop that finds the maximum number
        while (i<count-1){
            if(max < numbers[i+1]){
                max = numbers[i+1];
            }
            i++;
        }
        return max;
        
    }
    
    //findMin method
    public static int findMin(int[] array){
        
        //Defining variables for while loop
        int min = numbers[0];
        int i = 0;
        
        //While loop that finds the minimum number
        while (i<count-1){
            if(min > numbers[i+1]){
                min = numbers[i+1];
            }
            i++;
        }
        return min;
    }

    //percentChange method
    public static int [] percentChange(int[] array){
        
        //Defining variables
        int i = 0;
        int [] change = new int [count-1];

        //While loop that lists the percent of change between adjacent values
        while(i<count-1){
            change[i] += ((double)(numbers[i+1]-numbers[i])/numbers[i])*100.00;
            i++;
        }
        return change;
    }

    //Second fillArray method
    public static void fillArrayTwo(int[][] matrix){
        try{
            final File fileName = new File("number_list.txt");
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

                //for loop that goes through the rows
                for(int i = 0; i < 50; i++){
                    int line = scanner.nextInt();
                    
                    //for loop that goes through the columns
                    for(int j = 0; j < 19; j++){   
                        twoDimensional[i][j] += line;
                        line = scanner.nextInt();
                        //System.out.println(twoDimensional[i][j]);
                    }
                } 
            
            reader.close();
            scanner.close();
        }
        catch (final IOException ioe) {
            // Prints the error message
            System.out.println("Cannot find the file");
        }
    }
    
    public static int findMaxTwo(int[][] matrix){
        //Defining variables for loop
        int max = matrix[0][0];
        
        //Nested for loop that finds the maximum number
       for(int i = 0; i < 50; i++){
            int j = 0;
            while(j<19){
                if(max < matrix[i][j+1]){
                    max = matrix[i][j+1];
                }
                j++;
            }
            
        }
        return max;
    }

    public static int findMinTwo(int[][] matrix){
        
        int min = matrix[0][0];
        
        //Nested for loop that finds the maximum number
       for(int i = 0; i < 50; i++){
            
            for(int j = 0; j < 19; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
                
            }
            
        }
        return min;
    }
    public static void main(final String[] args) {
        
        //Calling methods in main
        
        //Part one
        fillArray(numbers);
        System.out.println(findMax(numbers));
        System.out.println(findMin(numbers));
        
        int i = 0;
        while(i<count-1){
            System.out.println(percentChange(numbers)[i]);
            i++;
        }
        

        //Part two
        fillArrayTwo(twoDimensional);
        System.out.println(findMaxTwo(twoDimensional));
        System.out.println(findMinTwo(twoDimensional));
    }
}
