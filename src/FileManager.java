import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileManager {

    public static void saveProductsToFile(ArrayList<Products> products, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Products product : products) {
                writer.println(product.productName + "," + product.productPrice);
            }
            System.out.println("Admin saved products to " + filename);

        } catch (IOException e) {
            System.out.println("Error saving products to " + e.getMessage());
        }

    }

    public static ArrayList<Products> loadProductsFromFile(String filename) {
        ArrayList<Products> products = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                String name = data[0];
                double price = Double.parseDouble(data[1]);
                products.add(new Products(name, price));
            }
            System.out.println("✅ Products loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error loading products: " + e.getMessage());
        }
        return products;
    }

}