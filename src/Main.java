import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Products> products = FileManager.loadProductsFromFile("products.txt");




        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).displayInfo();
        }
        System.out.println("Enter product number to buy ");


// Customer "buys" the first product


        int selectedProductIndex = scanner.nextInt() -1;

        if (selectedProductIndex >= 0 && selectedProductIndex < products.size()) {
            Products selectedProduct = products.get(selectedProductIndex);
            System.out.println("You bought: " + selectedProduct.productName + " for $" + selectedProduct.productPrice);


            System.out.println("Select payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Crypto");
            int selectedPaymentMethodIndex = scanner.nextInt();
            Payable paymentMethod;
            switch (selectedPaymentMethodIndex) {
                case 1 -> paymentMethod = new CreditCardPayment();
                case 2 -> paymentMethod = new PaypalPayment();
                case 3 -> paymentMethod = new CryptoPayment();
                default -> {
                    System.out.println("Invalid payment method. Defaulting to Crypto.");
                    paymentMethod = new CryptoPayment();
                }
            }
            paymentMethod.processPayment();
        } else {
            System.out.println("❌ Invalid product selection.");
        }


        FileManager.saveProductsToFile(products, "products.txt");
    }

}