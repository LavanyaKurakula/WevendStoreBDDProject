package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Helper;

public class PayMethodSelectionPage {

	Helper helper;

	public PayMethodSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}

	@FindBy(xpath = "//b[text()='Card Pay']")
	WebElement cardPayButn;

	public void clickOnCardPayButn() {
		helper.waitForVisibilityOfElement(cardPayButn);
		cardPayButn.click();
	}
}
