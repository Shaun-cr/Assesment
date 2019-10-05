package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.GeneralChecks;

public class PageOrderFromRestaurants {
	@FindBy(how = How.XPATH,using = "//body[@class='step2 is-restaurant-list welcome']")
	private WebElement webElementPageBody;
	
	@FindBy(how = How.XPATH,using = "//div[@id='irestaurantlist']")
	private List<WebElement> listRestaurants;
	
	public boolean isAt() {
		return GeneralChecks.isWebElementDisplayed(webElementPageBody); 
	}

	public boolean isRestaurantsListDisplayed() {
		return GeneralChecks.isWebListElementNotEmpty(listRestaurants);
	}

}
