package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Base.TestBase;
import com.flipkart.Selenium.Keywords;

public class HeaderPage {
	
	
	///////////////////////// Elements //////////////////////////////
	
	@FindBy(name="q")
	public WebElement SEARCH_TXT_BOX;
	
	@FindBy(xpath="//button[@class='vh79eN' and @type='submit']")
	public WebElement SEARCH_BTN;
	
	
	
	
	/////////////////////// Features  //////////////////////////

	
	public void searchProduct(String product){
		Keywords.type(SEARCH_TXT_BOX, product);
		Keywords.click(SEARCH_BTN);
	}
	
	public void goToHomePage(){
		Keywords.navigateToURL(TestBase.CONFIG.getProperty("testURL"));
	}
	
	
	
	
	
	
	
	
}
