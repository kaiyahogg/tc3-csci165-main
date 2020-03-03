//CountyResults class

import java.io.*;
import java.util.*;

public class CountyResults2016{

    public int demVotes;
    public int gopVotes;
    public int totalVotes;
    private double percentDem;
    private double percentGOP;
    public int difference;
    public String percentDifference;
    public String stateAbbreviation;
    public String county;
    private int fips;

    public static String[][] array = new String[3140][10];

    public CountyResults2016() {
    }

    public void fillArray(String[][] array) {

        try {
            BufferedReader fr = new BufferedReader(new FileReader("2016_US_County_Level_Presidential_Results.txt"));
            //Scanner sc = new Scanner(fr);
            List<String> lines = new ArrayList<String>();
            String line;
                while((line = fr.readLine()) != null) {
                    lines.add(line);
                }
                

            fr.close();
            //sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public int getTotalVotes(String[][] array, int index) {

        totalVotes = Integer.valueOf(array[index][2]);

        return totalVotes;
    }

    public int getDemVotes(String[][] array, int index) {

        demVotes = Integer.valueOf(array[index][0]);

        return demVotes;
    }

    public int getGOPVotes(String[][] array, int index) {

        gopVotes = Integer.valueOf(array[index][1]);

        return gopVotes;
    }

    public int getDifference(String[][] array, int index) {

        int dem = getDemVotes(array, index);
    	int gop = getGOPVotes(array, index);
    	
        if (gop < dem){
        	
        	difference = dem - gop;
        }
        else difference = gop - dem; 

        return difference;
    }

    public String getPercentDifference(String[][] array, int index) {

        percentDifference = array[index][6];

        return percentDifference;
    }

    public String getState(String[][] array, int index) {

        stateAbbreviation = array[index][7];

        return stateAbbreviation;
    }

    public String getCounty(String[][] array, int index) {

        county = array[index][8];

        return county;
    }

    //@Override
    public String toString(int i){
        
        String results = ("Total: " + getTotalVotes(array, i) + "\nDem votes: " + getDemVotes(array, i) + 
        "\nGOP votes: " + getGOPVotes(array, i) + "\nDifference: " + getDifference(array, i) +  
        "\nPercentage of Difference: " + getPercentDifference(array, i) + "\nState: " 
        + getState(array, i) + "\nCounty: " + getCounty(array, i));

        return results;
    }

}