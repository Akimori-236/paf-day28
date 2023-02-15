package nus.iss.tfip.pafday28.model;

import java.util.List;

import org.bson.Document;

import lombok.Data;
import nus.iss.tfip.pafday28.Constants;

@Data
public class Category implements Constants {
    private String id;
    private Integer count;
    private List<String> applist;
    private Double rating;

    public static Category toCategory(Document doc) {
        Category cat = new Category();
        cat.setId(doc.getString(FIELD_OBJ_ID));
        cat.setCount(doc.getInteger(FIELD_COUNT));
        cat.setApplist(doc.getList(FIELD_APPLIST, String.class));
        cat.setRating(doc.getDouble(FIELD_RATING));
        return cat;
    }
}
