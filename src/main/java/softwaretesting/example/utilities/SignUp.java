package softwaretesting.example.utilities;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.bytebuddy.utility.RandomString;

public class SignUp {
    private String username;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String password;
    private String confirmPwd;
    private String address;

    public SignUp() {
        this.username = "";
        this.lastName = "";
        this.firstName = "";
        this.phone = "";
        this.email = "";
        this.password = "";
        this.confirmPwd = "";
        this.address = "";
    }

    public SignUp(String username, String lastName, String firstName, String phone, String email, String password,
            String confirmPwd, String address) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.confirmPwd = confirmPwd;
        this.address = address;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPwd() {
        return confirmPwd;
    }
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public static SignUp randomObject() {
        SignUp newSignUp = new SignUp();
        newSignUp.setUsername(RandomStringUtils.random(8, true, true));
        newSignUp.setFirstName(RandomStringUtils.random(8, true, false));
        newSignUp.setLastName(RandomStringUtils.random(8, true, false));
        newSignUp.setEmail(RandomStringUtils.random(10, true, true) + "@gmail.com");
        newSignUp.setPhone(RandomStringUtils.random(10, false, true));
        newSignUp.setPassword(RandomStringUtils.random(10, true, true));
        newSignUp.setConfirmPwd(newSignUp.getPassword());
        newSignUp.setAddress(RandomStringUtils.random(15, true, true));
        return newSignUp;
    }

    public static void genData(String filename) {
        JSONArray signUparr = new JSONArray();
        for (int i = 1; i <= 22; i++) {
            JSONObject jsonObject = new JSONObject();
            SignUp newSignUp;
            if (i == 10) {
                newSignUp = new SignUp();
            } else {
                newSignUp = randomObject();
                switch (i) {
                    case 1:
                        newSignUp.setUsername("");
                        break;
                    case 2:
                        newSignUp.setFirstName("");
                        break;
                    case 3:
                        newSignUp.setLastName("");
                        break;
                    case 4:
                        newSignUp.setEmail("");
                        break;
                    case 5:
                        newSignUp.setPhone("");
                        break;
                    case 6:
                        newSignUp.setPassword("");
                        break;
                    case 7:
                        newSignUp.setConfirmPwd("");
                        break;
                    case 8: 
                        newSignUp.setAddress("");
                        break;
                    case 11:
                        newSignUp.setPhone(RandomStringUtils.random(9, false, true));
                        break;
                    case 12:
                        newSignUp.setPhone(RandomStringUtils.random(12, false, true));
                        break;
                    case 13:
                        newSignUp.setFirstName(RandomStringUtils.random(8, true, true));
                        break;
                    case 14:
                        newSignUp.setLastName(RandomStringUtils.random(8, true, true));
                        break;
                    case 15:
                        newSignUp.setPhone(RandomStringUtils.random(10, true, true));
                        break;
                    case 16:
                        newSignUp.setEmail(RandomStringUtils.random(10, true, true) + "gmail.com");
                        break;
                    case 17:
                        newSignUp.setEmail("@gmail.com");
                        break;
                    case 18:
                        newSignUp.setEmail(RandomStringUtils.random(10, true, true) + "@");
                        break;
                    case 19:
                        newSignUp.setUsername("navjot789");
                        break;
                    case 20:
                        newSignUp.setEmail("ns949405@gmail.com");
                        break;
                    case 21:
                        newSignUp.setPhone("9041240385");
                        break;
                    case 22:
                        newSignUp.setConfirmPwd(RandomStringUtils.random(11, true, true));;
                        break;
                    default:
                        break;
                }
            }
            jsonObject.put("userName", newSignUp.getUsername());
            jsonObject.put("firstName", newSignUp.getFirstName());
            jsonObject.put("lastName", newSignUp.getLastName());
            jsonObject.put("email", newSignUp.getEmail());
            jsonObject.put("phone", newSignUp.getPhone());
            jsonObject.put("password", newSignUp.getPassword());
            jsonObject.put("confirmPassword", newSignUp.getConfirmPwd());
            jsonObject.put("address", newSignUp.getAddress());
            signUparr.add(jsonObject);
        }
        JSONObject obj = new JSONObject();
        obj.put("signUp", signUparr);
        try {
            FileWriter file = new FileWriter(filename);
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
