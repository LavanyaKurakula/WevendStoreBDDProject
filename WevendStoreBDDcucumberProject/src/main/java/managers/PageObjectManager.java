package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

	private WebDriver driver;

	private HomePage homePageObj;

	private ReviewAndPaymentsPage reviewAndPaymentsPageObj;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePage getHomePageObj() {

		return (homePageObj == null) ? homePageObj = new HomePage(driver) : homePageObj;

	}

	public ReviewAndPaymentsPage getReviewAndPaymentsPageObj() {

		return (reviewAndPaymentsPageObj == null) ? reviewAndPaymentsPageObj = new ReviewAndPaymentsPage(driver)
				: reviewAndPaymentsPageObj;

	}

}
