
import java.util.ArrayList;


public class Admin extends User{


    public void addProduct(ArrayList<Products> products, Products product){
        products.add(product);
        System.out.println("Admin added product: " + product.productName);
    }

    public void removeProduct(ArrayList<Products> products, int index){
        if (index >= 0 && index < products.size()){
           Products removed =  products.remove(index);
           System.out.println("Admin removed product: " + removed.productName);
        }
        else{
            System.out.println("Product not found");
        }
    }




}
