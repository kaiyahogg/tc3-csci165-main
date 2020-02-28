//Election driver

import java.io.*;
import java.util.*;

public class ElectionDriver{

    public void fillList(){
        
        //try catch
        try{

            FileReader fr = new FileReader("2016_US_County_Level_Presidential_Results.csv");
            Scanner sc = new Scanner(fr);

            for(int i = 0; i < 3140; i++){
                ArrayList<CountyResults2016> list = new ArrayList<CountyResults2016>();
                CountyResults2016 cr = new CountyResults2016();
                list.add(cr);
            }

            fr.close();
            sc.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public CountyResults2016 findLargestMargin(){

    }

    public CountyResults2016 findLargestMargin(String state){

    }

    public String[] getStateTotals(){
        
    }

    public void main(String [] args){

    }
}