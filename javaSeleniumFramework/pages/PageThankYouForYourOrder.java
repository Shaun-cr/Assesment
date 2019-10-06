package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Browser;
import utility.GeneralChecks;

public class PageThankYouForYourOrder {
	
	@FindBy(how = How.XPATH,using = "//h1[contains(.,'Thank you for your order!')]")
	private WebElement labelThankYouForYourOrder;
	
	@FindBy(how = How.XPATH,using = "//span[@class='order-purchaseid']")
	private WebElement labelOrderReference;
	
	@FindBy(how = How.XPATH,using = "//body")
	private WebElement webElementBody;

	public boolean isAt() {
		
		return GeneralChecks.isWebElementDisplayed(labelThankYouForYourOrder); 
	}

	public String getOrderReference() {
		webElementBody.sendKeys(Keys.END);
		Browser.ExplicitWait(labelOrderReference);
		String orderRefrence = labelOrderReference.getText();
		System.out.println("The Order Refrence = " + orderRefrence);
		return orderRefrence;
	}

}
