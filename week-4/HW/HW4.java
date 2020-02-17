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
            change[i] += ((double)(array[i+1]-array[i])/array[i])*100.00;
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
                    
                    //for loop that goes through the columns
                    for(int j = 0; j < 20; j++){   
                        matrix[i][j] += scanner.nextInt();
                        
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
    
    //Second findMax method
    public static int findMaxTwo(int[][] matrix){
        //Defining variables for loop
        int max = matrix[0][0];
        
        //Nested for loop that finds the maximum number
       for(int i = 0; i < 50; i++){
            
           for(int j = 0; j < 20; j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }   
            } 
        }
        return max;
    }

    //Second findMin method
    public static int findMinTwo(int[][] matrix){
        
        int min = matrix[0][0];
        
        //Nested for loop that finds the maximum number
       for(int i = 0; i < 50; i++){
            
            for(int j = 0; j < 20; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    //findMaxOfRow method
    public static int findMaxOfRow(int[][] matrix, int row){
        
        int max = matrix[row][0];
        
        for(int i=0; i<20; i++){
            if(matrix[row][i]>max){
                max = matrix[row][i];
            }
        } 
        return max;
    }

    //findMinOfRow method
    public static int findMinOfRow(int[][] matrix, int row){
        
        int min = matrix[row][0];
        
        for(int i=0; i<20; i++){
            if(matrix[row][i]<min){
                min = matrix[row][i];
            }
        } 
        return min;
    }

    //findMaxOfColumn method
    public static int findMaxOfColumn(int[][] matrix, int column){
        
        int max = matrix[0][column];
        
        for(int i=0; i<20; i++){
            if(matrix[i][column]>max){
                max = matrix[i][column];
            }
        } 
        return max;
    }

    //findMinOfColumn method
    public static int findMinOfColumn(int[][] matrix, int column){
        
        int min = matrix[0][column];
        
        for(int i=0; i<20; i++){
            if(matrix[i][column]<min){
                min = matrix[i][column];
            }
        } 
        return min;
    }

    //printRow method (Reads in column major order)
    public static void printRow(int[][] matrix, int row, int num_cols){
        
        int counter = 0;
        int[][] printedRow = new int[20/num_cols][num_cols];
        
        for(int i = 0; i < num_cols; i++){
            int j = 0;

            while(j < 20/num_cols){
                
                printedRow[j][i] += matrix[row][counter];
                j++;
                counter++;
            }
        }
        System.out.println(Arrays.deepToString(printedRow));
    }

    //smallestChange method (Reads in column major order)
    public static int smallestChange(int[][] matrix){
        
        int rowIndex = 0;
        //number obtained by taking the total amount of change from the first row (was negative)
        int minimumChange = 5645;
        int change = 0;

        for(int j = 0; j <50; j++){
            //Resetting change
            change = 0;

            //Inner for to find the total amount of change
            for(int i = 1; i < 20; i++){
                
                change += (matrix[j][i] - matrix[j][i-1]);
                
            }
            //System.out.println(j +" "+Math.abs(change));
            
            //Comparing totalChange with the totalChange from the last row index
            //Using absolute value since we are interested in overrall change
            if(minimumChange > Math.abs(change)){
                minimumChange = Math.abs(change);
                rowIndex = j;
            }
        }
        
        return rowIndex;
    }

    //Second smallestChange method (overrall smallest change)
    public static int smallestChangeOverrall(int[][] matrix){
        
        int rowIndex = 0;
        //number obtained by taking the total amount of change from the first row
        int minimumChange = 59333;
        int change = 0;

        for(int j = 0; j <50; j++){
            //Resetting change
            change = 0;

            //Inner for to find the total amount of change
            for(int i = 1; i < 20; i++){
                
                //Using absolute value since we are interested in overrall change
                change += Math.abs(matrix[j][i] - matrix[j][i-1]);
            }
            //System.out.println(j +" "+Math.abs(change));
            
            //Comparing totalChange with the totalChange from the last row index
            
            if(minimumChange > (change)){
                minimumChange = (change);
                rowIndex = j;
            }
        }
        
        return rowIndex;
    }

    public static void main(final String[] args){
        
        //Establishing a scanner for user input
        Scanner input = new Scanner(System.in);

        //Calling methods in main
        
        //Part one
        System.out.println("\n\n"+"Part I"+"\nThings look kinda ugly, but our protagonist Array looks promising...");
        fillArray(numbers);
        System.out.println("Max of Array: " + findMax(numbers));
        System.out.println("Min of Array: " + findMin(numbers));
        System.out.println("\nAn array containing the percentage change of every value in Array:\n" + Arrays.toString(percentChange(numbers)));
        System.out.println("\nPress enter to see how our protagonist 'The Array' grows and what kinds of powers they'll possess \nctrl+c if you want your money back");
        String filler = input.nextLine();

        //Part two
        System.out.println("\n\n"+"Part II"+"\nArray swallowed the red pill. \n");
        fillArrayTwo(twoDimensional);
        System.out.println("Max of Matrix: " + findMaxTwo(twoDimensional));
        System.out.println("Min of Matrix: " + findMinTwo(twoDimensional));
        
        System.out.println("\nEnter a number between 0-49 to find the maximum value of that row:");
        String userInput = input.nextLine();
        System.out.println("Max of row" + userInput + ": " + findMaxOfRow(twoDimensional, Integer.valueOf(userInput)));
        
        System.out.println("\nEnter a number between 0-49 to find the minimum value of that row:");
        String userInputTwo = input.nextLine();
        System.out.println("Min of row" + userInputTwo + ": " + findMinOfRow(twoDimensional, Integer.valueOf(userInputTwo)));
        
        System.out.println("\nEnter a number between 0-19 to find the maximum value of that column:");
        String userInputThree = input.nextLine();
        System.out.println("Max of column" + userInputThree + ": " + findMaxOfColumn(twoDimensional, Integer.valueOf(userInputThree)));
        
        System.out.println("\nEnter a number between 0-19 to find the minimum value of that column:");
        String userInputFour = input.nextLine();
        System.out.println("Min of column" + userInputFour + ": " + findMinOfColumn(twoDimensional, Integer.valueOf(userInputFour)));

        System.out.println("\nPress enter to check out the epic finale in your terminal instead of theatres (legally) \nctrl+c if you've had enough");
        String fillerTwo = input.nextLine();
        
        //Part three
        System.out.println("\n\n"+"Part III"+"\nWe won't find out how Array get to row echelon form in this trilogy");
        
        System.out.println("\nEnter a number between 0-49:");
        String userInputFive = input.nextLine();
        System.out.println("\nLastly, enter a number between 0-19:");
        String userInputSix = input.nextLine();
        System.out.println("Row " + userInputFive + " formatted to " + userInputSix + " columns.");
        printRow(twoDimensional, Integer.valueOf(userInputFive), Integer.valueOf(userInputSix));
        
        System.out.println("\nIndex of row with least amount of change relative to the initial value: " + smallestChange(twoDimensional));
        System.out.println("Index of row with lesat amount of overrall change: " + smallestChangeOverrall(twoDimensional));
    }
}
