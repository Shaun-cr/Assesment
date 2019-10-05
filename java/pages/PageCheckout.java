package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import utility.Browser;
import utility.GeneralChecks;

public class PageCheckout {
	@FindBy(how = How.XPATH,using = "//h1[contains(.,'Ready to eat?')]")
	private WebElement webElementHeading;
	
	@FindBy(how = How.XPATH,using = "//input[@id='iaddress']")
	private WebElement textboxAddress;
	
	@FindBy(how = How.XPATH,using = "//input[@id='ipostcode']")
	private WebElement textboxPostCode;
	
	@FindBy(how = How.XPATH,using = "//input[@id='itown']")
	private WebElement textboxCity;
	
	@FindBy(how = How.XPATH,using = "//input[@id='isurname']")
	private WebElement textboxName;
	
	@FindBy(how = How.XPATH,using = "//input[@id='iphonenumber']")
	private WebElement textboxPhoneNumber;
	
	@FindBy(how = How.XPATH,using = "//input[@id='iemail']")
	private WebElement textboxEmailAddress;
	
	@FindBy(how = How.XPATH,using = "//select[@id='ideliverytime']")
	private WebElement dropdownboxDeliveryTime;
	
	@FindBy(how = How.XPATH,using = "//select[@id='ipayswith']")
	private WebElement dropdownboxYouPayWith;
	
	@FindBy(how = How.XPATH,using = "//select[@id='ipayswith']//option[@class='pulldown']")
	private List<WebElement> webElementListAllPayswith;
	
	@FindBy(how = How.XPATH,using = "//span[@class='cart-sum-price']")
	private WebElement labelCartTotal;
	
	@FindBy(how = How.XPATH,using = "//body")
	private WebElement webElementBody;

	public boolean isAt() {
		
		return GeneralChecks.isWebElementDisplayed(webElementHeading); 
	}

	public void captureAddressDetails(String address, String postCode, String city) {
		
		textboxAddress.sendKeys(address);
		textboxPostCode.clear();
		textboxPostCode.sendKeys(postCode);
		textboxCity.sendKeys(city);
	}

	public void capturePersonalDetails(String name, String phoneNumber, String emailAddress) {
		
		textboxName.sendKeys(name);
		textboxPhoneNumber.sendKeys(phoneNumber);
		textboxEmailAddress.sendKeys(emailAddress);
	}

	public void selectDeliveryTime(String selectItem) {
		webElementBody.sendKeys(Keys.PAGE_DOWN);
		Select drop = new Select(dropdownboxDeliveryTime);
		drop.selectByVisibleText(selectItem);
		
	}

	public void selectPayAmountClosestToOrderPrice() {
		webElementBody.sendKeys(Keys.PAGE_DOWN);
		Select drop = new Select(dropdownboxYouPayWith);
		
		int payv = removeCurrencyAndDecimalsAndConvertToInt(labelCartTotal.getText().trim());
		int closestValue = 0;
		for (int i = 1; i < webElementListAllPayswith.size(); i++) {
			
    		int intPayAmount = removeCurrencyAndDecimalsAndConvertToInt(webElementListAllPayswith.get(i).getText());
    		
				  if (i==1) {
					  closestValue=Math.abs(intPayAmount-payv);
					  drop.selectByIndex(i);
				  }
				  else if (Math.abs(intPayAmount-payv)<closestValue) {
					  closestValue=Math.abs(intPayAmount-payv);
					  drop.selectByIndex(i);  
				  }
		}                 
		
	}

	private int removeCurrencyAndDecimalsAndConvertToInt(String convertValue) {
		//Remove Currency Symbol in front of pay amount
		convertValue = convertValue.substring(1).trim();
		//Remove decimal of pay amount ",00"
		convertValue = convertValue.substring(0,convertValue.length()-3);
		//Convert stringPayAmount to integer payAmount
		int intPayAmount = Integer.parseInt(convertValue);
		return intPayAmount;
	}

}
