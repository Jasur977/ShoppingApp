import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User admin = new Admin();
        User customer = new Customer();

        Products laptop = new Products("Laptop", 1500);
        Products pc = new Products("Sansui", 1200);
        ArrayList<User> users= new  ArrayList<>();
        users.add(admin);
        users.add(customer);

        ArrayList<Products> products = new ArrayList<>();

        ((Admin) users.get(0)).addProduct(products, new Products("Tablet", 400));
        ((Admin) users.get(0)).removeProduct(products, 1);

        products.add(laptop);
        products.add(pc);

        for (User user : users) {
            if (user instanceof Admin) {
                ((Admin) user).addProduct(products, new Products("Tablet", 400));
            } else if (user instanceof Customer) {
                ((Customer) user).buyProduct(products.get(0));  // Simulate buying the first product
            }
        }



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



    }
}