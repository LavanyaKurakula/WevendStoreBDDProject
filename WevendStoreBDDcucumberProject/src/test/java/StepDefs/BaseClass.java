package StepDefs;
import org.openqa.selenium.WebDriver;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.ReviewAndPaymentsPage;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePg;
	public ReviewAndPaymentsPage checkoutPg;
	public PageObjectManager pageObjectManager;
}
