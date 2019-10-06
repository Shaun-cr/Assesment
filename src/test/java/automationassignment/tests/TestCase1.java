package automationassignment.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import base.BaseChrome;
import pages.Pages;

public class TestCase1 extends BaseChrome{
// I created this test to confirm that flow is working correthly. That a client can place a very basic simple order.
// I confirm that every page does exist in flow
// I excluded static data from excell file in this test, because I wanted to show easy data can be passed in manually  -this is ideal for any one to create their own scenarios
// Please see how easy it is to create test from framework. Type "Pages.", you should be able to see all the pages and after that what can be done a page	
// Please see bonus test can run in firefox	
	
// To run this test - right click and select run as TestNG test.If you don't have option, then please install testng plugin
// to run test suite - right click testNG.xml and run as TestNG Suite	
	       
  @Test
  public void step1_EnterAddress() {
	  
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress("8888","8888 Alpha");
  }
  
  @Test (dependsOnMethods={"step1_EnterAddress"})            
  public void step2_SearchForRestaurantsNearAddress() {
	  
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");
	  //Here I confirm that Restaurant list display and that it for postal code 8888-alpha
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isRestaurantsListDisplayed(),"Pages.pageOrderFromRestaurants().isRestaurantsListDisplayed() - Restaurants List looks like it is empty");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAddressDisplayedCorrect("8888-alpha"));
	  // I did assume that I could select any restaurant from assesment
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
  
  //To view test results go to test-output folder and select either index.html but for more detail report select emailable-report.html
  
  
}
