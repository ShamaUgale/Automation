package com.flipkart.HeaderTest;

import java.io.IOException;

import org.jboss.netty.handler.codec.http.multipart.FileUpload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Base.TestBase;
import com.flipkart.Pages.HeaderPage;
import com.flipkart.Pages.ProductListing;
import com.flipkart.Selenium.Keywords;
import com.flipkart.Util.FileUtils;

public class HeaderTest {

	WebDriver driver=null;
	
	@BeforeSuite
	public void setup() throws IOException{
		
		TestBase.initialize();
		Keywords.openBrowser();
	
		driver=TestBase.driver;
	}
	
	@BeforeMethod
	public void navigateToHomePage(){
		HeaderPage hp= PageFactory.initElements(driver, HeaderPage.class);
		hp.goToHomePage();
	}
	
	
	@Test(dataProvider="getSearchData")
	public void searchProductTest(String productName){
		HeaderPage hp= PageFactory.initElements(driver, HeaderPage.class);
		hp.searchProduct(productName);
		
		ProductListing pl= PageFactory.initElements(driver, ProductListing.class);
		boolean isProductDisplayed=pl.verifySearchText(productName);
		
		Assert.assertTrue(isProductDisplayed, "Product Listing page for product '"+productName+"' was not displayed.");
		
	}
	
	@DataProvider
	public static Object[][] getSearchData(){
		return FileUtils.getTestdata(TestBase.PROJECT_PATH + "\\src\\test\\resources\\SearchTest.xlsx", "ProductSearch");
		
	}
	
	
	
}
