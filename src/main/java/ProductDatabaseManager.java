import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.List;
import io.github.cdimascio.dotenv.Dotenv;

public class ProductDatabaseManager{
    public static void insertMultipleProducts(List<Products> products) {
        Dotenv dotenv = Dotenv.load();
        String uri = dotenv.get("MONGODB_URI");
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("shoppingApp");
            MongoCollection<Document> collection = database.getCollection("products");

            List<Document> documents = new ArrayList<>();
            for (Products product : products) {
                Document doc = new Document("productName", product.getProductName())
                        .append("productPrice", product.getProductPrice());
                documents.add(doc);
            }

            collection.insertMany(documents);
            System.out.println("✅ Products inserted successfully!");
        }
    }


    public static List<Products> readProducts() {
        Dotenv dotenv = Dotenv.load();
        String uri = dotenv.get("MONGODB_URI");
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