package test;

import com.flipkart.Util.Xls_Reader;

public class xlsRead {

	
	
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
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Xls_Reader xls= new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\resources\\testSheet.xlsx");
	
		int rows= xls.getRowCount("Test1");
		int cols = xls.getColumnCount("Test1");
		
		System.out.println("Rows : "+ rows);
		System.out.println("Cols : "+ cols);
	
	System.out.println("Data ---> "+ xls.getCellData("Test1", 1, 4));
	
	
	for(int i=1;i<rows;i++){
		for(int j=0;j<cols;j++){
			System.out.println(xls.getCellData("Test1", j, i+1));
		}
	}
	
	
	
	
	System.out.println("********************************************");
	
	Object[][] data= new Object[rows-1][cols];
	
	
	for(int i=0;i<rows-1;i++){
		for(int j=0;j<cols;j++){
			System.out.println(xls.getCellData("Test1", j, i+1));
			data[i][j]=xls.getCellData("Test1", j, i+2);
		}
	}
	
	
	
	for(int i=0;i<data.length;i++){
		for(int j=0;j<data[0].length;j++){
			System.out.println(data[i][j]);
		}
	}
	
	
	
	
	}

}
