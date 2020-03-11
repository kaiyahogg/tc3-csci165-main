public class Product{
    private String name;
    private String description;
    private double price;
    private String sku;

    public Product(){}

    public Product(String name, String description, double price, String sku){
        setName(name);
        setPrice(price);
    }

    Product(String sku){

    }

    Product(Product copy){
        this.price = copy.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){

        return name;
    }

    public void setPrice(double price){
        if(this.price<0) this.price = -1*price;

        else this.price = price;
    }

    public double getPrice(){

        return price;
    }
    
    public void setSku(String sku){


        
    }

    public String getSku(){

        return sku;
    }

    public boolean equals(Product otherProduct){
        
        return this.name.equals(otherProduct.name) &&
                this.price == otherProduct.price;
    }

    public String toString(){
        
        String message = "Product: " + name + " $" + price;

        return message;
    }

}