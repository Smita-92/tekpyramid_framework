package PracticeTestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class InvoiceTest1 extends BaseClass {
	
	@Test(retryAnalyzer = com.comcast.crm.Listner_utility.RetryListnerimp.class)
			
	public void Activesim() 
	{
		System.out.println("execreateinvoiceTest");
		
		Assert.assertEquals(" ", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");

}
}