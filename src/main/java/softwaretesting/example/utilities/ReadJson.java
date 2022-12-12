package softwaretesting.example.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.sym.Name;

public class ReadJson {
   public static void main(String[] args) {
      JSONParser parser = new JSONParser();
      ArrayList<SignUp> signUpArr = new ArrayList<SignUp>();
      try {
         Object obj = parser.parse(new FileReader("src/test/java/softwaretesting/example/java/testdata/data.json"));
         JSONObject jsonObject = (JSONObject)obj;
         JSONArray jsonarr = (JSONArray) jsonObject.get("signUp");

         for (int i = 0; i < jsonarr.size(); i++) {
            JSONObject ob = (JSONObject)jsonarr.get(i);
            SignUp suEle = ReadJson.parseSignUpObject(ob);
            signUpArr.add(suEle);
            System.out.println(signUpArr.get(i).getUsername());
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
   }

   public static ArrayList<SignUp> readJsonForSignUp(String fileName) {
      JSONParser parser = new JSONParser();
      ArrayList<SignUp> signUpArr = new ArrayList<SignUp>();
      try {
         Object obj = parser.parse(new FileReader(fileName));
         JSONObject jsonObject = (JSONObject)obj;
         JSONArray jsonarr = (JSONArray) jsonObject.get("signUp");

         for (int i = 0; i < jsonarr.size(); i++) {
            JSONObject ob = (JSONObject)jsonarr.get(i);
            SignUp suEle = ReadJson.parseSignUpObject(ob);
            signUpArr.add(suEle);
         }
         
      } catch(Exception e) {
         e.printStackTrace();
      }
      return signUpArr;
   } 

   public static SignUp parseSignUpObject(JSONObject object) {
      SignUp su = new SignUp();
      su.setUsername((String)object.get("userName"));
      su.setFirstName((String)object.get("firstName"));
      su.setLastName((String)object.get("lastName"));
      su.setEmail((String)object.get("email"));
      su.setPhone((String)object.get("phone"));
      su.setPassword((String)object.get("password"));
      su.setConfirmPwd((String)object.get("confirmPassword"));
      su.setAddress((String)object.get("address"));
      return su;
   }
}
