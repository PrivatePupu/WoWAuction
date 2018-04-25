package de.h_da.fbi.db2.stud;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entities.Realm;
import Tools.JsonReader;

/**
 * Main Class.
 * @version 0.1.1
 * @since 0.1.0
 * @author M. Stolze
 */
public class Main {
        public static void main(String[] args) {
            
            String[] searchedPlayer = {"Hototo", "Lefthand"};
            String[] searchedRealm = {"Kult%20der%20Verdammten","Die%20Arguswacht"};
                  
            
            JsonReader jr = new JsonReader();
            for (int i= 0; i< searchedPlayer.length; i++) {
            jr.readJson(JsonReader.jsonGetRequest("https://eu.api.battle.net/wow/character/" + searchedRealm[i] + "/" + searchedPlayer[i] + "?locale=de_DE&apikey=6cb9jp2e8zapv6u66v5zghahr5mhgb9d"));
            
            }
            
            
        }
}
