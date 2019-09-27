package appvn.report.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Util {

    public static String readJson(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
        return jsonArray.toJSONString();
    }

    public static Object convertJsonToObject(String strJsonData, Class<?> classOfT) {
        try {
            Gson gson = getGson();
            return gson.fromJson(strJsonData, classOfT);
        } catch (Exception e) {
            System.out.println(e.toString());
            // logger.error("Loi! convertJsonToObject ", e);
        }
        return null;
    }

    public static List<? extends Object> convertJsonToListObject(String json, Class<?> classOfT) {
        List<Object> result = new ArrayList<>();
        try {
            JsonParser parser = new JsonParser();
            JsonElement elem = parser.parse(json);
            JsonArray jsonArray = elem.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject explrObject = (JsonObject) jsonArray.get(i);
                result.add(convertJsonToObject(explrObject.toString(), classOfT));
            }
        } catch (Exception ex) {
            // LOGGER.error("Loi! convertJsonToObject ", ex);
        }
        if (result.size() <= 0) {
            result = null;
        }
        return result;
    }

    private static Gson getGson() {
        return new GsonBuilder().create();
    }
}
