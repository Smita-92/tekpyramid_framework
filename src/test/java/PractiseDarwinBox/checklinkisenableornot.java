package PractiseDarwinBox;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checklinkisenableornot {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		Thread.sleep(10000);
		List<WebElement> AllLinks = driver.findElements(By.tagName("//a"));
		for(WebElement link:AllLinks) {
			int count=0;
			if(link.isEnabled()) {
				count++;
			String clickable = link.getAttribute("href");
			System.out.println(clickable+"======="+count);
			
			
			}
//			try {
//			int count=0;		
//			URL url=new URL(links);
//			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
//			int statuscode=conn.getResponseCode();
//			if(statuscode >=200 && statuscode <=299) {
//				count++;
//				System.out.println(links+"=>"+statuscode+"=======" +count);
//
//			}}catch(Exception e) {
//				
//			}
		

	}}	}		



