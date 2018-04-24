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
 * @author A. Hofmann
 * @author B.-A. Mokroß
 */
public class Main {
        public static void main(String[] args) {
            
            JsonReader jr = new JsonReader();
            jr.readJson(JsonReader.jsonGetRequest("https://eu.api.battle.net/wow/character/Kult%20der%20Verdammten/Hototo?locale=de_DE&apikey=6cb9jp2e8zapv6u66v5zghahr5mhgb9d"));
            
            
            
        }
}
