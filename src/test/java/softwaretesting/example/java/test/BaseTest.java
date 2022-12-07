package softwaretesting.example.java.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import softwaretesting.example.configuration.Configuration;
import softwaretesting.example.driver.DriverFactory;
import softwaretesting.example.keyword.WebKeyWord;

public class BaseTest {
  public WebDriver driver;
  public WebKeyWord keyword;
  public Configuration config;
   
	@BeforeMethod
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();
    this.config = new Configuration("src/test/java/softwaretesting/example/resources/config.properties");
    this.driver = DriverFactory.getDriver(config.getProperty("browser"));
    this.keyword = new WebKeyWord(driver);
    keyword.openUrl(config.getProperty("url"));
  }

	@AfterMethod
  public void tearDown(){
    this.driver.quit();
  }
}
