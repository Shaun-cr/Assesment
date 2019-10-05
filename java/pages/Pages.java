package pages;

import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class Pages {
	
	public static  PageTimeToOrderFood pageTimeToOrderFood () {
		PageTimeToOrderFood page = new PageTimeToOrderFood();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

	public static PageOrderFromRestaurants pageOrderFromRestaurants() {
		PageOrderFromRestaurants page = new PageOrderFromRestaurants();
		PageFactory.initElements(Browser.getDriver(), page);
		return page;
	}

}
