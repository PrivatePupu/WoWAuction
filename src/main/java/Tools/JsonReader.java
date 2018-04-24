package Tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;
import Entities.Realm;

public class JsonReader {
    
    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
    }
      
    public static String jsonGetRequest(String urlString) {
        String json = null;
        
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(json);
        return json;                                      
    }

public static void readJson(String file) {
        JSONParser parser = new JSONParser();

        try {
            System.out.println("Reading JSON file from Java program");
            StringReader stringReader = new StringReader(file);
            JSONObject json = (JSONObject) parser.parse(stringReader);

            String name = (String) json.get("name");
            String realm = (String) json.get("realm");
            //long price = (long) json.get("price");

            System.out.println("Name: " + name);
            System.out.println("Realm: " + realm);
            //System.out.println("price: " + price);
            
            Realm tmpRealm = new Realm();
            tmpRealm.setRealmName(realm);
            System.out.println("Objektname: " + tmpRealm.getRealmName());
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
}