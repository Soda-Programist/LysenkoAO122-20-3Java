package edu.ntudp.fit;

import com.google.gson.Gson;
import edu.ntudp.fit.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    public static void Save(University university){
        Gson gson = new Gson();
        try {
            String json = gson.toJson(university);
            FileWriter writer = new FileWriter("myObject.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University Load(){
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("myObject.json");
            var university = gson.fromJson(reader, University.class);
            reader.close();
            return university;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
