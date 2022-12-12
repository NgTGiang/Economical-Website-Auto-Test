package softwaretesting.example.java.pages.home.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softwaretesting.example.java.pages.BasePage;

public class SignupPage extends BasePage{

  public SignupPage(WebDriver driver) {
    super(driver);
  }
  
  // Define Elements on Sign up page:
  WebElement txtUserName = keyword.findElement(By.xpath("//*[@name='username']"));
  WebElement txtFirstName = keyword.findElement(By.xpath("//*[@name='firstname']"));
  WebElement txtLastName = keyword.findElement(By.xpath("//*[@name='lastname']"));
  WebElement txtEmailAddress = keyword.findElement(By.xpath("//*[@name='email']"));
  WebElement txtPhone = keyword.findElement(By.xpath("//*[@name='phone']"));
  WebElement txtPassword = keyword.findElement(By.xpath("//*[@name='password']"));
  WebElement txtRepeatPassword = keyword.findElement(By.xpath("//*[@name='cpassword']"));
  WebElement txtDeliveryAddress = keyword.findElement(By.xpath("//*[@name='address']"));
  WebElement btnRegister = keyword.findElement(By.xpath("//*[@name='submit']"));
  WebElement mssAlert = keyword.findElement(By.xpath("//*[@class='active']"));

  // Define actions:
  public void typeTextIntoTextBox(WebElement element, String text) {
    keyword.setText(element, text);
  }
  public void clickButtonElement(WebElement element) {
    keyword.click(element);
  }

  // Get attributes:
  public WebElement getUserNameElement() {
    return this.txtUserName;
  }
  public WebElement getFirstNameElement() {
    return this.txtFirstName;
  }
  public WebElement getLastNameElement() {
    return this.txtLastName;
  }
  public WebElement getEmailAddressElement() {
    return this.txtEmailAddress;
  }
  public WebElement getPhoneElement() {
    return this.txtPhone;
  }
  public WebElement getPasswordElement() {
    return this.txtPassword;
  }
  public WebElement getRepeatPasswordElement() {
    return this.txtRepeatPassword;
  }
  public WebElement getDeliveryAddressElement() {
    return this.txtDeliveryAddress;
  }
  public WebElement getRegisterElement() {
    return this.btnRegister;
  }
  public WebElement getMssAlert() {
    return this.mssAlert;
  }
}
