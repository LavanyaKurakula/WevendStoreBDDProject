package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Helper;

public class ReviewAndPaymentsPage {
	Helper helper;

	public ReviewAndPaymentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}

	@FindBy(xpath = "//button/span[text()='Proceed']")
	private WebElement proceedButton;

	@FindBy(xpath = "//label/span[text()='weVend Pay']")
	private WebElement wevendPayText;

	@FindBy(xpath = "//div[@data-block='minicart']/descendant::span[@class='counter-number']")
	private WebElement cartItemsCount;

	public void getCartItemsCount() {
		helper.waitForVisibilityOfElement(cartItemsCount);
		cartItemsCount.getText();
	}

	public void clickOnProceed() {
		helper.waitForElementToBeClickable(proceedButton);
		proceedButton.click();
	}

	public boolean ProceedIsEnabled() {
		helper.waitForElementToBeClickable(proceedButton);
		return proceedButton.isEnabled();
	}

	public String wevendPayTextIsDisplayed() {
		helper.waitForVisibilityOfElement(wevendPayText);
		if (wevendPayText.isDisplayed()) {
			return wevendPayText.getText();
		} else
			return null;

	}
}
