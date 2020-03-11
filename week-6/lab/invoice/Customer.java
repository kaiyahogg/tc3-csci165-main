public class Customer{

    private String firstName;
    private String lastName;
    private String email;
    private Address address;

    public Customer(){}

    public Customer(String firstName, String lastName, String email, Address address){

        setName(firstName, lastName);
        setEmail(email);
        new Address(address);
    }

    public Customer(String firstName, String lastName){

        setName(firstName, lastName);
    }

    //copy constructor
    public Customer(Customer clone){
        this.firstName = clone.firstName;
        this.lastName = clone.lastName;
        this.email = clone.email;
        this.address = new Address(clone.address);
    }

    public void setName(String first, String last){
        
        this.firstName = first;
        this.lastName = last;
    }

    public void setEmail(String email){
        
        //Providing domain validation, once complete email will be set
        //Will not be set if email is not valid
        int i = 0;
        int count = 0;
        String message = "none on file";

        while (i < email.length()){
            if (email.charAt(i) == '@'){
                count += 1;
            }
            i++;
        }
        
        if (count == 1){
            if(email.charAt(-3) == '.' || email.charAt(-4) == '.' && email.indexOf('.') > email.indexOf('@')){
                
                this.email = email;
            }
            else this.email = message;
        }
        else this.email = message;      
    }

    public String getName(){

        return firstName + " " + lastName;
    }

    public String getEmail(){

        return email;
    }

    public boolean equals(Customer otherCustomer){

        return this.firstName.equals(otherCustomer.firstName) &&
                this.lastName.equals(otherCustomer.lastName) &&
                this.email.equals(otherCustomer.email) &&
                this.address.equals(otherCustomer.address);
    }

    @Override
    public String toString(){
        String customer = firstName + " " + lastName + ", " + email + ", " + new Address().toString();

        return customer;
    }
}
