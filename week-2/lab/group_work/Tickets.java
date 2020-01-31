//Kaiya Hogg Patrick Temple

//Imported classes
import java.util.Scanner;               //scans files
import java.io.File;                    //for the object type file
import java.io.FileNotFoundException;   //for problems regarding not being able to find the file
import java.io.FileWriter;              //writes to a new file
import java.io.IOException;             //for problems regarding writing a new file

public class Tickets{

    public static void main(String[] args){

        /* 
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt   

        */
        //scanner throwin into try/catch
        try{
            
            File ticketlist = new File("tickets.txt"); //opens file scanner to scan tickets.txt

            Scanner checker = new Scanner(ticketlist);

            FileWriter validTix = new FileWriter("validtix.txt");

            
            //counters set            
            int counter = 0;
            int validTixCounter = 0; 
            //while loop where hasNext() checks to see if there
            while (checker.hasNext()) {
                
                //copied from given code, only changing the example string to whatever line the scanner is reading
                String  ticket  = (checker.nextLine());                                 //ticket is set as string
                String  last = ticket.substring(ticket.length() - 1);                   //index the last number in the ticket       
                int     last_digit = Integer.valueOf(last);                             //converts indexed number to an integer
                String  reduced_ticket = ticket.substring(0, ticket.length() - 1);      //creates a substring where the last digit is not included
                int     ticket_number = Integer.valueOf(reduced_ticket);                //converts it to an integer
                int     remainder = ticket_number % 7;                                  //modulo 7 to get a remainder
                boolean validity = remainder == last_digit;                             //creates a boolean that returns true when remainder is equal to the last digit
                String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";  //message is formatted
                
                System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);  //prints the result
                
                //if statement using boolean previously defined
                if (validity == true){
                    validTix.write(ticket + '\n'); //this way only valid ticket #'s are written to the new file
                    validTixCounter++;  //raises the counter by 1 to help keep track of the number of valid tickets
                }

                counter++;  //counter for total # of tickets
            }

            /*String  ticket  = "123454";                                           //ticket is set as string
            String  last = ticket.substring(ticket.length() - 1);                   //index the last number in the ticket       
            int     last_digit = Integer.valueOf(last);                             //converts indexed number to an integer
            String  reduced_ticket = ticket.substring(0, ticket.length() - 1);      //creates a substring where the last digit is not included
            int     ticket_number = Integer.valueOf(reduced_ticket);                //converts it to an integer
            int     remainder = ticket_number % 7;                                  //modulo 7 to get a remainder
            boolean validity = remainder == last_digit;                             //creates a boolean that returns true when remainder is equal to the last digit
            String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";  //message is formatted
            System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);  //prints the result
            */
            
            //message that prints to show user that the correct number of tickets are read and correct number is validated
            System.out.println("Of the " + counter + " tickets processed, " + validTixCounter + " are valid");
            
            //Important to close the scanner and writer
            validTix.close();
            checker.close();
            //ticketlist.close();
        } //end of try
        catch(FileNotFoundException fnf){
            System.out.println("ERROR: File not found"); //message when file cannot be found
        }//end of catch
        catch(IOException e){
            System.out.println("Error: File writing problem occured");
        }//end of io catch
    }
}