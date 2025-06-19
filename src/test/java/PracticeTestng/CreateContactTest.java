package PracticeTestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	
	@BeforeSuite
	public void configBS() {
		System.out.println(" execute BS");
	}
	
	
	@BeforeClass
	public void configBC() {
		System.out.println(" execute BC");
	}
	
	

	@Test
	
	public void createcontact() {
		System.out.println(" execute createcontact");
	}
@Test
	
	public void createcontactwithdate() {
		System.out.println(" execute createcontactwithdate");
	}
@BeforeMethod

public void configBM() {
	System.out.println(" execute BM");
}
@AfterMethod
public void configAM() {
	System.out.println(" execute AM");
}

@AfterClass
public void configAC() {
	System.out.println(" execute AC");
}

@AfterSuite
public void configAS() {
	System.out.println(" execute AS");
}

}
