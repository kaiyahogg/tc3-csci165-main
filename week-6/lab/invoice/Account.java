public class Account{

    private int accountID;
    private Customer customer;
    private double balance = 0.0;
    private double creditLimit = 0.0;
    private Date dateCreated;
    private double discountLevel = 0.0;

    public Account(){}

    public Account(int id, Customer customer){

    }

    public Account(int id, Customer customer, double balance, double creditLimit){

    }

    public Customer getCustomer(){
        
        return customer = new Customer(customer);
    }

    public double getBalance(){

        return balance;
    }

    public double getCreditLimit(){

        return creditLimit;
    }

    public void setBalance(double b){

        this.balance = b;
    }

    public void setCreditLimit(double cl){

        this.creditLimit = cl;
    }

    
}