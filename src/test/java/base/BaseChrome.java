package base;
import utility.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseChrome {
  
	 @BeforeClass
     public static void openPage(){
	 	Browser.runChrome();
	 	Browser.getSessionID();
	 	Browser.goToThuisbezorgd();
	} 

	 @AfterClass
	 public static void closeBrowser(){
		Browser.Close();
	 }
}
