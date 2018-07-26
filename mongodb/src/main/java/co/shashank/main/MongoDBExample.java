package co.shashank.main;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBExample {

	public static void main(String[] args) throws UnknownHostException {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://root:root@cluster0-vq2rq.mongodb.net/test?retryWrites=true");

		MongoClient mongoClient = new MongoClient(uri);

		MongoDatabase database = mongoClient.getDatabase("test");

		MongoCollection<Document> col = database.getCollection("users");

		Document user = new Document("name", "Shrawan").append("role", "XZOXOX");

		// INSERT
		// col.insertOne(user);

		// READ

		try (MongoCursor<Document> cur = col.find().iterator()) {
			while (cur.hasNext()) {

				System.out.println(cur.next());

			}
		}

		// UPDATE
		
		  /*col.updateOne(new Document("name", "shashank"), new
		  Document("$set", new Document("name", "SHANK")));*/
		 

		// close resources
		mongoClient.close();
	}

}
