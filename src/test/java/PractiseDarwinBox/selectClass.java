package PractiseDarwinBox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class selectClass {
	@Test
	public void SelectClass() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		WebElement fashiondropdown = driver.findElement(By.xpath("//span[text()='Fashion']"));
		Actions act=new Actions(driver);
		act.moveToElement(fashiondropdown).click();
		driver.findElement(By.xpath("//a[text()='Men Footwear']")).click();
	}

}
