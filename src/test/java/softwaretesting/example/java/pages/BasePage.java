package softwaretesting.example.java.pages;

import org.openqa.selenium.WebDriver;

import softwaretesting.example.keyword.WebKeyWord;

public class BasePage {
  public WebDriver driver;
  public WebKeyWord keyword;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.keyword = new WebKeyWord(driver);
  }
}
