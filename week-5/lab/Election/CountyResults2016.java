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

    public static String[][] electionResults = new String[3140][10];

    public CountyResults2016() {
    }

    public void fillArray(String[][] array) {

        try {
            FileReader fr = (new FileReader("2016_US_County_Level_Presidential_Results.csv"));
            Scanner sc = new Scanner(fr);
            for(int i = 0; i < 3140; i++){
                for(int j = 0; j < 10; j++){
                    while(sc.hasNext()){
                        electionResults[i][j] += sc.next();
                    }
                }
            }
                

            fr.close();
            sc.close();
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
        
        String results = ("Total: " + getTotalVotes(electionResults, i) + "\nDem votes: " + getDemVotes(electionResults, i) + 
        "\nGOP votes: " + getGOPVotes(electionResults, i) + "\nDifference: " + getDifference(electionResults, i) +  
        "\nPercentage of Difference: " + getPercentDifference(electionResults, i) + "\nState: " 
        + getState(electionResults, i) + "\nCounty: " + getCounty(electionResults, i));

        return results;
    }

}