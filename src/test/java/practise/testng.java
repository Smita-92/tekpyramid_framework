package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");

		//search a product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);


String x="//span[text()='Apple iPhone 16 Pro Max (256 GB) - Desert Titanium']/../../../../div[3]/div[1]/div/div[1]/div/div[1]/a/span/span/span[2]";
		
		

		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println("price:" + price);
			}
	

}