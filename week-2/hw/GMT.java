//Kaiya Hogg
//Prints the current time in GMT



public class GMT{

    public static void main (String[] args){
        
        //time is set to total time in milliseconds
        long time = (System.currentTimeMillis());
        
        //getting total hours, minutes, seconds
        long sec = time/1000;
        long minutes = sec/60;
        long hour = minutes/60;
        
        //conveting to hh,mm,ss
        long csec = sec%60;
        long cminutes = minutes%60;
        long chour = hour%24;
        
        System.out.println("Current time in GMT is: " + chour + ":" + cminutes + ":" + csec);
        

    }
}
