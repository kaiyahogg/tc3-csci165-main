public class Shapes{

    public static void main(String[] args){
        //for loop that goes up to five
        //each step in loop prints out necessary characters
        for (int i = 0; i <= 5; i++) 
        {
        
            //if statements to 
            if (i < 1) {
                System.out.println("***** ***** *****");
            } else if (i < 2) {
                System.out.println("****  *   *  ***");
            } else if (i < 3) {
                System.out.println("***   *   *   *");
            } else if (i < 4) {
                System.out.println("**    *   *  ***");
            } else if (i < 5){
                System.out.println("*     ***** *****");
            }
        }
    }
}
