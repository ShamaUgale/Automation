package com.flipkart.Util;

public class FileUtils {
public static Object[][] getTestdata(String filePath , String SheetName){
		
		Xls_Reader xls= new Xls_Reader(filePath);
		int rows= xls.getRowCount(SheetName);
		int cols = xls.getColumnCount(SheetName);
		
		Object[][] data= new Object[rows-1][cols];

		for(int i=0;i<rows-1;i++){
			for(int j=0;j<cols;j++){
				data[i][j]=xls.getCellData(SheetName, j, i+2);
			}
		}
		// M2_HOME
		
		
		return data;
	}
	
	
}
