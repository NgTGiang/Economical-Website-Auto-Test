package softwaretesting.example.utilities;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {

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
