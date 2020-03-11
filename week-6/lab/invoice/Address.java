public class Address{

    private String street;
    private String city;
    private String state;
    private String zip;

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
        //getCity();
        //getState();
        setZip(zip);
    }

    public void setStreet(String street){

        this.street = street;
    }

    public String getStreet(){
        
        return street;
    }

    public String getCity(){
        
        return city;
    }

    public String getState(){

        return state;
    }

    public void setZip(String zip){
        
        this.zip = zip;
    }

    public String getZip(){

        return zip;
    }

    public boolean equals(Address otherAddress){
        return this.street.equals(otherAddress.street) &&
                this.city.equals(otherAddress.city) &&
                this.state.equals(otherAddress.state) &&
                this.zip.equals(otherAddress.zip);
    }

    @Override
    public String toString(){
        
        String address = street + ", " + city + ", " + state + ", " + zip;

        return address;
    }
}