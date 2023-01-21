package javatpoint.jsonexample.jsonexample;

//import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
//import org.json.simple.JSONParser;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

public class ReadJSONExample {
    public static void main(String args[]) {
        JSONParser jsonP = new JSONParser();
        try {
            Reader fr = new FileReader("person.json");
            JSONObject jsonO = (JSONObject) jsonP.parse(fr);

            String name = (String) jsonO.get("name");
            String age = (String) jsonO.get("age");
            String address = (String) jsonO.get("address");
            System.out.println("Name :"+ name);
            System.out.println("Age: "+ age);
            System.out.println("Address: "+ address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}