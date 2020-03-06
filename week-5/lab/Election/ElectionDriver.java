//Election driver
/*
import java.io.*;
import java.util.*;
*/
public class ElectionDriver{
/*
    public String [][] array = new String[3140][9];

    public void fillList(){
        
        //try catch
        try{

            FileReader fr = new FileReader("2016_US_County_Level_Presidential_Results.csv");
            Scanner sc = new Scanner(fr);

            for(int i = 0; i < 3140; i++){
                
                for(int j = 0; j < 9; j++){
                    array[i][j] += sc.nextLine();
                    //ArrayList<CountyResults2016> list = new ArrayList<CountyResults2016>();
                    //CountyResults2016 cr = new CountyResults2016();
                    //list.add(cr);
                }
            }

            fr.close();
            sc.close();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public int findLargestMargin(){
        
        int largestMargin = 0;
        for(int i = 0; i < 3140; i++){
            
            if (largestMargin < Integer.valueOf(array[i][5])){
                largestMargin = Integer.valueOf(array[i][5]);
            }
        }

        return largestMargin;
    }

    //public CountyResults2016 findLargestMargin(String state){

    //}

    //public String[] getStateTotals(){

    //}
        */
    public static void main(String [] args){
        
        CountyResults2016 cr = new CountyResults2016();
        cr.fillArray(CountyResults2016.electionResults);
        System.out.println(cr.toString(1));
        //System.out.println(findLargestMargin());
    }
}