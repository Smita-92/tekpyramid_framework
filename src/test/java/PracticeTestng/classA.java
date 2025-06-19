package PracticeTestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class classA extends BaseClass {
	@Test
public void method1() {
	System.out.println("method 1");
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.quit();
	
}
@Test
public void method2() {
	System.out.println("method 2");
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.quit();


}}
