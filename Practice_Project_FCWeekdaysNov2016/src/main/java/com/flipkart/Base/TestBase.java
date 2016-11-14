package com.flipkart.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {

	
	public static WebDriver driver=null;
	public static Properties CONFIG=null;
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	
	
	public static void initialize() throws IOException{
		if(CONFIG==null){
			CONFIG= new Properties();
			FileInputStream ip= new FileInputStream(new File(PROJECT_PATH+"\\src\\main\\resources\\com\\flipkart\\config\\config.properties"));
			CONFIG.load(ip);
		}
	}
	
	
	
}
