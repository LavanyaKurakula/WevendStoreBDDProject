package StepDefs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.OrderSuccessPage;
import pageObjects.PayMethodSelectionPage;
import pageObjects.PaymentGatewayPage;
import pageObjects.ReviewAndPaymentsPage;
import utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePg;
	public ReviewAndPaymentsPage checkoutPg;
	public PayMethodSelectionPage paySelectPg;
	public PaymentGatewayPage paymentGatewayPg;
	public OrderSuccessPage orderSuccessPg;
	public PageObjectManager pageObjectManager;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ExtentSparkReporter spark;

	
}
