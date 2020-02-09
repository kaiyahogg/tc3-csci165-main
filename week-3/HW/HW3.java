//Kaiya Hogg

//Importing classes

import java.io.*;
import java.util.*;

public class HW3 {
    
    public static void main(String[] args){
        //try catch
        try{
            //Setting up scanners as a variables
            Scanner input = new Scanner(System.in);
            

            //Defining the Symbol Code
            String code = "*BEA@FK%RM";

            //Printing the user prompt
            System.out.println("Please enter a sequence of base 10 digits (e.g. 487692):");
            
            //Reading input as string
            String userInput = input.nextLine();
            
            //Creating the while loop
            int count = 0;
            String encodedString = "";
            
            while(count < userInput.length()){
                int index = Integer.valueOf(userInput.substring(count,count+1));
                int codeIndex = index;
                encodedString += code.charAt(codeIndex);
                count++;
            }
            
            System.out.println(encodedString);
            
            //Prompt for second homework problem
            System.out.println("Press enter to encode the file number.txt, press ctrl+c if you do not wish to do so...");
            var transition = input.nextLine();

            //Opening reader and writer
            File numbers = new File("numbers.txt");
            Scanner reader = new Scanner(numbers);
            FileWriter encodedWriter = new FileWriter("encodedNumbers.txt");
            
            //Nested loop to convert numbers.txt
            while(reader.hasNext()){
                int countTwo = 0;
                String encoded= "";
                String inputLine = reader.nextLine();

                //Same structure while loop
                while(countTwo < inputLine.length()){
                    int indexTwo = Integer.valueOf(inputLine.substring(countTwo,countTwo+1));
                    int codeIndexTwo = indexTwo;
                    encoded += code.charAt(codeIndexTwo);
                    countTwo++;
                    //if statement to write the encoded once it's the desired length
                    if(encoded.length()==inputLine.length()){
                    
                        encodedWriter.write(encoded+'\n');
                    }
                    
                    
                }
            }
            
            System.out.println("Process has been complete, program is now terminated.");

            //Closing scanners and writer
            input.close();
            reader.close();
            encodedWriter.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("ERROR: File not found"); //message when file cannot be found

        }//end of catch
        
        catch(IOException e){
            System.out.println("Error: File writing problem occured");
        }//end of io catch
    }
}