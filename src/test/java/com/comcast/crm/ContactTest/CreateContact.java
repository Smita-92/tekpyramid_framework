package com.comcast.crm.ContactTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreateContact1Page;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String Ln = eLib.getDataFromExcel("Sheet2", 1, 2);
		// + jLib.getrandomnu();
		WebDriver driver = null;
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
		HomePage hm = new HomePage(driver);
		hm.getContactLink().click();
		Thread.sleep(2000);
		CreateContact1Page cp=new CreateContact1Page(driver);
		cp.getAddimg().click();
		cp.createContactwithlastname(Ln);
		String text = cp.getLastnametext().getText();
		if (text.contains(Ln)) 
		{
			System.out.println(Ln + " name is verified");
		} else {
			System.out.println(Ln + " name is not verified");

		}
		hm.logout();
		driver.quit();
	}

}
