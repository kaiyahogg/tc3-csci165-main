import java.util.*;
import java.io.*;

public class Address{

    //Fields

    private String street;
    private String city;
    private String state;
    private String zip;
    //private HashMap<String,String> postalHash = new HashMap<String,String>();

    //Constructors

    Address(){}

    //copy constructor
    Address(Address copy){
        
        this.street = copy.street;
        this.city = copy.city;
        this.state = copy.state;
        this.zip = copy.zip;
    }

    Address(String street, String city, String state, String zip){
        setStreet(street);
        this.city = city;
        this.state = state;
        setZip(zip);
    }

    Address(String street, String zip){
        setStreet(street);
        this.city = getCity();
        this.state = getState();
        setZip(zip);
    }

    //Method that parses through zip csv
   
   /*
    private HashMap<String,String> fillPostalHash(){

        try{
            File file = new File("zip_code_database.csv");
            Scanner sc = new Scanner(file);

            for(int i = 0; sc.hasNext(); i++){

                
            }

            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Unable to locate file");
        }
        
        return matrix;
    } */

    //Setters

    public void setStreet(String street){

        this.street = street;
    }

    public void setZip(String zip){
        
        this.zip = zip;
    }

    //Getters

    public String getStreet(){
        
        return street;
    }

    public String getCity(){
        
        return city;
    }

    public String getState(){
       
        return state;
    }

    public String getZip(){

        return zip;
    }

    //equals and toString methods

    public boolean equals(Address otherAddress){
        return this.street.equals(otherAddress.street) &&
                this.city.equals(otherAddress.city) &&
                this.state.equals(otherAddress.state) &&
                this.zip.equals(otherAddress.zip);
    }

    //@Override
    public String toString(){
        
        String address = street + ", " + state + ", " + city + ", " + zip;

        return address;
    }
}