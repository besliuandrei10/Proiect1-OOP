package io;

import database.AnnualChange;
import database.Child;
import database.ChildUpdate;
import database.Database;
import database.Gift;
import enums.Category;
import enums.Cities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Parser {

    public Parser() {

    }

    private static String cityToEnum(final String city) {
        if (city.equals("Cluj-Napoca")) {
            return "CLUJ";
        }
        return city.toUpperCase(Locale.ROOT);
    }

    private static String giftCatToEnum(final String giftCat) {
        if (giftCat.equals("Board Games")) {
            return "BOARD_GAMES";
        }
        return giftCat.toUpperCase(Locale.ROOT);
    }

    /**
     * Parses given file and populates Database with correct Data.
     * @param inputFile
     */
    public static void readFile(String inputFile) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(inputFile));

        JSONObject jo = (JSONObject) obj;

        // read data
        Long numberOfYears = (Long) jo.get("numberOfYears");
        Double santaBudget = Double.valueOf((Long) jo.get("santaBudget"));

        JSONObject initialData = (JSONObject) jo.get("initialData");

        // populate database
        Database.getInstance().setSantaBudget(santaBudget);
        Database.getInstance().setNumberOfYears(numberOfYears);

        // read all children
        JSONArray children = (JSONArray) initialData.get("children");
        for (Object o : children) {
            Child child = new Child();
            JSONObject JSONChild = (JSONObject) o;

            child.setId((Long) JSONChild.get("id"));
            child.setAge((Long) JSONChild.get("age"));

            String city = (String) JSONChild.get("city");
            child.setCity(Cities.valueOf(Parser.cityToEnum(city)));
            child.setFirstName((String) JSONChild.get("firstName"));
            child.setLastName((String) JSONChild.get("lastName"));
            child.setNiceScore(Double.valueOf((Long) JSONChild.get("niceScore")));

            ArrayList<String> giftPreference = (ArrayList<String>) JSONChild.get("giftsPreferences");
            for (String s : giftPreference) {
                String enumReady = Parser.giftCatToEnum(s);
                child.addGiftsPreferences(Category.valueOf(enumReady));
            }

            // add child to database
            Database.getInstance().addToChildList(child);
        }

        // read all gifts
        JSONArray santaGiftsList = (JSONArray) initialData.get("santaGiftsList");
        for (Object o : santaGiftsList) {
            Gift gift = new Gift();
            JSONObject JSONGift = (JSONObject) o;

            gift.setPrice(Double.valueOf((Long) JSONGift.get("price")));
            gift.setProductName((String) JSONGift.get("productName"));

            String category = (String) JSONGift.get("category");
            gift.setCategory(Category.valueOf(Parser.giftCatToEnum(category)));

            // add gift to database
            Database.getInstance().addToGiftsList(gift);
        }

        // read all annual changes
        JSONArray annualChanges = (JSONArray) jo.get("annualChanges");
        for (Object o1 : annualChanges) {
            JSONObject JSONChanges = (JSONObject) o1;
            AnnualChange annualChange = new AnnualChange();

            annualChange.setNewSantaBudget(Double.valueOf((Long) JSONChanges.get("newSantaBudget")));

            // parse newGifts
            JSONArray newGifts = (JSONArray) JSONChanges.get("newGifts");
            for (Object o2 : newGifts) {
                Gift gift = new Gift();
                JSONObject JSONGift = (JSONObject) o2;

                gift.setPrice(Double.valueOf((Long) JSONGift.get("price")));
                gift.setProductName((String) JSONGift.get("productName"));

                String category = (String) JSONGift.get("category");
                gift.setCategory(Category.valueOf(Parser.giftCatToEnum(category)));

                // add gift to annualchange
                annualChange.addNewGifts(gift);
            }

            // parse newChildren
            JSONArray newChildren = (JSONArray) JSONChanges.get("newChildren");
            for (Object o2 : newChildren) {
                Child child = new Child();
                JSONObject JSONChild = (JSONObject) o2;

                child.setId((Long) JSONChild.get("id"));
                child.setAge((Long) JSONChild.get("age"));

                String city = (String) JSONChild.get("city");
                child.setCity(Cities.valueOf(Parser.cityToEnum(city)));
                child.setFirstName((String) JSONChild.get("firstName"));
                child.setLastName((String) JSONChild.get("lastName"));
                child.setNiceScore(Double.valueOf((Long) JSONChild.get("niceScore")));

                ArrayList<String> giftPreference = (ArrayList<String>) JSONChild.get("giftsPreferences");
                for (String s : giftPreference) {
                    String enumReady = Parser.giftCatToEnum(s);
                    child.addGiftsPreferences(Category.valueOf(enumReady));
                }

                // add child to annualchange
                annualChange.addNewChildren(child);
            }

            // parse ChildUpdates
            JSONArray childrenUpdates = (JSONArray) JSONChanges.get("childrenUpdates");
            for (Object o2 : childrenUpdates) {
                ChildUpdate childUpdate = new ChildUpdate();
                JSONObject JSONChildUpdate = (JSONObject) o2;

                childUpdate.setId((Long) JSONChildUpdate.get("id"));
                if (JSONChildUpdate.get("niceScore") != null) {
                    childUpdate.setNiceScore(Double.valueOf((Long) JSONChildUpdate.get("niceScore")));
                }

                ArrayList<String> giftPreference = (ArrayList<String>) JSONChildUpdate.get("giftsPreferences");
                for (String s : giftPreference) {
                    String enumReady = Parser.giftCatToEnum(s);
                    childUpdate.addNewPreferences(Category.valueOf(enumReady));
                }

                // add updates to database
                annualChange.addChildrenUpdates(childUpdate);
            }
            Database.getInstance().addChange(annualChange);
        }

    }
}
