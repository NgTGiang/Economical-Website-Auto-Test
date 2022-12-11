package softwaretesting.example.java.test;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import softwaretesting.example.configuration.Configuration;
import softwaretesting.example.driver.DriverFactory;
import softwaretesting.example.java.pages.HomePage;
import softwaretesting.example.java.pages.SignupPage;
import softwaretesting.example.keyword.WebKeyWord;
import softwaretesting.example.utilities.ReadJson;
import softwaretesting.example.utilities.SignUp;

public class SignUpTest{
  private WebDriver driver;
  private WebKeyWord keyWord;
  private Configuration config;
  private ReadJson readJson;

  public void setup() throws Exception {
    this.config = new Configuration("src/test/java/softwaretesting/example/resources/config.properties");
    this.driver = DriverFactory.getDriver(config.getProperty("browser"));
    this.keyWord = new WebKeyWord(driver);
    keyWord.openUrl(config.getProperty("homePageUrl"));
  }

  public void tearDown() {
    this.driver.quit();
  }

  @Test
  public void SignUpAccount() throws Exception {
    setup();
    HomePage homePage = new HomePage(driver);
    homePage.clickBtnSignUp();
    ArrayList<SignUp> signUpList = ReadJson.readJsonForSignUp();
    for (int i = 0; i < signUpList.size(); i++) {
      SignupPage signupPage = new SignupPage(driver);
      signupPage.typeTextIntoTextBox(signupPage.getUserNameElement(), signUpList.get(i).getUsername());
      signupPage.typeTextIntoTextBox(signupPage.getFirstNameElement(), signUpList.get(i).getFirstName());
      signupPage.typeTextIntoTextBox(signupPage.getLastNameElement(), signUpList.get(i).getLastName());
      signupPage.typeTextIntoTextBox(signupPage.getEmailAddressElement(), signUpList.get(i).getEmail());
      signupPage.typeTextIntoTextBox(signupPage.getPhoneElement(), signUpList.get(i).getPhone());
      signupPage.typeTextIntoTextBox(signupPage.getPasswordElement(), signUpList.get(i).getPassword());
      signupPage.typeTextIntoTextBox(signupPage.getRepeatPasswordElement(), signUpList.get(i).getConfirmPwd());
      signupPage.typeTextIntoTextBox(signupPage.getDeliveryAddressElement(), signUpList.get(i).getAddress());
      signupPage.clickButtonElement(signupPage.getRegisterElement());
  
      // String expectedResult = keyWord.getAttribute(signupPage.getMssAlert(), "innerHTML");
      // Assert.assertTrue(expectedResult != "username Already exists!" && expectedResult != "All fields must be Required!", "Username Already exists or all fields are not filled out!");
  
      // Thread.sleep(3000);
    }
    tearDown();
    
  }
}
