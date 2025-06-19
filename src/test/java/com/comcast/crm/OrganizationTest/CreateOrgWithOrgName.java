package com.comcast.crm.OrganizationTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class CreateOrgWithOrgName {

	public CreateOrgWithOrgName(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String orgname = eLib.getDataFromExcel("org", 1, 2) + jLib.getrandomnu();
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
		hm.getOrgLink().click();
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getAddorgbtn().click();
		op.createorgWithOrgname(orgname);
		String actOrgname = op.getOrgnameheader().getText();
		System.out.println(actOrgname);
		if (actOrgname.contains(orgname)) {
			System.out.println(orgname + " name is verified");
		} else {
			System.out.println(orgname + " name is not verified");
		}
		hm.logout();
		driver.quit();

	}

}
