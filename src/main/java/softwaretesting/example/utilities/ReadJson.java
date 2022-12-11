package softwaretesting.example.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.sym.Name;

public class ReadJson {

    // public static void main(String[] args) {
    //   readJson("firstName");
    // }
 
    public static String readJson(String attribute) {
      JSONParser parser = new JSONParser();
      String name = "";
      try {
         Object obj = parser.parse(new FileReader("src/test/java/softwaretesting/example/java/testdata/data.json"));
         JSONObject jsonObject = (JSONObject)obj;
         JSONObject signUpObj = (JSONObject)jsonObject.get("signUp");
         name = (String)signUpObj.get(attribute);
         System.out.println("Name: " + name);
      } catch(Exception e) {
         e.printStackTrace();
      }
      return name;
    } 
}
