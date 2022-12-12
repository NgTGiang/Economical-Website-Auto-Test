package softwaretesting.example.java.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import softwaretesting.example.configuration.Configuration;
import softwaretesting.example.driver.DriverFactory;
import softwaretesting.example.java.pages.home.HomePage;
import softwaretesting.example.java.pages.home.HomePageNoLoginAccount;
import softwaretesting.example.java.pages.home.HomePageWithLoginAccount;
import softwaretesting.example.java.pages.home.login.LoginPage;
import softwaretesting.example.java.pages.home.restaurants.RestaurantsChooseRestPage;
import softwaretesting.example.java.pages.home.restaurants.RestaurantsPickFoodsPage;
import softwaretesting.example.keyword.WebKeyWord;

public class CheckoutTest {
  private WebDriver driver;
  private WebKeyWord keyWord;
  private Configuration config;
  
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
  public void checkoutWithNoLogin() throws Exception {
    setup();
    HomePage homePage = new HomePage(driver);
    RestaurantsChooseRestPage chooseRestaurant = homePage.clickBtnRestaurants();
    chooseRestaurant.setDlgRestaurants("Hari Burger");
    RestaurantsPickFoodsPage pickFood = chooseRestaurant.clickRestaurants();
    pickFood.enterQuantity("2");
    pickFood.clickBtnAddToCart();
    pickFood.clickBtnCheckout();
    LoginPage loginPage = new LoginPage(driver);
    Assert.assertTrue(keyWord.checkElementIsDisplayed(loginPage.getTxtTitle()));
    tearDown();
  }

  @Test
  public void checkoutWithLogin() throws Exception {
    setup();

    HomePageNoLoginAccount homePage = new HomePageNoLoginAccount(driver);
    LoginPage login = homePage.clickBtnLogin();
    login.enterUserName("giangtnguyen");
    login.enterPassword("1234567");
    login.clickBtnLogin();
    Thread.sleep(5000);
    HomePageWithLoginAccount homePageAfterLogin = new HomePageWithLoginAccount(driver);
    RestaurantsChooseRestPage chooseRestaurant = homePageAfterLogin.clickBtnRestaurants();
    chooseRestaurant.setDlgRestaurants("Hari Burger");
    RestaurantsPickFoodsPage pickFood = chooseRestaurant.clickRestaurants();
    pickFood.enterQuantity("2");
    pickFood.clickBtnAddToCart();
    pickFood.clickBtnCheckout();
    Thread.sleep(3000);
    tearDown();
  }
}
