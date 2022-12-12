package softwaretesting.example.java.pages.home.restaurants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softwaretesting.example.java.pages.BasePage;

public class RestaurantsChooseRestPage extends BasePage{

  public RestaurantsChooseRestPage(WebDriver driver) {
    super(driver);
  }

  // Define Elements on Restaurants page:
  // WebElement dlgRestaurants = keyword.findElement(By.xpath("//*[contains(text(),'Hari Burger')]"));
  WebElement dlgRestaurants;
  

  // Define actions:
  public RestaurantsPickFoodsPage clickRestaurants() {
    keyword.click(dlgRestaurants);
    return new RestaurantsPickFoodsPage(driver);
  }

  public WebElement setDlgRestaurants(String restaurantName) {
    String xpath = "//*[contains(text(),'" + restaurantName +"')]";
    System.out.println(xpath);
    return dlgRestaurants = keyword.findElement(By.xpath(xpath));
  }
}