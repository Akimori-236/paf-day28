package nus.iss.tfip.pafday28.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import nus.iss.tfip.pafday28.Constants;

@Repository
public class PlaystoreRepository implements Constants{

    @Autowired
    private MongoDatabase db;
    // apps collection
    MongoCollection<Document> collection = db.getCollection(COLLECTION_APPS, Document.class);
    public List<Document> sortAppsByCategory() {
        collection.
    }
}
