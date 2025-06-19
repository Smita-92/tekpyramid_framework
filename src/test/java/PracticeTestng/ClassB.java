package PracticeTestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ClassB extends BaseClass {
	@Test

	public void method3() {
		System.out.println("method 3");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.quit();
		
	}
	@Test
	public void method4() {
		System.out.println("method 4");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.quit();

}
}
