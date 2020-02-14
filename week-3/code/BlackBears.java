import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class BlackBears{
    
    final static int NUM_REGIONS   = 7;
    final static int NUM_MONTHS    = 12;
    final static int[][]     sightings   = new int[NUM_REGIONS][NUM_MONTHS];
    public static void main(String[] args){

        String      fileName    = "";
        
        String[]    months      = { "January", "February", "March", "April", "May", 
                                    "June", "July", "August", "September", "October",
                                    "November", "December"};

        if(args.length > 0){
            fileName = args[0];
            fillArray(sightings, fileName);
        
                // compute average per month
                for(int i = 0; i < NUM_MONTHS; ++i){
                    double sum = 0.0;
                    for(int j = 0; j < NUM_REGIONS; ++j)
                        sum += sightings[j][i];
                    System.out.printf("Average for %s:\t %.2f \n", months[i], sum / NUM_REGIONS);
                }

                System.out.println("\n");

                // compute average per region
                for(int i = 0; i < NUM_REGIONS; ++i){
                    double sum = 0;
                    for(int j = 0; j < NUM_MONTHS; ++j)
                        sum += sightings[i][j];
                    System.out.printf("Average for Region %d:\t %.2f \n", i+1, sum / NUM_MONTHS);
                }
            }else System.out.println("No file name specified . . . aborting");
        }//end of main
    

    public static void fillArray(int[][] array, String fileName){
        try{
            FileReader fr   = new FileReader(fileName);
                Scanner scanner = new Scanner(fr);

                // load the table with the sightings data
                for(int i = 0; i < NUM_REGIONS; i++){
                    String line     = scanner.nextLine();
                    String[] values = line.split(",");
                    for(int j = 0; j < NUM_MONTHS; ++j){
                        sightings[i][j] = Integer.parseInt(values[j]);
                        System.out.println(sightings[i][j]);
                    } // end inner for
                } // end outer for
            scanner.close();
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    
    }//end of class
}

