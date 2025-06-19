package PracticeTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelutility.excelutility;

public class AmazonaddaproductTest {
	@Test(dataProvider = "getData")
	public void productinfoTest(String brandname,String product)
	{
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.amazon.in/");
//search a product
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone ",Keys.ENTER);
//capture product info
String x="//span[text()='Apple iPhone 16 Pro Max (256 GB) - Desert Titanium']/../../../../div[3]/div[1]/div/div[1]/div/div[1]/a/span/span/span[2]";
String price=driver.findElement(By.xpath(x)).getText();
System.out.println("price:" + price);
System.out.println("brandname:"+ brandname +"product:"+ product);
//driver.quit();
	}
	
	@DataProvider
	public Object[] [] getData() throws Throwable{
	excelutility  eLib=new excelutility();
	int rowcount = eLib.getRowcount("iphone");
	
		Object [] [] objarr=new Object[rowcount] [2];
		for(int i=0;i<rowcount;i++) {
		objarr[i] [0]=eLib.getDataFromExcel("iphone", i+1, 0);
		objarr[i] [1]=eLib.getDataFromExcel("iphone", i+1, 1);
//		objarr[0] [1]="Apple iPhone 16 Pro Max (256 GB) - Desert Titanium";
//		
//		objarr[1] [0]="iphone";
//		objarr[1] [1]="Apple iPhone 13 (128GB) - Starlight";
//		
//		objarr[2] [0]="iphone";
//		objarr[2] [1]="Apple iPhone 15 (128 GB) - Black";
//		
		

	}
		return objarr;
		
	}
}

