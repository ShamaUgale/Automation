package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

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
	public static void navigateForward(){
		driver.navigate().forward();
	}
	
	//refreshPage
	public static void refresh(){
		driver.navigate().refresh();
	}
	
	
	public static void click(WebElement elem){
		// click on elem
		elem.click();
	}
	
	// type
	public static void type(WebElement elem, String data){
		elem.sendKeys(data);
	}
	
	
	public static boolean verifyChechboxChecked(WebElement elem){
		if(elem.isSelected()){
			return true;
		}else{
			return false;
		}
		
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

	//drop downs
	
	public static void selectDropDownByIndex(WebElement elem, int index)
	{
		try
		{
			Select sec= new Select(elem);
			sec.selectByIndex(index);
		}catch (NoSuchElementException e)
		{
			
		}catch (Exception e){
			
		}
	}
	
	// selectDropDownByValue
	public static void selectDropDownByValue(WebElement elem, String str)
	{
		try
		{
			Select sec= new Select(elem);
			sec.selectByValue(str);
		}catch (NoSuchElementException e)
		{
			
		}catch (Exception e){
			
		}
	}
	
	//selectDropDownByText
	public static void selectDropDownByText(WebElement elem, String str)
	{
		try
		{
			Select sec= new Select(elem);
			sec.selectByValue(str);
		}catch (NoSuchElementException e)
		{
			
		}catch (Exception e){
			
		}
	}

	
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
								
				public static int countFrames(){
					
					int frameCount=	driver.findElements(By.tagName("iframe")).size();
					return frameCount;
					
				}
				
				public static void switchFramesByIndex(int i){
					try{
					driver.switchTo().frame(i);
					}catch(IndexOutOfBoundsException e){
					}
					catch(Exception e){
					}
				}	
				
				public static void switchFramesByName(String str){
					try{
					driver.switchTo().frame(str);
					}catch(NoSuchElementException e){
					}
					catch(Exception e){
					}
				}
				
				public static void switchFramesByID(String str){
					try{
					driver.switchTo().frame(str);
					}catch(NoSuchElementException e){
					}
					catch(Exception e){
					}
				}
				
				public static void switchToDefaultContent(){
					driver.switchTo().defaultContent();
				}
				
	// windows
				
    // hover
				public static void hover(WebElement elem){
					try{
					
					
					Actions act= new Actions(driver);
					act.moveToElement(elem).build().perform();
					}catch(NoSuchElementException e){
					}catch(Exception e){
					}
				}
				
				
	// explicit waits
				
				public static void waitForElementToBeClickable(WebElement elem,int timeout){
					WebDriverWait wait= new WebDriverWait(driver, timeout);
					wait.until(ExpectedConditions.elementToBeClickable(elem));
				}
				
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
