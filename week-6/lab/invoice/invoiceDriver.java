import java.io.*;
import java.util.*;

public class invoiceDriver{
    static String[] invoices = new String[1000];
    //String[] customers = new String[1000];
    static String[][] customers = new String[1000][5];

    //Having trouble filling customers array
    //Using as placeholder
    public static void fillCustomers(){
        
        try (Scanner sc = new Scanner(new File("customers.txt"))){
            
            while (sc.hasNext()){
                break;
            }
            
            

        }
        catch (FileNotFoundException error){

        }
    }

    public static void fillInvoice(){
        
        for(int i = 0; i< 1000; i++){
            double balance = Math.ceil((Math.random()*5000)+1)*100/100;
            Date date = new Date(03,11,2020);
            Date creation = new Date((int)Math.floor((Math.random()*28)+1),11,(int)Math.floor((Math.random()*15)+2005));
            Address address = new Address(customers[i][3], customers[i][4]);
            //Product sku = new Product("001hey");
            //Product product = new Product("Toilet Paper", "To wipe things", 2.99, "004hhadjhe");
            Customer customer = new Customer(customers[i][0], customers[i][1], "sample@gmail.com", address);
            Account account = new Account(customer, balance, balance*.1,creation);
            
            Invoice invoice = new Invoice("12asdh1", account, 2.99, date);

            invoices[i] += invoice;
        }
    }
    public static void main(String[] args){
        /*
        Date date = new Date(03,11,2020);
        Date creation = new Date(03,11,2019);
        Address address = new Address("123 Sesame St.", "10001");
        //Product sku = new Product("001hey");
        //Product product = new Product("Toilet Paper", "To wipe things", 2.99, "004hhadjhe");
        Customer customer = new Customer("Big", "Bird", "big.bird@gmail.com", address);
        Account account = new Account(customer, creation);
        
        Invoice invoice = new Invoice("12asdh1", account, 2.99, date);
        
        System.out.println("\n" + invoice + " \n");
        */
        fillCustomers();
        fillInvoice();
        int i = 0;
        Scanner input = new Scanner(System.in);
        while(i<1000){
            System.out.println("\n" + invoices[i]);
            System.out.println("\nPress 'Enter' to view next invoice...");
            String filler = input.nextLine();


            i++;
        }
        input.close();
    }
}