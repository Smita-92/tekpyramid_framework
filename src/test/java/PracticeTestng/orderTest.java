package PracticeTestng;

import org.testng.annotations.Test;

public class orderTest {

	@Test(invocationCount = 10)
	
	public void createordretest() {
		System.out.println("Execute createorder==>123");
	}
	@Test(enabled = false)
	public void billingordretest() {
		System.out.println("Execute billingorder==>123");
	}
	
}
