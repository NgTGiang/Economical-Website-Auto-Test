package softwaretesting.example.java.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import softwaretesting.example.configuration.Configuration;
import softwaretesting.example.driver.DriverFactory;
import softwaretesting.example.java.pages.HomePage;
import softwaretesting.example.java.pages.SignupPage;
import softwaretesting.example.keyword.WebKeyWord;
import softwaretesting.example.utilities.Util;

public class SignUpTest{
  private WebDriver driver;
  private WebKeyWord keyWord;
  private Configuration config;
  private Util utilities;

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
    SignupPage signupPage = new SignupPage(driver);
    signupPage.typeTextIntoTextBox(signupPage.getUserNameElement(),"");
    signupPage.typeTextIntoTextBox(signupPage.getFirstNameElement(),"Ngo");
    signupPage.typeTextIntoTextBox(signupPage.getLastNameElement(),"Hiep");
    signupPage.typeTextIntoTextBox(signupPage.getEmailAddressElement(),"Hiep12z@gmail.com");
    signupPage.typeTextIntoTextBox(signupPage.getPhoneElement(),"0937705040");
    signupPage.typeTextIntoTextBox(signupPage.getPasswordElement(),"0937705040");
    signupPage.typeTextIntoTextBox(signupPage.getRepeatPasswordElement(),"0937705040");
    signupPage.typeTextIntoTextBox(signupPage.getDeliveryAddressElement(),"218 Lac Long Quan");
    signupPage.clickButtonElement(signupPage.getRegisterElement());

    // String expectedResult = keyWord.getAttribute(signupPage.getMssAlert(), "innerHTML");
    // Assert.assertTrue(expectedResult != "username Already exists!" && expectedResult != "All fields must be Required!", "Username Already exists or all fields are not filled out!");

    Thread.sleep(5000);
    tearDown();
  }
}
