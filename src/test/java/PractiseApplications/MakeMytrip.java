package PractiseApplications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMytrip {
	
	@Test
	public void Makemytrip() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.linkText("//span[text()='Departure']")).click();
	
		
	}

}
