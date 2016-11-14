package com.flipkart.Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.Base.TestBase;

public class Keywords extends TestBase{

	//openBrowser
	
	public static void openBrowser(){
		String browser=CONFIG.getProperty("browserType");
		String useFirefoxProfile=CONFIG.getProperty("UseFirefoxProfile");
		String firefoxProfile=CONFIG.getProperty("FirefoxProfile");

		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setBrowserName(browser);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
		caps.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
		
		
		int implicitwait= Integer.parseInt(CONFIG.getProperty("implicitWait"));
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", PROJECT_PATH+"\\src\\main\\resources\\com\\flipkart\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}else if(browser.equalsIgnoreCase("FF")){
			if(useFirefoxProfile.equalsIgnoreCase("true")){
				ProfilesIni profiles= new ProfilesIni();
				FirefoxProfile fp=profiles.getProfile(firefoxProfile);
				driver= new FirefoxDriver(fp);
			}else{
			driver= new FirefoxDriver(caps);
			}
			
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", PROJECT_PATH+"\\src\\main\\resources\\com\\flipkart\\Drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver(caps);
		}else {
			System.setProperty("webdriver.chrome.driver", PROJECT_PATH+"\\src\\main\\resources\\com\\flipkart\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
	}
	
	
	//navigate
	public static void navigateToURL(String URL){
		driver.navigate().to(URL);
	}
	
	//navigate back
	public static void navigateBack(){
		driver.navigate().back();
	}
	
	
	//navigate forward
	//refreshPage
	
	// click on elem
	public static void click(WebElement elem){
		elem.click();
	}
	
	// type
	public static void type(WebElement elem, String data){
		elem.clear();
		elem.sendKeys(data);
	}
	
	
	public static boolean verifyChechboxChecked(WebElement elem){
		if(elem.isSelected()){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public static String getCurrentPageTitle(){ 
		return driver.getTitle();
	}
	
	public static boolean verifyChechboxUnChecked(WebElement elem){
		if(elem.isSelected()){
			return false;
		}else{
			return true;
		}
		
	}
	
	public static String getElementText(WebElement elem){
		String txt= elem.getText();
		return txt;
	}
	
	
	public static boolean verifyElementText(WebElement elem, String expectedText){
		try{
		String actualText=getElementText(elem).trim();
		if(actualText.equalsIgnoreCase(expectedText)){
			return true;
		}else{
			return false;
		}
		}catch(NoSuchElementException e){
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}catch (Throwable e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	
	public static Set<String> getAllWindowIds(){
		return driver.getWindowHandles();
	}
	
	//drop downs
	
	public static void selectDropDownByIndex(WebElement elem, int index){
		Select sec= new Select(elem);
		sec.selectByIndex(index);
	}
	
	// selectDropDownByValue
	//selectDropDownByText
	
	// acceptAlert
	public static void acceptAlert(){
		Alert alt= driver.switchTo().alert();
		alt.accept();
	}
	
	// dismissAlert
		public static void dismissAlert(){
			Alert alt= driver.switchTo().alert();
			alt.dismiss();
		}
	
		// dismissAlert
				public static String getAlertText(){
					Alert alt= driver.switchTo().alert();
					return alt.getText();
				}
			
	// frames - 3 options
	// windows
    // hover
	// explicit waits
	// 
				
				public static boolean isElementPresent(WebElement elem){
					try{
					if(elem.isDisplayed()){
						return true;
					}else{
						return false;
					}
					}catch(NoSuchElementException e){
						return false;
					}
				}
}
