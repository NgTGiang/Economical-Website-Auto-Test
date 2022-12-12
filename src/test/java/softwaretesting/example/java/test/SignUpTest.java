package softwaretesting.example.java.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import softwaretesting.example.configuration.Configuration;
import softwaretesting.example.driver.DriverFactory;
import softwaretesting.example.java.pages.home.HomePage;
import softwaretesting.example.java.pages.home.HomePageNoLoginAccount;
import softwaretesting.example.java.pages.home.signup.SignupPage;
import softwaretesting.example.keyword.WebKeyWord;
import softwaretesting.example.utilities.ReadJson;

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
    HomePageNoLoginAccount homePage = new HomePageNoLoginAccount(driver);
    homePage.clickBtnSignUp();
    SignupPage signupPage = new SignupPage(driver);
    signupPage.typeTextIntoTextBox(signupPage.getUserNameElement(),readJson.readJson("userName"));
    signupPage.typeTextIntoTextBox(signupPage.getFirstNameElement(),readJson.readJson("firstName"));
    signupPage.typeTextIntoTextBox(signupPage.getLastNameElement(),readJson.readJson("lastName"));
    signupPage.typeTextIntoTextBox(signupPage.getEmailAddressElement(),readJson.readJson("email"));
    signupPage.typeTextIntoTextBox(signupPage.getPhoneElement(),readJson.readJson("phone"));
    signupPage.typeTextIntoTextBox(signupPage.getPasswordElement(),readJson.readJson("password"));
    signupPage.typeTextIntoTextBox(signupPage.getRepeatPasswordElement(),readJson.readJson("confirmPassword"));
    signupPage.typeTextIntoTextBox(signupPage.getDeliveryAddressElement(),readJson.readJson("address"));
    signupPage.clickButtonElement(signupPage.getRegisterElement());

    // String expectedResult = keyWord.getAttribute(signupPage.getMssAlert(), "innerText");
    // Assert.assertTrue(expectedResult != "ABC");

    Thread.sleep(5000);
    tearDown();
  }
}
