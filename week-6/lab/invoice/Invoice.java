import java.util.*;

public class Invoice{

    //Fields

    private String invoiceNumber;
    private Account account;
    private double amount = 0.0;
    private Date orderDate;
    //private ArrayList<Product> products = new ArrayList<Product>();

    //Constructors

    public Invoice(){}

    public Invoice(String invNum, Account acct, double amount, Date date){
        this.invoiceNumber = invNum;
        this.account = acct;
        this.amount = amount;
        this.orderDate = new Date(date);
    }

    public Account getAccount(){
        return account = new Account(account);
    }

    //Getters

    public double getAmount(){

        return amount;
    }

    public Date getDate(){

        return orderDate = new Date(orderDate);
    }

    public double getAmountDue(){
        amount = amount-(amount*(account.getDiscountLevel()/100));
        return Math.ceil(amount*100)/100;
    }

    //Setters

    public void setDate(Date date){

        this.orderDate = new Date(date);
    }

    //toString and compareTo methods

    public String toString(){
        
        String message = "Invoice Number " + invoiceNumber + "\nAccount: " + account + "\nAmount Due: $" + getAmountDue() +
                        "\nDate: " + orderDate; 
        return message;
    }

    public int compareTo(Invoice otherInvoice){
        if (this.getAmountDue() > otherInvoice.getAmountDue()) return 1;

        else if (this.getAmountDue() < otherInvoice.getAmountDue()) return -1;

        else return 0;
    }

}