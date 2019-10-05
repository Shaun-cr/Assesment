package utility;

import org.openqa.selenium.WebElement;

public class GeneralChecks {
	
	public static boolean isWebElementDisplayed(WebElement WebElement){
		boolean isDisplayed = false;
		try{
			Browser.implicitlyWait();
			Browser.ExplicitWait(WebElement);
				if (WebElement.isDisplayed()){
					isDisplayed = true;
				}
			}
		catch(Exception e){
			System.out.println(WebElement + " : is WebElement Displayed");
			}
		return isDisplayed;
	}

}
