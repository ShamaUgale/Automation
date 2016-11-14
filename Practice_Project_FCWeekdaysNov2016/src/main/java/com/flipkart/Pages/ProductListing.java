package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Selenium.Keywords;

public class ProductListing {

	
	///////////////////////// Elements //////////////////////////////

	
	@FindBy(xpath="//span[@class='W-gt5y']")
	public WebElement SEARCHED_FOR_TXT_BOX;
	
	
	/////////////////////// Features  //////////////////////////

	
	public boolean verifySearchText(String expectedText){
		return	Keywords.verifyElementText(SEARCHED_FOR_TXT_BOX, expectedText);
	}
}
