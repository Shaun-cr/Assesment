package utility;

import java.util.List;

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
	
	public static boolean isWebListElementNotEmpty(List<WebElement> WebListElement){
		boolean isEmpty = false;
		try{
			Browser.implicitlyWait();
			Browser.ExplicitWait(WebListElement);
				if (!WebListElement.isEmpty()){
					isEmpty = true;
				}
			}
		catch(Exception e){
			System.out.println(WebListElement + " : is WebListElement Displayed");
			}
		return isEmpty;
	}

}
