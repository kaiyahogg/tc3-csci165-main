//Kaiya Hogg
//Temperature source file

public class Temperature{
    
    //Instance varaiables
    private double temp;
    private enum Degrees{F, C};

    //Creating the constructor
    public Temperature(){}

    public double getCelsius(){
        
        double DegreesC = 5(degreesF - 32)/9;

        return DegreesC;
    }

    public double getFahrenheit(){

        double DegreesF = (9(degreesC)/5)+32;

        return DegreesF;
    }

    public void setTemp(double temp){
        
        this.temp = temp;
    }

    public void setDegrees(Degrees degrees){

        if degrees == Degrees.C Degrees.C = degrees;

        if degrees == Degrees.F Degrees.F = degrees;

    }

    public void setBoth(Degrees degrees, double temp){

    }

    public boolean equals(Temperature t){
        return this.temp = t.temp;
    }

    public int compareTo(Temperature t){
        if this.temp > t.temp{
            return 1;
        }

        if this.temp < t.temp{
            return -1;
        }

        if this.temp == t.temp{
            return 0;
        }
    }

}