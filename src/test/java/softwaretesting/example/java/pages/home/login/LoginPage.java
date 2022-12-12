package softwaretesting.example.java.pages.home.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softwaretesting.example.java.pages.BasePage;

public class LoginPage extends BasePage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Login Page:
  WebElement txtTitle = keyword.findElement(By.xpath("//*[contains(text(),'Login Form')]"));
  WebElement txtUserName = keyword.findElement(By.xpath("//*[@name='username']"));
  WebElement txtPassword = keyword.findElement(By.xpath("//*[@name='password']"));
  WebElement btnLogin = keyword.findElement(By.xpath("//*[@name='submit']"));

  // Define Actions:
  public void enterUserName(String userName) {
    keyword.setText(txtUserName, userName);
  }

  public void enterPassword(String passWord) {
    keyword.setText(txtPassword, passWord);
  }

  public void clickBtnLogin() {
    keyword.click(btnLogin);
  }

  // Get attributes:
  public WebElement getTxtTitle() {
    return this.txtTitle;
  }
  public WebElement getTxtUserName() {
    return this.txtUserName;
  }
  public WebElement getTxtPassword() {
    return this.txtPassword;
  }
}
