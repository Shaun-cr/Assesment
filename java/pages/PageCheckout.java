package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

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
		//drop.selectByIndex(2);
		drop.selectByVisibleText(selectItem);
		//System.out.println(dropdownboxDeliveryTime.getAllSelectedOptions());
		//dropdownboxDeliveryTime.getAllSelectedOptions();
		//dropdownboxDeliveryTime.selectByVisibleText(selectItem);
		
	}

}
