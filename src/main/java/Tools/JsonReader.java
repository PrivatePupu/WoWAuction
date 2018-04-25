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
            System.out.println("Kein Spieler mit diesem Namen vorhanden");
            
            //ex.printStackTrace();
        }
        return json;                                      
    }

public static void readJson(String file) {
        JSONParser parser = new JSONParser();


        try {
            StringReader stringReader = new StringReader(file);
            JSONObject json = (JSONObject) parser.parse(stringReader);
            
            if (json.get("status") == "nok"){
                String reason = (String) json.get("reason");
                System.out.println("ERROR: " + reason);
                
            } else {
            String name = (String) json.get("name");
            String realm = (String) json.get("realm");

            System.out.println("JSON - Name: " + name);
            System.out.println("JSON - Realm: " + realm);
            
            Realm tmpRealm = new Realm();
            tmpRealm.setRealmName(realm);
            System.out.println("OBJEKT - Name: " + tmpRealm.getRealmName());
            }
            
        } catch (Exception ex) {
            
        } 
    }
}