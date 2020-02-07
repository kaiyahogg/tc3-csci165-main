//Kaiya Hogg

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FoodTruck{

    public static void main(String[] args){
        //launch file reader into a try catch
        try{
            //Defining contents from textfiles as arrays
            
            //Establishing arrays
            String[] menu = new String [3];
            Double[] prices = new Double [3];
            
            //Opening the files
            File menuText = new File("menu.txt");
            File pricesText = new File("prices.txt");

            //Buffered reading of text files
            Scanner menuReader = new Scanner(menuText);
            Scanner pricesReader = new Scanner(pricesText);

            //While loop to add items from text file to the menu array
            int i = 0;
            while (menuReader.hasNextLine()){
                menu[i] = menuReader.nextLine();
                //System.out.println(menu[i]);
                i++;
            }

            //While loop to add items from text file to the prices array
            int j = 0;
            while (pricesReader.hasNextLine()){
                prices[j] = Double.valueOf(pricesReader.nextLine());
                //System.out.println(prices[j]);
                j++; 
            }
            
            //Constructing the menu input

            //Establishing an input variable
            Scanner input = new Scanner(System.in);

            //Decimal Formatter
            DecimalFormat decimals = new DecimalFormat("0.00");


            //Asking user for their name
            System.out.println("All aboard the CS Foodtruck!!!");
            System.out.println("Enter your name: ");
            
            //Calls scanner for the user's name
            String name = input.nextLine();
    
            //Printing the menu for the user to order from
            System.out.println("Please enter the quantity of items you would like to buy \n");
            System.out.println(menu[0] + " - $" + decimals.format(prices[0]) + ": ");
            int chicken = input.nextInt();
            System.out.println(menu[1] + " - $" + decimals.format(prices[1]) + ": ");
            int fries = input.nextInt();
            System.out.println(menu[2] + " - $" + decimals.format(prices[2]) + ": ");
            int shark = input.nextInt();

            //Constructing the receipt

            //calculating the price the user has to pay (defined as doubles)
            Double taxPercentage = 0.0625;
            Double chickenTotal = prices[0] * chicken;
            Double friesTotal = prices[1] * fries;
            Double sharkTotal = prices[2] * shark;
            Double orderTotal = chickenTotal + friesTotal + sharkTotal;
            Double orderTax = orderTotal * taxPercentage;
            Double orderTotalTax = orderTotal + orderTax;

            //Taking the local date and time
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter invoiceLast = DateTimeFormatter.ofPattern("MMddHHmm");

            //Indexing the name String to prepare for invoice concatenation
            char first = Character.toUpperCase(name.charAt(0));
            char firstSecond = Character.toUpperCase(name.charAt(1));
            char last = Character.toUpperCase(name.charAt(name.indexOf(" ")+1));
            char lastSecond = Character.toUpperCase(name.charAt(name.indexOf(" ")+2));

            //Getting unicode values/sum of unicode, length of string, and product of those two 
            var stringValue = (int)first + (int)last;
            int stringDigits = stringValue * name.length();

            //Constructing the output message
            String invoiceFirst = ""+first+firstSecond+last+lastSecond;
            String invoice = invoiceFirst + stringDigits + currentTime.format(invoiceLast);
            String theDate = currentTime.format(date);
            String theTime = currentTime.format(time);
            
            //Constructing the output message
            String lineOne = ("Invoice: "+invoice+"\nDate: "+theDate+"\nTime: "+theTime+"\n");
            String lineTwo = ("\n"+menu[0]+"        "+chicken+"     "+decimals.format(prices[0])+"     "+decimals.format(chickenTotal)+"\n");
            String lineThree = (menu[1]+"               "+fries+"     "+decimals.format(prices[1])+"     "+decimals.format(friesTotal)+"\n");
            String lineFour = (menu[2]+"        "+shark+"     "+decimals.format(prices[2])+"     "+decimals.format(sharkTotal)+"\n");
            String lineFive = ("\nSubtotal                      "+"$"+decimals.format(orderTotal)+"\nSales Tax (6.25%)              "+"$"+decimals.format(orderTax)+"\nTotal                        "+"$"+decimals.format(orderTotalTax));
            
            //Opening a buffered writer and writing the above lines to it
            FileWriter fileWriter = new FileWriter(invoice+".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(lineOne);
            buffer.write(lineTwo);
            buffer.write(lineThree);
            buffer.write(lineFour);
            buffer.write(lineFive);
            buffer.flush();
            buffer.close();
            
            //Printing the output
            System.out.println(lineOne+lineTwo+lineThree+lineFour+lineFive);

            menuReader.close();
            pricesReader.close();
            input.close();
        }
        
        catch(FileNotFoundException fnf){
            System.out.println("ERROR: File not found"); //message when file cannot be found

        }//end of catch
        
        catch(IOException e){
            System.out.println("Error: File writing problem occured");
        }//end of io catch
    }
}
