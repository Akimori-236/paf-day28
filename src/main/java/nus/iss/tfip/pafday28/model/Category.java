package nus.iss.tfip.pafday28.model;

import org.bson.Document;

import lombok.Data;
import nus.iss.tfip.pafday28.Constants;

@Data
public class Category implements Constants {
    private String id;
    private Integer count;
    private StoreApp applist;
    private Double rating;

    public static Category toCategory(Document doc) {
        Category cat = new Category();
        cat.setId(doc.get(FIELD_OBJ_ID).toString());
        cat.setCount(doc.getInteger(FIELD_COUNT));
        // cat.setApplist(doc.getList(FIELD_APPLIST, String.class));
        cat.setApplist(doc.get(FIELD_APPLIST, StoreApp.class));
        cat.setRating(doc.getDouble(FIELD_RATING));

        System.out.println("CAT >>>" + cat.getId() + cat.getCount() + cat.getRating() + cat.getApplist());
        return cat;
    }
}
