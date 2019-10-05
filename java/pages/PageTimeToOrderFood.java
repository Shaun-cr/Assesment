package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Browser;
import utility.GeneralChecks;

public class PageTimeToOrderFood {
	
	@FindBy(how = How.XPATH,using = "//h1[contains(.,'Time to order food')]")
	private WebElement webElementPageHeading;
	
	@FindBy(how = How.XPATH,using = "//input[@id='imysearchstring']")
	private WebElement textboxAddressDetails;
	
	@FindBy(how = How.XPATH,using = "//div[@id='iautoCompleteDropDownContent']")
	private List<WebElement> listSuggestionDeliveryAddress;
	
	@FindBy(how = How.XPATH,using = "//div[@class='popupoptions']//a[@id='reference']")
	private List<WebElement> listMultipleDeliveryAddress;

	public boolean isAt() {
		return GeneralChecks.isWebElementDisplayed(webElementPageHeading); 
	}

	public void enterAddress(String enterAddressDetails,String EnterSpecificAddress ) {
		textboxAddressDetails.sendKeys(enterAddressDetails);
		selectSuggestedAddressFromList(enterAddressDetails);
		selectSpecificAddressFromList(EnterSpecificAddress);
	}

	private void selectSpecificAddressFromList(String enterSpecificAddress) {
		Browser.implicitlyWait();
		int counter = 0;
	    for ( WebElement i: listMultipleDeliveryAddress) { 
	        if ( i.getText().trim().equals(enterSpecificAddress  ) ) {
	        	listMultipleDeliveryAddress.get(counter).click();
	        	break;
	       }
	        counter++; 
	    }
	}
		

	private void selectSuggestedAddressFromList(String addressDetails) {
		Browser.implicitlyWait();
		int counter = 0;
	    for ( WebElement i: listSuggestionDeliveryAddress) { 
	        if ( i.getText().substring(11).trim().equals(addressDetails  ) ) {
	        	listSuggestionDeliveryAddress.get(counter).click();
	        	break;
	       }
	        counter++; 
	    }
	}
}
