package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Browser;
import utility.GeneralChecks;
import utility.GeneralSelects;

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
		GeneralSelects.selectItemFromWebElementlist(listMultipleDeliveryAddress,enterSpecificAddress);
	}
		

	private void selectSuggestedAddressFromList(String addressDetails) {
		GeneralSelects.selectItemFromWebElementlist(listSuggestionDeliveryAddress, addressDetails, 11);
		/*
		Browser.implicitlyWait();
		int counter = 0;
	    for ( WebElement i: listSuggestionDeliveryAddress) { 
	        if ( i.getText().substring(11).trim().equals(addressDetails  ) ) {
	        	listSuggestionDeliveryAddress.get(counter).click();
	        	break;
	       }
	        counter++; 
	        
	    }*/
	}
}
