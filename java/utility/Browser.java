package utility;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	private static WebDriver driver;
	private static int ExplicitWaitTimeOut = 2;
	
	private  Browser (WebDriver driver){ 
		Browser.driver = driver;
	}

	public static void Close() {
		driver.close();
		
	}

	public static Browser runChrome() {

		ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    options.addArguments("--disable-infobars");
	    
		//disable save password
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shauncr\\eclipse-workspace\\Assesment\\src\\webdriver\\chromedriver\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver(options);
		
		Browser browserChrome = new Browser (webDriver);
		return browserChrome;
	}
	
	public static void goToThuisbezorgd() {
		String testUrl = "https://www.thuisbezorgd.nl/en/";
		driver.get(testUrl);
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}


	public static void ExplicitWait( WebElement WebElement, int seconds){
		try{
			(new WebDriverWait(driver,seconds)).until(ExpectedConditions.elementToBeClickable(WebElement));
		} 
		catch (Exception e) {
			System.out.println("ExplicitWait failed on this webElement: " + WebElement); ;
		}

	}


	public static void ExplicitWait( WebElement WebElement){
		try{
			Browser.implicitlyWait();
			(new WebDriverWait(driver,ExplicitWaitTimeOut)).until(ExpectedConditions.visibilityOf(WebElement));

		} 
		catch (Exception e) {
			System.out.println("ExplicitWait failed on this webElement: " + WebElement); 

		}
	}


	public static void implicitlyWait() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime newTime = now.plusSeconds(2);

			do{
				now = LocalDateTime.now();
			}
			while(now.isBefore(newTime)) ;
		
	}


	
	public static void ExplicitWait(List<WebElement> WebListElement){
		try{
			Browser.implicitlyWait();
			(new WebDriverWait(driver,ExplicitWaitTimeOut)).until(ExpectedConditions.visibilityOfAllElements(WebListElement));

		} 
		catch (Exception e) {
			System.out.println("ExplicitWait failed on this WebListElement: " + WebListElement); 
		}
	}

	public static Browser runIE() {
		String IEDriverPath = "C:\\Users\\shauncr\\eclipse-workspace\\Assesment\\src\\webdriver\\iedriverserver\\IEDriverServer3.12.exe";
		System.setProperty("webdriver.ie.driver",IEDriverPath);
		DesiredCapabilities dc = new DesiredCapabilities();	
		dc.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.thuisbezorgd.nl/en/"); 
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		WebDriver webDriver = new InternetExplorerDriver(dc);
		Browser browserIE = new Browser (webDriver);
		return browserIE;
		
	}
	
	public static void maximizeBrowser(){
		driver.manage().window().maximize();	
	}

	public static Browser runFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\shauncr\\eclipse-workspace\\Assesment\\src\\webdriver\\geckodriver\\geckodriver.exe");
		WebDriver webDriver = new FirefoxDriver();
		Browser browserFirefox = new Browser (webDriver);
		return browserFirefox;
	}

	public static void getSessionID() {
		SessionId session = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session id: " + session.toString());
		
	}

		

}
