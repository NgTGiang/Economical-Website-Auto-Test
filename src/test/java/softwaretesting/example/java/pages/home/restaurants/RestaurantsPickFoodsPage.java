package softwaretesting.example.java.pages.home.restaurants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantsPickFoodsPage extends RestaurantsChooseRestPage{

  public RestaurantsPickFoodsPage(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Restaurants page:
  WebElement txtQuantity = keyword.findElement(By.xpath("//*[@id='popular2']/div[@class='food-item'][1]//*[@name='quantity']"));
  WebElement btnAddToCart = keyword.findElement(By.xpath("//*[@id='popular2']/div[@class='food-item'][1]//*[@class='btn theme-btn']"));
  WebElement btnCheckout = keyword.findElement(By.xpath("//*[contains(text(),'Checkout')]"));

  // Define Actions:
  public void enterQuantity(String number) {
    keyword.setText(txtQuantity, number);
  }
  public void clickBtnAddToCart() {
    keyword.click(btnAddToCart);
  }

  public void clickBtnCheckout() {
    keyword.click(btnCheckout);
  }
}
