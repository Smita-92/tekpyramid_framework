package Dataprovider;

import org.testng.annotations.DataProvider;

import excelutility.excelutility;

public class DataProviderUtilityTest {
	@DataProvider
	public Object[] [] craeteorgwithorgnameTest() throws Throwable{
		excelutility  eLib=new excelutility();
		int rowcount = eLib.getRowcount("org");
		
			Object [] [] objarr=new Object[rowcount] [1];
			for(int i=0;i<rowcount;i++) {
			objarr[i] [0]=eLib.getDataFromExcel("org", i+1, 2);
			
}
			return objarr;
	}

@DataProvider
public Object[] [] craeteorgwithphnoTest() throws Throwable{
	excelutility  eLib=new excelutility();
	int rowcount = eLib.getRowcount("Sheet1");
	
		Object [] [] objarr=new Object[rowcount] [2];
		for(int i=0;i<rowcount;i++) {
		objarr[i] [0]=eLib.getDataFromExcel("Sheet1", i+1, 2);
		objarr[i] [1]=eLib.getDataFromExcel("Sheet1", i+1, 3);
		
}
		return objarr;
}}