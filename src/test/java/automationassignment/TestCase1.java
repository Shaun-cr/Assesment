package automationassignment;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import pages.Pages;

public class TestCase1 extends Base{
	
  @Test
  public void step1() {
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress("8888","8888 Alpha");
  }
  
  @Test (dependsOnMethods={"step1"})
  public void step2() {
	  Assert.assertTrue(Pages.pageOrderFromRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");

	  
  }
}
