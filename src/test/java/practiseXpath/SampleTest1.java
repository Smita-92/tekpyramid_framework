package practiseXpath;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest1 {
	@Test
	
	public void Testcase1() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.rbi.org.in/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for(WebElement eachlink:allLinks) {
			String link=eachlink.getAttribute("href");
			try {
				URL url=new URL(link);
				HttpURLConnection con=(HttpURLConnection) url.openConnection();
				int statuscode=con.getResponseCode();
				if(statuscode >=400) {
					System.out.println(link+"=>"+statuscode);
				}
				
			}catch(Exception e) {
			
		}
	}
	
		driver.quit();
	}
	
	@Test
	
	public void brokenimages() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.rbi.org.in/");
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		System.out.println(allimages.size());
		for(WebElement img:allimages) {
			String image=img.getAttribute("href");
			try {
				URL url=new URL(image);
				HttpURLConnection con=(HttpURLConnection) url.openConnection();
				int statuscode=con.getResponseCode();
				if(statuscode>=400) {
					System.out.println(image+"=>"+statuscode);
				}
			}catch(Exception e) {
				
			}
			
			
		}	
	}
	
}
