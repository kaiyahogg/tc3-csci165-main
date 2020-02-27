//Driver for the temperature class

public class temperatureDriver{
    
    public static void main(String[] args){
        
        Temperature temperature = new Temperature();
        Temperature temperatureTwo = new Temperature();
        Temperature temperatureThree = new Temperature();
        Temperature temperatureFour = new Temperature();

        System.out.println("\n");
        
        System.out.println(temperature.toString(Temperature.Degrees.F));
        
        temperatureTwo.setBoth(Temperature.Degrees.F,100);
        System.out.println(temperatureTwo.toString(Temperature.Degrees.F));

        temperatureThree.setBoth(Temperature.Degrees.C,-40);
        System.out.println(temperatureThree.toString(Temperature.Degrees.C));

        temperatureFour.setBoth(Temperature.Degrees.C,-58);
        System.out.println(temperatureFour.toString(Temperature.Degrees.C));

        System.out.println("\n");
    }
}