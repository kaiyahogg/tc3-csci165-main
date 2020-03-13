public class Account{

    //Fields

    private String accountID;
    private Customer customer;
    private double balance = 0.0;
    private double creditLimit = 0.0;
    private Date dateCreated;
    private double discountLevel;

    //Constructors

    public Account(){}

    public Account(Customer customer, Date creation){

        this.customer = new Customer(customer);
        this.dateCreated = creation;
    }

    public Account(Customer customer, double balance, double creditLimit, Date creation){

        this.customer = customer;
        setBalance(balance);
        setCreditLimit(creditLimit);
        this.dateCreated = creation;
    }

    public Account(Account copy){

        this.accountID = copy.accountID;
        this.customer = new Customer(copy.customer);
        this.balance = copy.balance;
        this.creditLimit = copy.creditLimit;
    }

    //Getters

    public Customer getCustomer(){
        
        return customer = new Customer(customer);
    }

    public Date getDateCreated(){

        return dateCreated = new Date(dateCreated);
    }

    public String getID(){
        
        String id = new String();
        
        String name = customer.getName();
        String idStart = new String();

        String date = dateCreated.toString();
        String idDate = new String();
        //Removes vowels
        idStart = name.replaceAll("[aeiouAEIOU ]","");
        idStart = idStart.toUpperCase();

        //Removes '/'s
        idDate = date.replaceAll("/","");

        //Obtaining check digit
        int sum = 0;
        for(int i = 0; i < idStart.length(); i++){
            sum += idStart.charAt(i);
        }
        int length = idStart.length();
        int check = sum % length;

        String checkDigit = "" + check;
        //concatenates everything to id
        id = id.concat(idStart);
        id = id.concat(idDate);
        id = id.concat(checkDigit);
        
        return id;
    }

    public double getBalance(){

        return balance;
    }

    public double getCreditLimit(){

        return creditLimit;
    }

    public double getDiscountLevel(){
        
        double dl = 0;
        
        String created = this.getDateCreated().toString();

        int index = created.lastIndexOf("/");
        int indexEnd = created.length();
        created = created.substring(index+1, indexEnd);

        for(int i=0; i<(2020 - Integer.valueOf(created)); i++) {

            dl += 2;

            
        }
        if(dl<0){
            
            this.discountLevel = dl * -1;
        }
        
        return dl;
    }

    //Setters

    public void setBalance(double b){

        if(b<0){
            this.balance = b*-1;
        }
        
        else this.balance = b;
    }

    public void setCreditLimit(double cl){

        if (cl<0){
            this.creditLimit = cl * -1;

            if(creditLimit>2*balance){
                this.creditLimit = 2*balance;
            }
            else this.creditLimit = cl;
        }
        else{
            if(cl>2*balance){
                this.creditLimit = 2*balance;
            }
            else this.creditLimit = cl;
        }
    }


    public boolean equals(Account otherAccount){

        return this.accountID == otherAccount.accountID && 
                this.customer.equals(otherAccount.customer) &&
                this.balance == otherAccount.balance &&
                this.creditLimit == otherAccount.creditLimit &&
                this.dateCreated.equals(otherAccount.dateCreated) &&
                this.discountLevel == otherAccount.discountLevel;
    }

    public String toString(){
        
        String message = "ID: " + getID() + "\nCustomer: " + customer + "\nBalance: $" + balance +
                        "\nCredit Limit: $" + creditLimit + "\nAccount created on: " + dateCreated +
                        "\nDiscount: " + getDiscountLevel() +"%";
        return message;
    }
    
    public int compareTo(Account otherAccount){

        if (this.balance > otherAccount.balance){
            return 1;
        }

        else if(this.balance < otherAccount.balance){
            return -1;
        }

        else return 0;
    }

}