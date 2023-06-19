package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Helper;

public class OrderSuccessPage {
	Helper helper;

	public OrderSuccessPage(WebDriver driver) {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
		helper = new Helper(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Thank you')]")
	WebElement order_successText;

	@FindBy(xpath = "//div[@class='checkout-success']/p/span")
	WebElement order_id;

	public String orderSuccessTextIsDisplayed() {
		helper.waitForVisibilityOfElement(order_successText);
		if (order_successText.isDisplayed()) {
			return order_successText.getText();
		} else
			return null;

	}
	
}
