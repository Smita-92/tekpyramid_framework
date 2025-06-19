package PracticeTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createcontact1dpTest {
	@Test(dataProvider = "getData")
	public void CreateContactTest(String un,String ln,long phno) {
		System.out.println("FirstName: " + un + ", latname :"+   ln +"phono:"    + phno);
		
	}
	@DataProvider
	public Object[] [] getData()
	{
		Object [] [] objarr=new Object[3] [3];
		objarr[0] [0]="Smita";
		objarr[0] [1]="Hr";
		objarr[0] [2]="977544699";
		
		objarr[1] [0]="Sm";
		objarr[1] [1]="Sam";
		objarr[1] [2]="97754499";
		
		objarr[2] [0]="S";
		objarr[2] [1]="jhon";
		objarr[2] [2]="977549989";
		
		return objarr;

}}
