package com.comcast.crm.TroubleTicketTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketPage;

import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class TroubleTicketTitle {

	public static void main(String[] args) throws Throwable {
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String title = eLib.getDataFromExcel("Sheet5", 1, 2);

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
		hm.getTroubleTicketsLink().click();
		TroubleTicketPage ttp = new TroubleTicketPage(driver);
		ttp.getCreateTroubleLink().click();
		ttp.createTroubleTicketTitle(title);
		String text = ttp.getHeadrtext().getText();
		if (text.contains(title)) {

			System.out.println(text + "is verified ==Pass");
		} else {
			System.out.println(text + "is not verified ==FAIL");

		}
		hm.logout();
		driver.quit();
	}

}
