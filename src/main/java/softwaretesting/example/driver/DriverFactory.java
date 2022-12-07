package softwaretesting.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
  public static WebDriver getDriver(String browser) {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			option.addArguments("--incognito");
			return new ChromeDriver(option);
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
			
		default:
			return new ChromeDriver();
		}
	}
}
