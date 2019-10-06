package automationassignment.tests;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseChrome;
import pages.Pages;
import utility.Data;

public class TestCase2 extends BaseChrome{

	//Start to Feed data from excel spreadsheet
    @DataProvider(name = "testData1")
    public Object[][] createDataSet1() throws Exception{
        Object[][] returnObjectArray= Data.getTableArrayFromSpreadsheet("testData1" );
        return(returnObjectArray);
    }
    
    @DataProvider(name = "testData2")
    public Object[][] createDataSet2() throws Exception{
        Object[][] returnObjectArray= Data.getTableArrayFromSpreadsheet("testData2" );
        return(returnObjectArray);
    }
    
    @DataProvider(name = "testData3")
    public Object[][] createDataSet3() throws Exception{
        Object[][] returnObjectArray= Data.getTableArrayFromSpreadsheet("testData3" );
        return(returnObjectArray);
    }
    
    @DataProvider(name = "testData4")
    public Object[][] createDataSet4() throws Exception{
        Object[][] returnObjectArray= Data.getTableArrayFromSpreadsheet("testData4" );
        return(returnObjectArray);
    }
    
  //Stop to Feed data from excel spreadsheet
    
  @Test(dataProvider="testData1")
  public void step1_EnterAddress(String address1,String address2) {
	  
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress(address1,address2);
  }

  @Test (dependsOnMethods={"step1_EnterAddress"},dataProvider="testData2")       
  public void step2_SearchForRestaurantsNearAddress(String restaurant) throws Exception{
	  
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isRestaurantsListDisplayed(),"Pages.pageOrderFromRestaurants().isRestaurantsListDisplayed() - Restaurants List looks like it is empty");
	  Pages.pageDisplayRestaurants().searchAndSelectRestaurant(restaurant);
  }
 
  @Test (dependsOnMethods={"step2_SearchForRestaurantsNearAddress"},dataProvider="testData3")
  public void step3_AddItemsToBasket(String dish) throws Exception{
	  
	  Assert.assertTrue(Pages.pageRestaurantMenu().isAt(),"Pages.pageRestaurantMenu().isAt() - Page not found !");
	  Pages.pageRestaurantMenu().addDishToBasket(dish);
	  Pages.pageRestaurantMenu().clickOrderButton();
  }

  @Test (dependsOnMethods={"step3_AddItemsToBasket"},dataProvider="testData4")
  public void step4_CaptureDetailsForDelivery(String address,String postCode,
		  									  String city, String name,String phoneNumber,
		  									  String email, String deliveryTime) throws Exception{
	  
	  Assert.assertTrue(Pages.pageCheckout().isAt(),"Pages.pageCheckout().isAt() - Page not found !");
	  Pages.pageCheckout().captureAddressDetails(address,postCode,city);
	  Pages.pageCheckout().capturePersonalDetails(name,phoneNumber,email);
	  Pages.pageCheckout().selectDeliveryTime(deliveryTime);
	  Pages.pageCheckout().clickOrderAndPayButton();
	  
  }
  
  @Test (dependsOnMethods={"step4_CaptureDetailsForDelivery"})
  public void step5_ReceiveOrderReference() {
	  
	  Assert.assertTrue(Pages.pageThankYouForYourOrder().isAt(),"Pages.pageThankYouForYourOrder().isAt() - Page not found !");
	  Reporter.log("The Order Reference Number is: " + Pages.pageThankYouForYourOrder().getOrderReference());
  }
  
}
