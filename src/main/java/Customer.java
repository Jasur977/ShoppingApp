public class Customer extends User{


        public void buyProduct(Products product){
            System.out.println("Customer bought the product " + product.productName + " with price " + product.productPrice);
        }

}
