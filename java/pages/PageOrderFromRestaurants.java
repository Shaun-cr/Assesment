package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.GeneralChecks;

public class PageOrderFromRestaurants {
	@FindBy(how = How.XPATH,using = "//body[@class='step2 is-restaurant-list welcome']")
	private WebElement webElementPageBody;

	public boolean isAt() {
		////
		return GeneralChecks.isWebElementDisplayed(webElementPageBody); 
	}

}
