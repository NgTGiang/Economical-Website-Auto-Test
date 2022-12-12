package softwaretesting.example.java.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softwaretesting.example.java.pages.home.login.LoginPage;
import softwaretesting.example.java.pages.home.signup.SignupPage;

public class HomePageNoLoginAccount extends HomePage{

  public HomePageNoLoginAccount(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Home page:
  WebElement btnSignUp =  keyword.findElement(By.xpath("//*[contains(text(),'signup')]"));
  WebElement btnLogin = keyword.findElement(By.xpath("//*[contains(text(),'login')]"));

  // Define Actions:
  public SignupPage clickBtnSignUp() {
    keyword.click(btnSignUp);
    return new SignupPage(driver);
  }

  public LoginPage clickBtnLogin() {
    keyword.click(btnLogin);
    return new LoginPage(driver);
  }
}
