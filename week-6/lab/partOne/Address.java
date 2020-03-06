public class Address{

    private String street;
    private String city;
    private String state;
    private String zip;

    Address(){}

    Address(String street, String city, String state, String zip){
        setStreet(street);
        getCity();
        getState();
        setZip(zip);
    }

    public void setStreet(String street){

        this.street = new Address().street;
    }

    public String getStreet(){
        
        return new Address().street;
    }

    public String getCity(){
        
        return new Address().city;
    }

    public String getState(){

        return new Address().state;
    }

    public void setZip(String zip){
        
        this.zip = new Address().zip;
    }

    public String getZip(){

        return new Address().zip;
    }

    public boolean equals(Address otherAddress){
        return this.street == otherAddress.street &&
                this.city == otherAddress.city &&
                this.state == otherAddress.state &&
                this.zip == otherAddress.zip;
    }

    @Override
    public String toString(){
        
        String address = street + ", " + city + ", " + state + ", " + zip;

        return address;
    }
}