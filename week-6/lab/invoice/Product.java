public class Product{
    
    //Fields

    private String name;
    private String description;
    private double price;
    private String sku;

    //Constructors

    public Product(){}

    public Product(String name, String description, double price, String sku){
        
        setName(name);
        setDescriptpion(description);
        setPrice(price);
        setSku(sku);
    }

    Product(String sku){
        
        setSku(sku);
    }

    Product(Product copy){
        this.name = copy.name;
        this.description = copy.description;
        this.price = copy.price;
        this.sku = copy.sku;
    }

    //Setters

    public void setName(String name){
        
        this.name = name;
    }

    public void setDescriptpion(String description){

        this.description = description;
    }

    public void setPrice(double price){
        
        if(price<0) this.price = -1*price;

        else this.price = price;
    }
    
    public void setSku(String sku){

        //Domain validation for sku
        if (sku.length() == 10){
            if(sku.substring(0,3).equals("001") || 
                sku.substring(0,3).equals("002") ||
                sku.substring(0,3).equals("003") ||
                sku.substring(0,3).equals("004") ||
                sku.substring(0,3).equals("110")){
                this.sku = sku;
            }
            else this.sku = "Invalid sku";
        }
        else this.sku = "Invalid sku";
        
    }

    //Getters

    public String getName(){

        return name;
    }

    public String getDescritpion(){

        return description;
    }

    public double getPrice(){

        return price;
    }
    
    public String getSku(){

        return sku;
    }

    //equals() and toString() methods

    public boolean equals(Product otherProduct){
        
        return this.name.equals(otherProduct.name) &&
                this.description.equals(otherProduct.description) &&
                this.price == otherProduct.price &&
                this.sku.equals(otherProduct.sku);
    }

    public String toString(){
        
        String message = "Product: " + name + " $" + price + " Sku: " + sku;

        return message;
    }

}