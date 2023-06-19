package StepDefs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utility.Helper;

public class OrderStepDef extends BaseClass {
	Helper helper;
	TestContext testContext;

	
	public OrderStepDef(TestContext context) throws IOException {
		testContext = context;
		driver = testContext.getWebDriverManagerSetup().getDriver();
		homePg = testContext.getPageObjectManager().getHomePageObj();
		checkoutPg = testContext.getPageObjectManager().getReviewAndPaymentsPageObj();
		paySelectPg = testContext.getPageObjectManager().getPayMethodSelectionPageObj();
		paymentGatewayPg = testContext.getPageObjectManager().getPaymentGatewayPage();
          orderSuccessPg=  testContext.getPageObjectManager().getOrderSuccessPage();
		helper = new Helper(driver);
		
	}
	@Given("Open url {string}")
	public void Open_the_url(String expected_url) throws InterruptedException, ClassNotFoundException {
		
		test=extent.createTest("Test3");
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

	@When("User navigates to the BuyNow button under any product and click on it {string}")
	public void user_navigate_to_the_buy_now_button_under_any_product_and_click_on_it(String product1){
		homePg.clickOnBuyNow(product1);
		System.out.println("Clicked on BuyNow button for product " + product1);
	    test.log(Status.PASS, "Clicked on BuyNow button for product" + product1);
	}
	
	@When("User should be redirected to url {string}")
	public void user_should_be_redirected_to(String expected_url) {
		//----Asserting URL---//
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
		test.log(Status.PASS, "expected url matches with the current url");
		
	}
	
	@When("User clicks on proceed button")
	public void user_clicks_on_proceed_button() {
		test=extent.createTest("Test3");
		// Asserting Proceed button
		boolean result1 = checkoutPg.ProceedIsEnabled();
		Assert.assertEquals(result1, true);
		System.out.println("Proceed button is enabled");
		test.log(Status.PASS, "Proceed button is enabled");
		checkoutPg.clickOnProceed();
	}

	@When("User selects card payment method and navigates to {string}")
	public void user_selects_card_payment_method_and_navigates_to(String expected_url) throws InterruptedException {
		String expected_title="weVend Pay";
		// Asserting title
				helper.waitForTitle(expected_title);
				String title = driver.getTitle();
				Assert.assertEquals(title, expected_title);
		paySelectPg.clickOnCardPayButn();
		test.log(Status.PASS, "Clicked on Card Pay option");
		// Asserting url
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);

	}
	@When("User enters card details [ {string}, {string},  {string} ]")
	public void user_enters_card_details(String cardNum, String date, String cvv) {
		paymentGatewayPg.enter_CardNum(cardNum);
		paymentGatewayPg.enter_CardExpiryDate(date);
		paymentGatewayPg.enter_CardCvv(cvv);
		test.log(Status.PASS, "Entering card details");
	}
	
	@When("User clicks on Pay button")
	public void user_clicks_on_pay_button() {
		paymentGatewayPg.clickOnPayButn();
		test.log(Status.PASS, "Clicked on Pay button");
	}

	@Then("Order should be placed and user will be navigated to {string}")
	public void order_should_be_placed_and_user_will_be_navigated_to(String expected_url) {
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
	orderSuccessPg.orderSuccessTextIsDisplayed();
	test.log(Status.PASS, "Order is placed");
	
	}
}
