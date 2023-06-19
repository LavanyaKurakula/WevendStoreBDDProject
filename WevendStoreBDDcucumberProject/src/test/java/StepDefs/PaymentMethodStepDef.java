package StepDefs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Helper;

public class PaymentMethodStepDef extends BaseClass {
	int addToCart_ItemsList;
	int buyNow_ItemsList;
	Helper helper;
	TestContext testContext;
	public PaymentMethodStepDef(TestContext context) throws IOException {
		testContext = context;
		
		driver = testContext.getWebDriverManagerSetup().getDriver();
		homePg = testContext.getPageObjectManager().getHomePageObj();
		checkoutPg = testContext.getPageObjectManager().getReviewAndPaymentsPageObj();
		
		helper = new Helper(driver);
		
	}

	@Given("Open this url {string}")
	public void Open_the_url(String expected_url) throws InterruptedException, ClassNotFoundException {
		
		test=extent.createTest("Test1");
		test.log(Status.INFO, "Launching the App");
		driver.get(expected_url);
		System.out.println("Launching the App");

		//---Asserting URL---//
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
		test.log(Status.PASS, "Application launched sucessfullly ");
	}

	@When("User navigate to the BuyNow button under any product and click on it {string}")
	public void user_navigate_to_the_buy_now_button_under_any_product_and_click_on_it(String product1){
		homePg.clickOnBuyNow(product1);
		System.out.println("Clicked on BuyNow button for product " + product1);
	    test.log(Status.PASS, "Clicked on BuyNow button for product" + product1);
	}

	@When("User should be redirected to {string}")
	public void user_should_be_redirected_to(String expected_url) {
		//----Asserting URL---//
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
		test.log(Status.PASS, "expected url matches with the current url");
		
	}

	@Then("Payment method should be present on the page as {string}")
	public void payment_method_should_be_present_on_the_page_as(String wevendtext) {
		//----Asserting wevendPay Text----//
		String result2 = checkoutPg.wevendPayTextIsDisplayed();
		Assert.assertEquals(result2, wevendtext);
		System.out.println("wevend pay text is displayed under payment Method");
		test.log(Status.PASS, "wevend pay text is displayed under payment Method");
	}

	

}
