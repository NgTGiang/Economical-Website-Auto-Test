package softwaretesting.example.keyword;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebKeyWord {
  private WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 10;

    public WebKeyWord(WebDriver driver){
      this.driver = driver;
      this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
    }
    
    public void openUrl(String url) throws Exception {
      if(!(url.startsWith("http://") || url.startsWith("https://"))){
        throw new Exception("Invalid URL format");
      }
      driver.get(url);
    }

    public void navigate(String url) throws Exception {
      if(!(url.startsWith("http://") || url.startsWith("https://"))){
        throw new Exception("Invalid URL format");
      }
      driver.navigate().to(url);
    }
    
    public WebElement findElement(By locator){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setText(WebElement elem, String text){
      try{
        Actions actions = new Actions(this.driver);
        actions.scrollToElement(elem).build().perform();
        elem.clear();
        elem.sendKeys(text);
      }
      catch (WebDriverException e){
        throw new WebDriverException("Element is not enable to set text");
      }
    }

    public  void click(WebElement elem){
      Actions actions = new Actions(this.driver);
      actions.scrollToElement(elem).build().perform();
      elem.click();
    }

    public void select(WebElement element, SelectType type, String options) throws Exception {
      Select select = new Select(element);
      
      switch (type){
      case SELECT_BY_INDEX:
        try{
          select.selectByIndex(Integer.parseInt(options));
        }catch (Exception e){
          throw new Exception("Please input numeric on selectOption for SelectType.SelectByIndex");
        }
        break;
          
      case SELECT_BY_TEXT:
        select.selectByVisibleText(options);
        break;
          
      case SELECT_BY_VALUE:
        select.selectByValue(options);
        break;
          
      default:
        throw new Exception("Get error in using Selected");
      }
    }

    public String getAttribute( WebElement element, String attribute) {
      wait.until(ExpectedConditions.invisibilityOf(element));
      System.out.println("Attribute of element" + element.getAttribute(attribute));
      return element.getAttribute(attribute);
    }
}
