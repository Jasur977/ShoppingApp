import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {
    public static void main(String[] args) {
        String uri = "mongodb+srv://admin:0000@jasur977.vqybjhb.mongodb.net/?retryWrites=true&w=majority&appName=Jasur977";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("shoppingApp");
            System.out.println("✅ Connected successfully to DB: " + database.getName());
        }
    }
}
