package automationassignment;



import java.io.File;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseChrome;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pages.Pages;

public class TestCase3 extends BaseChrome{
	String ExcellPath = "C:\\Users\\shauncr\\eclipse-workspace\\Assesment\\src\\Excell\\StaticData.xls";
/*
  @DataProvider     
  public Object[][] testData(){
	  return new Object[][] {
		  new Object[] {"8888","8888 Alpha"},
		  };
	  }
 */
	
    @DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray(ExcellPath, "Sheet1", "testData1");
        return(retObjArr);
    }
  
  @Test(dataProvider="DP1")
  public void step1_EnterAddress(String Address1,String Address2) throws Exception{
	  
	  Assert.assertTrue(Pages.pageTimeToOrderFood().isAt(),"Pages.pageTimeToOrderFood().isAt() - Page not found !");
	  Pages.pageTimeToOrderFood().enterAddress(Address1,Address2);
  }
  /*
  @Test (dependsOnMethods={"step1_EnterAddress"})            
  public void step2_SearchForRestaurantsNearAddress() {
	  
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isAt(),"Pages.pageOrderFromRestaurants().isAt() - Page not found !");
	  Assert.assertTrue(Pages.pageDisplayRestaurants().isRestaurantsListDisplayed(),"Pages.pageOrderFromRestaurants().isRestaurantsListDisplayed() - Restaurants List looks like it is empty");
	  Pages.pageDisplayRestaurants().searchAndSelectRestaurant("QA Restaurant Selenium");
	  
  }
  
  @Test (dependsOnMethods={"step2_SearchForRestaurantsNearAddress"})
  public void step3_AddItemsToBasket() {
	  
	  Assert.assertTrue(Pages.pageRestaurantMenu().isAt(),"Pages.pageRestaurantMenu().isAt() - Page not found !");
	  Pages.pageRestaurantMenu().addDishToBasket("Salami");
	  Pages.pageRestaurantMenu().clickOrderButton();
  }

  @Test (dependsOnMethods={"step3_AddItemsToBasket"})
  public void step4_CaptureDetailsForDelivery() {
	  
	  Assert.assertTrue(Pages.pageCheckout().isAt(),"Pages.pageCheckout().isAt() - Page not found !");
	  Pages.pageCheckout().captureAddressDetails("main street 2415","8888AA","Enschede");
	  Pages.pageCheckout().capturePersonalDetails("TestUSer","1234567890","testuser@test.test");
	  Pages.pageCheckout().selectDeliveryTime("As soon as possible");
	  Pages.pageCheckout().clickOrderAndPayButton();
	  
  }
  
  @Test (dependsOnMethods={"step4_CaptureDetailsForDelivery"})
  public void step5_ReceiveOrderReference() {
	  
	  Assert.assertTrue(Pages.pageThankYouForYourOrder().isAt(),"Pages.pageThankYouForYourOrder().isAt() - Page not found !");
	  Reporter.log("The Order Reference Number is: " + Pages.pageThankYouForYourOrder().getOrderReference());
  }
  */
  public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
      String[][] tabArray=null;
      
          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
          Sheet sheet = workbook.getSheet(sheetName); 
          int startRow,startCol, endRow, endCol,ci,cj;
          Cell tableStart=sheet.findCell(tableName);
          startRow=tableStart.getRow();
          startCol=tableStart.getColumn();

          Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

          endRow=tableEnd.getRow();
          endCol=tableEnd.getColumn();
          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                  "startCol="+startCol+", endCol="+endCol);
          tabArray=new String[endRow-startRow-1][endCol-startCol-1];
          ci=0;

          for (int i=startRow+1;i<endRow;i++,ci++){
              cj=0;
              for (int j=startCol+1;j<endCol;j++,cj++){
                  tabArray[ci][cj]=sheet.getCell(j,i).getContents();
              }
          }
      
      return(tabArray);
  }
  
  
  
}
