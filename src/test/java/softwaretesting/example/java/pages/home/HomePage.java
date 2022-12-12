package softwaretesting.example.java.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softwaretesting.example.java.pages.BasePage;
import softwaretesting.example.java.pages.home.restaurants.RestaurantsChooseRestPage;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Home page:
  WebElement btnRestaurants = keyword.findElement(By.xpath("//*[contains(text(),'Restaurants')]"));
  WebElement imgLogo = keyword.findElement(By.xpath("//*[@alt='Footer logo']"));
  
  // Define Actions:
  public RestaurantsChooseRestPage clickBtnRestaurants() {
    keyword.click(btnRestaurants);
    return new RestaurantsChooseRestPage(driver);
  }

  public void clickLogo() {
    keyword.click(imgLogo);
  }
}
