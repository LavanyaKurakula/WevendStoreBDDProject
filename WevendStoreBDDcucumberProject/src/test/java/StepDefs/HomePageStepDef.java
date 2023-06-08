package StepDefs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Helper;

public class HomePageStepDef extends BaseClass {
	int addToCart_ItemsList;
	int buyNow_ItemsList;
	Helper helper;
	TestContext testContext;

	public HomePageStepDef(TestContext context) throws IOException {
		testContext = context;
		driver = testContext.getWebDriverManagerSetup().getDriver();
		homePg = testContext.getPageObjectManager().getHomePageObj();
		checkoutPg = testContext.getPageObjectManager().getReviewAndPaymentsPageObj();
		helper = new Helper(driver);
	}

	@Given("Open the url {string}")
	public void Open_the_url(String expected_url) throws InterruptedException, ClassNotFoundException {
		driver.get(expected_url);
		System.out.println("Launching the App");
		// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Launching the App");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				MarkupHelper.createLabel("Launching the App", ExtentColor.BLUE));

		// Asserting URL
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
		// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Launched the app
		// succesfully");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				MarkupHelper.createLabel("Launched the app succesfully", ExtentColor.BLUE));
	}

	@When("User navigate to the BuyNow button under any product and click on it {string}")
	public void user_navigate_to_the_buy_now_button_under_any_product_and_click_on_it(String product1)
			throws ClassNotFoundException {
		homePg.clickOnBuyNow(product1);
		System.out.println("Clicked on BuyNow button for product " + product1);
		// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Clicked on BuyNow
		// button for product");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				MarkupHelper.createLabel("Clicked on BuyNow button for product " + product1, ExtentColor.BLUE));
	}

	@When("User should be redirected to {string}")
	public void user_should_be_redirected_to(String expected_url) {
		// Asserting URL
		helper.waitForUrlToLoad(expected_url);
		String current_url = driver.getCurrentUrl();
		System.out.println("user is redirected to this url: " + current_url);
		// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "user is redirected
		// to the url"+current_url);
		assertEquals(current_url, expected_url);
		System.out.println("expected url " + expected_url + "matches with the current url " + current_url);
		// ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "User is redirected
		// to payment page");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel(
				"user is redirected to the payment page after clicking on BuyNow button ", ExtentColor.BLUE));

		/*
		 * // Asserting Proceed button boolean result1 = paymentPg.ProceedIsEnabled();
		 * Assert.assertEquals(result1, true);
		 * System.out.println("Proceed button is enabled");
		 * 
		 * // Assert that the cart item count int afterCount =
		 * homePg.getCartItemCount(); Assert.assertEquals(afterCount,1);
		 * System.out.println("Items in cart: "+ afterCount);
		 */
	}

	@Then("Payment method should be present on the page as {string}")
	public void payment_method_should_be_present_on_the_page_as(String wevendtext) {
		// Asserting wevendPay Text
		String result2 = checkoutPg.wevendPayTextIsDisplayed();
		Assert.assertEquals(result2, wevendtext);
		System.out.println("wevend pay text is displayed under payment Method");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				MarkupHelper.createLabel("wevend pay text is displayed under payment Method ", ExtentColor.BLUE));
	}

	@When("User navigate to the AddToCart button under any product and click on it [{string}, {string}, {string}]")
	public void user_navigate_to_the_add_to_cart_button_under_any_product_and_click_on_it(String product1,
			String product2, String product3) throws InterruptedException {
		// String[] products= {product1,product2,product3};
		List<String> products = Arrays.asList(product1, product2, product3);
		for (String product : products) {
			homePg.clickOnAddToCart(product);
			// ---- Assert success msg after adding item to cart----//
			String successmsg = homePg.get_AddToCart_Successmsg();
			String sub_successmsg = "You added";
			boolean result = successmsg.contains(sub_successmsg);
			Assert.assertTrue(result);
			System.out.println(product + "successfully added to the cart");
			// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Products
			// successfully added to the cart");
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
					MarkupHelper.createLabel(product + " successfully added to the cart", ExtentColor.BLUE));
		}
		// System.out.println("Adding Products: "+product1+" "+product2+" to the cart");
		addToCart_ItemsList = products.size();
	}

	@Then("^Product should be added to the cart$")
	public void product_should_be_added_to_the_cart() {
		// Assert that the cart item count
		int afterCount = homePg.getCartItemCount();

		Assert.assertEquals(afterCount, addToCart_ItemsList);
		System.out.println("No. of Items in the cart are: " + afterCount);
		// ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "items in cart
		// matches with expected count");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				MarkupHelper.createLabel("items in cart matches with expected count", ExtentColor.BLUE));
	}

}
