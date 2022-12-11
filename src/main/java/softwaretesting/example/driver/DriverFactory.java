package softwaretesting.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
  public static WebDriver getDriver(String browser) {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addArguments("start-maximized");
			chromeOption.addArguments("--incognito");
			return new ChromeDriver(chromeOption);
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOption = new EdgeOptions();
			edgeOption.addArguments("start-maximized");
			edgeOption.addArguments("--incognito");
			return new EdgeDriver(edgeOption);
			
		default:
			return new ChromeDriver();
		}
	}
}
