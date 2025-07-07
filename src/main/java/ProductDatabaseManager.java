import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabaseManager{
    public static void insertProduct(Products product) {
        String uri = "mongodb+srv://admin:0000@jasur977.vqybjhb.mongodb.net/?retryWrites=true&w=majority&appName=Jasur977";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("shoppingApp");
            MongoCollection<Document> collection = database.getCollection("products");

            Document doc = new Document("productName", product.getProductName())
                    .append("productPrice", product.getProductPrice());
            collection.insertOne(doc);

            System.out.println("✅ Product inserted into MongoDB!");
        }
    }


    public static List<Products> readProducts() {
        String uri = "mongodb+srv://admin:0000@jasur977.vqybjhb.mongodb.net/?retryWrites=true&w=majority&appName=Jasur977";

        List<Products> products = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("shoppingApp");
            MongoCollection<Document> collection = database.getCollection("products");

            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                String name = doc.getString("productName");
                double price = doc.getDouble("productPrice");
                products.add(new Products(name, price));
            }

            System.out.println("✅ Products loaded from MongoDB!");
        }
        return products;
    }


}