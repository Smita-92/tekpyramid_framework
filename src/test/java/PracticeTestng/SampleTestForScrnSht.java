package PracticeTestng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.google.common.io.Files;

public class SampleTestForScrnSht extends BaseClass{
	
	@Test
	public void amazontest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//create an object to eventfiring webdriver
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		//use getscreenshot method to get file type screenshot;
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		//store screenshot in local drive
		FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
		
	}
	
public void screenshot() throws IOException {
	
	TakesScreenshot ts=(TakesScreenshot)sdriver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshot/"+"testname"+"png");
	Files.copy(source,dest);
}
}
