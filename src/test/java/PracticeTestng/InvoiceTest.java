package PracticeTestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
//@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
public class InvoiceTest extends BaseClass
{
	@Test
	public void createinvoiceTest() 
	{
		System.out.println("execreateinvoiceTest");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test
	public void createinvoiceTestwithcontat()
	{
		
		System.out.println("execrecreateinvoiceTestwithcontat");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	

}
