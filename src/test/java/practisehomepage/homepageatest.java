package practisehomepage;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class homepageatest {
	@Test
	
	public void VerifyHomePage(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		String expectedPage="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		String acttitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(acttitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName() + "Test end");
		
		
		
		
	}
	@Test
	
	public void verifylogo(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
	
		Assert.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName() + "Test end");
		
	}

}
