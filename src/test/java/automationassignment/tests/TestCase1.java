package automationassignment.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import base.BaseChrome;
import pages.Pages;

public class TestCase1 extends BaseChrome{
	
  @Test
  public void step1_EnterAddress() {
	  
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress("8888","8888 Alpha");
  }
  
  @Test (dependsOnMethods={"step1_EnterAddress"})            
  public void step2_SearchForRestaurantsNearAddress() {
	  
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isRestaurantsListDisplayed(),"Pages.pageOrderFromRestaurants().isRestaurantsListDisplayed() - Restaurants List looks like it is empty");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAddressDisplayedCorrect("8888-alpha"));
	 // Pages.pageDisplayRestaurants().searchAndSelectRestaurant("Pan Pizza Man");
	  Pages.pageDisplayRestaurants().searchAndSelectRestaurant("QA Restaurant Selenium");
	  
  }

  @Test (dependsOnMethods={"step2_SearchForRestaurantsNearAddress"})
  public void step3_AddItemsToBasket() {
	  
	  Assert.assertTrue(Pages.pageRestaurantMenu().isAt(),"Pages.pageRestaurantMenu().isAt() - Page not found !");
	  //Pages.pageRestaurantMenu().addDishToBasket("Selenium food");
	  //Pages.pageRestaurantMenu().addDishToBasket("Hawaii shirt");
	  Pages.pageRestaurantMenu().addDishToBasket("Chicken Breast");
	  Pages.pageRestaurantMenu().clickOrderButton();
  }
  
  @Test (dependsOnMethods={"step3_AddItemsToBasket"})
  public void step4_CaptureDetailsForDelivery() {
	  
	  Assert.assertTrue(Pages.pageCheckout().isAt(),"Pages.pageCheckout().isAt() - Page not found !");
	  Pages.pageCheckout().captureAddressDetails("main street 2415","8888AA","Enschede");
	  Pages.pageCheckout().capturePersonalDetails("TestUSer","1234567890","testuser@test.test");
	  Pages.pageCheckout().selectDeliveryTime("As soon as possible");
	  Pages.pageCheckout().selectPayAmountClosestToOrderPrice();
	  Pages.pageCheckout().clickOrderAndPayButton();
	  
  }
  
  @Test (dependsOnMethods={"step4_CaptureDetailsForDelivery"})
  public void step5_ReceiveOrderReference() {
	  
	  Assert.assertTrue(Pages.pageThankYouForYourOrder().isAt(),"Pages.pageThankYouForYourOrder().isAt() - Page not found !");
	  Reporter.log("The Order Reference Number is: " + Pages.pageThankYouForYourOrder().getOrderReference());
  }
  
  
}
