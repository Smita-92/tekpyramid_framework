package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import databaseutility.databaseutility;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;
import webdriverutility.UtilityClassObject;
import webdriverutility.webdriverutility;

public class BaseClass {

	public databaseutility dbLib = new databaseutility();
	public excelutility eLib = new excelutility();
	public propertyutility fLib = new propertyutility();
	public javautility jLib = new javautility();
	public webdriverutility wbLib = new webdriverutility();
	public static WebDriver sdriver = null;
	public WebDriver driver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(groups = { "smokeTest", "regessionTest" })
	public void configBS() throws SQLException {
		System.out.println(" connect to DB");
		dbLib.getDBConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regessionTest" })
	public void configBC() throws Throwable {// String browser
		System.out.println(" launch the browser");
		// String Browser=browser;
//		String BROWSER =fLib.getDataFromPropertiesFile("Browser");
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("Browser"));
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.SetDriver(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regessionTest" })

	public void configBM() throws Throwable {
		System.out.println(" login");
//        String URL = fLib.getDataFromPropertiesFile("Url");
//		String USERNAME = fLib.getDataFromPropertiesFile("UserName");
//		String BROWSER =fLib.getDataFromPropertiesFile("Browser");
//        String PASSWORD = fLib.getDataFromPropertiesFile("Password");

		 
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("Browser"));
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("UserName"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("Password"));
        LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
		
	}

	@AfterMethod(groups = { "smokeTest", "regessionTest" })
	public void configAM() throws Throwable {
		HomePage hm = new HomePage(driver);
		Thread.sleep(4000);
		hm.logout();
		System.out.println(" logout");

	}

	@AfterClass(groups = { "smokeTest", "regessionTest" })
	public void configAC() {
		System.out.println(" close the browser");
		driver.quit();

	}

	@AfterSuite(groups = { "smokeTest", "regessionTest" })
	public void configAS() {
		try {
			dbLib.closeDBConnection();
			System.out.println(" Close DB,Report Backup....");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
