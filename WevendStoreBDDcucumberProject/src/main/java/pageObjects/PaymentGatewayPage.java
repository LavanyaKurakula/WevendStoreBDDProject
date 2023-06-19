package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Helper;

public class PaymentGatewayPage {

	Helper helper;

	public PaymentGatewayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}

	@FindBy(id = "cardNum")
	WebElement cardNumber;

	@FindBy(id = "validTill")
	WebElement card_expiryDate;

	@FindBy(id = "cvv")
	WebElement card_cvv;

	@FindBy(xpath = "//button[contains(text(),'Pay $')]")
	WebElement payButn;

	public void enter_CardNum(String cardNum) {
		helper.waitForVisibilityOfElement(cardNumber);
		cardNumber.sendKeys(cardNum);
	}

	public void enter_CardExpiryDate(String string) {
		helper.waitForVisibilityOfElement(card_expiryDate);
		card_expiryDate.sendKeys(string);
	}

	public void enter_CardCvv(String string) {
		helper.waitForVisibilityOfElement(card_cvv);
		card_cvv.sendKeys(string);
	}

	public void clickOnPayButn() {
		helper.waitForElementToBeClickable(payButn);
		payButn.click();
	}
}
