package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertyFilesReading {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));
		
		Properties prop= new Properties();
		FileInputStream ip= new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\flipkart\\config\\config.properties"));
		
		prop.load(ip);
		
		
		System.out.println(prop.getProperty("implicitWait"));
		
		Set s=prop.keySet();
		
		
		Iterator it= s.iterator();
		while(it.hasNext()){
			String key= it.next().toString();
			System.out.println(key + " : "+ prop.getProperty(key));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
