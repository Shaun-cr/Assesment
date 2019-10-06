package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.GeneralChecks;
import utility.GeneralSelects;

public class PageRestaurantMenu {
	
	@FindBy(how = How.XPATH,using = "//div[@id='imenucard']")
	private WebElement webElementPage;
	
	@FindBy(how = How.XPATH,using = "//div[@id='imenucard']//span[@class='meal-name']")
	private List<WebElement> listOfMenuItems;
	
	@FindBy(how = How.XPATH,using = "//button[@class='basket__order-button cartbutton-button']")
	private WebElement buttonOrder;
	
	public boolean isAt() {
		return GeneralChecks.isWebElementDisplayed(webElementPage); 
	}

	public void addDishToBasket(String dishName) {
		GeneralSelects.selectItemFromWebElementlist(listOfMenuItems, dishName);
	}

	public void clickOrderButton() {
		buttonOrder.click();		
	}
	
}
