package automationassignment;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import pages.Pages;

public class TestCase1 extends Base{
	
  @Test
  public void step1_EnterAddress() {
	  
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress("8888","8888 Alpha");
  }
  
  @Test (dependsOnMethods={"step1_EnterAddress"})
  public void step2_SearchForRestaurantsNearAddress() {
	  
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isRestaurantsListDisplayed(),"Pages.pageOrderFromRestaurants().isRestaurantsListDisplayed() - Restaurants List looks like it is empty");
	  Pages.pageDisplayRestaurants().searchAndSelectRestaurant("Pan Pizza Man");
  }
  
  @Test (dependsOnMethods={"step2_SearchForRestaurantsNearAddress"})
  public void step3_AddItemsToBasket() {
	  
	  Assert.assertTrue(Pages.pageRestaurantMenu().isAt(),"Pages.pageRestaurantMenu().isAt() - Page not found !");
	  Pages.pageRestaurantMenu().addDishToBasket("Selenium food");
	  Pages.pageRestaurantMenu().addDishToBasket("Hawaii shirt");
	  Pages.pageRestaurantMenu().clickOrderButton();
  }
  
  @Test (dependsOnMethods={"step3_AddItemsToBasket"})
  public void step4_captureDetailsForDelivery() {
	  
  }
  
  
  
}
