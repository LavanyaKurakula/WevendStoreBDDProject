package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import configfile.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerSetup {
	private WebDriver driver;

	public WebDriver getDriver() throws IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		ConfigFileReader configfile = new ConfigFileReader();

		if (configfile.getBrowser().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (driver == null)
				driver = new ChromeDriver(co);
			return driver;
		} else if (configfile.getBrowser().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (driver == null)
				driver = new FirefoxDriver();
			return driver;
		}
		return null;

	}
}