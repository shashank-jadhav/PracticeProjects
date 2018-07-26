package co.shashank.main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI(
			    "mongodb+srv://root:root@cluster0-vq2rq.mongodb.net/test?retryWrites=true");

			MongoClient mongoClient = new MongoClient(uri);
			 MongoDatabase database = mongoClient.getDatabase("test");
			
			
			
			System.out.println();

	}

}
