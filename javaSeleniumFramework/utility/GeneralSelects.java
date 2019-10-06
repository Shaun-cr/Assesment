package utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class GeneralSelects {
	
	public static void selectItemFromWebElementlist(List<WebElement> webElementList , String searchItemInList) {
		Browser.implicitlyWait();
		int counter = 0;
	    for ( WebElement i: webElementList) { 
	        if ( i.getText().trim().equals(searchItemInList) ) {
	        	webElementList.get(counter).click();
	        	break;
	       }
	        counter++; 
	    }	
		
	}
	
	public static void selectItemFromWebElementlist(List<WebElement> webElementList , String searchItemInList,int startSubstringFrom) {
		Browser.implicitlyWait();
		int counter = 0;
	    for ( WebElement i: webElementList) { 
	        if ( i.getText().substring(startSubstringFrom).trim().equals(searchItemInList  ) ) {
	        	webElementList.get(counter).click();
	        	break;
	       }
	        counter++; 
	    }
		
	}
	
	
	


}
