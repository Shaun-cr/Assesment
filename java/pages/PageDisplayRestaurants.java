package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.GeneralChecks;
import utility.GeneralSelects;

public class PageDisplayRestaurants {
	@FindBy(how = How.XPATH,using = "//body[@class='step2 is-restaurant-list welcome']")
	private WebElement webElementPageBody;
	
	@FindBy(how = How.XPATH,using = "//div[@id='irestaurantlist']//h2[@class='restaurantname']/a")
	private List<WebElement> listRestaurants;
	
	@FindBy(how = How.XPATH,using = "//input[@id='irestaurantsearchstring-middle']")
	private WebElement textboxSearch;
	
	
	public boolean isAt() {
		return GeneralChecks.isWebElementDisplayed(webElementPageBody); 
	}

	public boolean isRestaurantsListDisplayed() {
		return GeneralChecks.isWebListElementNotEmpty(listRestaurants);
	}

	public void searchAndSelectRestaurant(String RestaurantName) {
		textboxSearch.sendKeys(RestaurantName);
		GeneralSelects.selectItemFromWebElementlist(listRestaurants, RestaurantName);
   
	}
	
}
