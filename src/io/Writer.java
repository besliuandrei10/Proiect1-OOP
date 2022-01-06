package io;

import database.Child;
import database.Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Writer {

    public Writer() {

    }

    public static JSONObject writeAllChildren() {

        JSONObject output = new JSONObject();
        JSONArray array = new JSONArray();

        for (Child child : Database.getInstance().getChildList()) {
            array.add(child.toJSONObject());
        }
        output.put("children", array);

        return output;
    }
}
