package practisehomepage;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class homepagesampletestHardAssert {
	@Test

	public void homepageatest(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		Reporter.log(null);
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Assert.assertEquals("home", "home");
		Reporter.log("Step-3",true);
		Assert.assertEquals("home-crm", "home-crm");
		Reporter.log("Step-4",true);

		Reporter.log(mtd.getName() + "Test end");

	}

	@Test

	public void verifylogo(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		
		Reporter.log("Step-3",true);

		Reporter.log("Step-4",true);

		Reporter.log(mtd.getName() + "Test end");
	}
}