public class Products {


    String productName;
    double productPrice;


    public Products(String productName, double productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void displayInfo(){
        System.out.println("Product: " + productName + ", Price: $" + productPrice);
    }
}
