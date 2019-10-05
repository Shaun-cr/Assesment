package pages;

import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class Pages {
	
	public static  PageTimeToOrderFood pageTimeToOrderFood () {
		PageTimeToOrderFood page = new PageTimeToOrderFood();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

	public static PageDisplayRestaurants pageDisplayRestaurants() {
		PageDisplayRestaurants page = new PageDisplayRestaurants();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

	public static PageRestaurantMenu pageRestaurantMenu() {
		PageRestaurantMenu page = new PageRestaurantMenu();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

	public static PageCheckout pageCheckout() {
		PageCheckout page = new PageCheckout();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

}
