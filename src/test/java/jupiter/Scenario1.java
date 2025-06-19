package jupiter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario1 {
	@Test
	public void testcase1() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String text = driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[@name='forename']")).sendKeys("Smita");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("debasmita98@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("hgvgeb freuyrf hbhhf bvdhb");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String acttext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(acttext);
//		String expctdtest="Thanks Smita";
//		Assert.assertTrue(true, acttext);
		driver.quit();
	}
	@Test(invocationCount = 5)
	public void testcase2() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.xpath("//input[@name='forename']")).sendKeys("Smita");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("debasmita98@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("hgvgeb freuyrf hbhhf bvdhb");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		//String acttext = driver.findElement(By.xpath("//strong[contains(@class,'ng-binding')]")).getText();
		
		}
	@Test
	public void testcase3() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Start Shopping »']")).click();
		 WebElement flufybunny = driver.findElement(By.xpath("//h4[.='Fluffy Bunny']/ancestor::li[@class='product ng-scope']/descendant::a[text()='Buy']"));
		flufybunny.click();
		flufybunny.click();
		flufybunny.click();
		WebElement StuffedFrog = driver.findElement(By.xpath("//h4[.='Stuffed Frog']/ancestor::li[@class='product ng-scope']/descendant::a[text()='Buy']"));
		StuffedFrog.click();
		StuffedFrog.click();
		WebElement valentineteddy = driver.findElement(By.xpath("//h4[.='Valentine Bear']/ancestor::li[@class='product ng-scope']/descendant::a[text()='Buy']"));
		valentineteddy.click();
		valentineteddy.click();
		valentineteddy.click();
		valentineteddy.click();
		valentineteddy.click();
		
		driver.quit();
		
		
		
		
		
	}
}
