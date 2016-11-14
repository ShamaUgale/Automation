package test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class find {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Users\\shama.ugale\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.commonfloor.com/agent/login?show_signup=1");
		
		driver.findElements(By.tagName("iframe")).get(0);
		
	}

}
