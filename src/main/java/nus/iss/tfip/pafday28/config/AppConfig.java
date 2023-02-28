package nus.iss.tfip.pafday28.config;

import org.bson.Document;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import nus.iss.tfip.pafday28.Constants;

@Configuration
public class AppConfig implements Constants {

    // get mongo URL from app.properties
    @Value("${mongo.url}")
    private String mongoUrl;

    @Primary
    @Bean(name=QUALIFIER_MONGOTEMPLATE)
    public MongoTemplate createMongoTemplate() {
        // create client
        MongoClient client = MongoClients.create(mongoUrl);
        // return template with client and database (must be correct)
        return new MongoTemplate(client, DATABASE_PLAYSTORE);
    }

    // @Bean(name=QUALIFIER_MONGODB)
    // public MongoDatabase getMongoDB() {
    //     // create a client
    //     MongoClient client = MongoClients.create(mongoUrl);
    //     // Get DB from client
    //     MongoDatabase db = client.getDatabase(DATABASE_PLAYSTORE);
    //     // Use collection
    //     // MongoCollection<Document> apps = db.getCollection(COLLECTION_APPS, Document.class);
    //     return db;
    // }
}
