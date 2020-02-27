//Kaiya Hogg
//Temperature source file

public class Temperature{
    
    //Instance varaiables
    public double temp;
    public enum Degrees{F, C};

    //Creating the constructor
    public Temperature(){}

    //Creating conversion from F to C
    public double getCelsius(){
        
        double degreesC = (5*(this.temp - 32))/9;
        degreesC = (double) Math.round(degreesC*100)/100;

        return degreesC;
    }

    //Conversion from C to F
    public double getFahrenheit(){

        double degreesF = (9*(this.temp)/5)+32;
        degreesF = (double) Math.round(degreesF*100)/100;

        return degreesF;
    }

    //Setter that sets the inputted temp as temp
    public void setTemp(double temp){
        
        this.temp = temp;
    }

    //Setter that sets the inputted measurement of degrees
    public void setDegrees(Degrees degrees){

        if (degrees == Degrees.C) degrees = Degrees.C;

        else degrees = Degrees.F;
    }

    //Setter that sets both inputtedt measurement in degrees and temp
    public void setBoth(Degrees degrees, double temp){

        setTemp(temp);
        setDegrees(degrees);

    }

    //Boolean that returns true if temp is equal to temp post conversion
    public boolean equals(double t){
        
        return t == this.temp;
        
    }

    //Another comparison that compares temp to temp post conversion
    public int compareTo(double t){
        if (this.temp > t){
            return 1;
        }

        if (this.temp < t){
            return -1;
        }

        else return 0;
        
    }

    //toString method
    //@Override
    public String toString(){

        //Defining local variables
        String weather = "";
        Degrees degrees = Degrees.F;
        
        if (degrees == Degrees.C) weather = "Temperature outside is: " + this.temp + "C. Converting to F: " + getFahrenheit() + ". Is equal: "
            + equals(getFahrenheit())+ " " + compareTo(getFahrenheit());
        else weather = "Temperature outside is: " + this.temp + "F. Converting to C: " + getCelsius() + ". Is equal: "
            + equals(getCelsius())+ " " + compareTo(getCelsius());;
        

        return weather;
    }
}