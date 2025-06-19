package PracticeTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataOProviderTest {
	@Test(dataProvider = "getData")
	public void CreateContactTest(String un,String ln) {
		System.out.println("FirstName: " + un + ", latname :"+   ln);
		
	}
	@DataProvider
	public Object[] [] getData()
	{
		Object [] [] objarr=new Object[3] [2];
		objarr[0] [0]="Smita";
		objarr[0] [1]="Hr";
		objarr[1] [0]="Sam";
		objarr[1] [1]="S";
		objarr[2] [0]="jhon";
		objarr[2] [1]="Smith";
		
		return objarr;
		
	}

}
