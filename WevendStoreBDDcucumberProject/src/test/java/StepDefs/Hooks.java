package StepDefs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.Level;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.testng.log4testng.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
		
	}

	@Before 
	public void setUp() throws IOException {
		extent = new ExtentReports();
		 spark = new ExtentSparkReporter("Spark.html");
		 extent.attachReporter(spark);
		 
		driver = testContext.getWebDriverManagerSetup().getDriver();
		driver.manage().window().maximize();
		
	}
	
	@After(order=1)
	public void end(Scenario sc) throws IOException {
		if (sc.isFailed() == true) {

			TakesScreenshot scrShot = (TakesScreenshot) driver;
			byte[] data = scrShot.getScreenshotAs(OutputType.BYTES);
			sc.attach(data, "image/png", "failedscreenshot");

//				String FilePath="D:\\Test1\\BDDcucumberProject\\Screenshot\\failedscrshot.png";
//				File srcFile= scrShot.getScreenshotAs(OutputType.FILE);
//				File destFile= new File(FilePath);
//				FileUtils.copyFile(srcFile, destFile);
			
		}
	}

	@After(order = 2)	
	public void quitDriver() {
		extent.flush();
		driver.quit();
	}
}
