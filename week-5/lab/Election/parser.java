import java.io.*;
import java.util.*;

public class parser{
    
    static String[] electionResults = new String[3141];
    //static String[][] electionResults = new String[3141][10];

    public static void fillArray(String [] array){

        try {
            BufferedReader fr = new BufferedReader(new FileReader("2016_US_County_Level_Presidential_Results.csv"));
            //Scanner sc = new Scanner(fr);
            List<String> lines = new ArrayList<String>();
            String line;
            
            //while loop that adds each line from csv file to an array list
            while((line = fr.readLine()) != null) {
                lines.add(line);
                
            }
            
            electionResults = lines.toArray(new String[]{});

            fr.close();
            //sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static int getTotalVotes(String[] array, int index) {

        String arrayString = array[index];
        String total = String.join(" ", arrayString);

        int i = total.indexOf(',', total.indexOf(',', total.indexOf(',')+1));
        int totalVotes = Integer.valueOf(array[i]);

        return totalVotes;
    }

    public static void main(String[] args){

        fillArray(electionResults);
        System.out.println(electionResults[1]);
        System.out.println(electionResults[1]);
    }
}