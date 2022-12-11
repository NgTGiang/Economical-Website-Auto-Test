package softwaretesting.example.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Home page:
  WebElement btnSignUp = keyword.findElement(By.xpath("//*[contains(text(),'signup')]"));

  // Define Actions:
  public SignupPage clickBtnSignUp() {
    keyword.click(btnSignUp);
    return new SignupPage(driver);
  }
}
