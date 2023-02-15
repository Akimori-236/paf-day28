package nus.iss.tfip.pafday28.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import nus.iss.tfip.pafday28.Constants;

@Repository
public class AppRepository implements Constants{

    @Autowired MongoTemplate template;
/*
db.apps.aggregate([
    {
      $match: {Rating: {$ne: "NaN"}}
    },
    {
        $group: {
            _id: "$Category",
            count: {$sum: 1},
            Apps: {$push: "$App",
            Rating: {$avg: "$Rating"},
            }
        }
    }
])
 */
    public List<Document> sortAppsByCategory() {
        // $ne / $not
        // Criteria criteria = Criteria.where(FIELD_RATING).not().regex("NaN", "i");
        Criteria criteria = Criteria.where(FIELD_RATING).ne(Double.NaN);
        // $match
        MatchOperation matchRating = Aggregation.match(criteria);
        // $group
        GroupOperation groupApps = Aggregation.group(FIELD_CATEGORY)
            .push(
                new Document(FIELD_APP, VALUE_APP)
                .append(FIELD_RATING, VALUE_RATING)
                .append(FIELD_REVIEWS, VALUE_REVIEWS)
                .append(FIELD_PRICE, VALUE_PRICE)
            ).as(FIELD_APPLIST)
            .count().as(FIELD_COUNT);
        Aggregation pipeline = Aggregation.newAggregation(matchRating, groupApps);

        return template.aggregate(pipeline, COLLECTION_APPS, Document.class)
                .getMappedResults();
    }
}
/*
db.apps.aggregate([
    {
      $match: {Rating: {$ne: "NaN"}}
    },
    {
        $group: {
            _id: "$Category",
            count: {$sum: 1},
            Apps: {
                $push: {
                    App: "$App",
                    Rating: "$Rating",
                    Reviews: "$Reviews",
                    Price: "$Price"
                }
            }
        }
    }
])
 */