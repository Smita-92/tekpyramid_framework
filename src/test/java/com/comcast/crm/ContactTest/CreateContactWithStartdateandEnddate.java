package com.comcast.crm.ContactTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContact1Page;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;
import webdriverutility.webdriverutility;

public class CreateContactWithStartdateandEnddate {
	public static void main(String[] args) throws Throwable {

		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		webdriverutility wLib = new webdriverutility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String Ln = eLib.getDataFromExcel("Sheet9", 7, 3) + jLib.getrandomnu();
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
		CreateContact1Page cp = new CreateContact1Page(driver);
		cp.getAddimg().click();

		// enter start date and end date
		String startDate = jLib.getsystemdateYYYYDDMM();
		String endDate = jLib.getrequireddate(28);
		System.out.println(startDate);
		System.out.println(endDate);
		//
		cp.CreateContactWithDate(Ln, startDate, endDate);

		// Headervalidation

		ContactInformationPage cip = new ContactInformationPage(driver);
		String actStartdate = cip.getStartDateVery().getText().trim();
		System.out.println(actStartdate);
		if (actStartdate.equals(startDate)) {
			System.out.println(startDate + " is verified==PASS");
		} else {
			System.out.println(startDate + " is not verified==Fail");
		}

		String actEnddate = cip.getEndDateVery().getText().trim();
		System.out.println(actEnddate);
		if (actEnddate.equals(endDate)) {
			System.out.println(endDate + " is verified==PASS");
		} else {
			System.out.println(endDate + "  is not verified==Fail");
		}
		System.out.println(actStartdate);
		System.out.println(actEnddate);
		hm.logout();
		driver.quit();
	}

}
