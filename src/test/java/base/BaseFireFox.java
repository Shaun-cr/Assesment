package base;
import utility.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseFireFox {
  
	 @BeforeClass
     public static void openPage(){
	 	Browser.runFirefox();
	 	Browser.getSessionID();
	 	Browser.maximizeBrowser();
	 	Browser.goToThuisbezorgd();
	} 

	 @AfterClass
	 public static void closeBrowser(){
		Browser.Close();
	 }
}
