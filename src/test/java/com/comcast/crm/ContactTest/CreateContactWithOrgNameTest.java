package com.comcast.crm.ContactTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.ChildorgPage;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContact1Page;
import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;
import webdriverutility.webdriverutility;

public class CreateContactWithOrgNameTest {
	public static void main(String[] args) throws Throwable {
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		webdriverutility wLib = new webdriverutility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String orgname = eLib.getDataFromExcel("Sheet9", 7, 2) + jLib.getrandomnu();
		String Ln = eLib.getDataFromExcel("Sheet9", 7, 3) + jLib.getrandomnu();
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

		// create org
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getCreateOrgLink().click();
		op.createorgWithOrgname(orgname);

		String actOrgname = op.getOrgnameheader().getText();
		System.out.println(actOrgname);
		if (actOrgname.contains(orgname)) {
			System.out.println(orgname + " name is verified");
		} else {
			System.out.println(orgname + " name is not verified");
		}

		hm.getContactLink().click();
		CreateContact1Page cp = new CreateContact1Page(driver);
		cp.getAddimg().click();
		cp.getLastname().sendKeys(Ln);
		ChildorgPage cop = new ChildorgPage(driver);
		cop.getAddorgname().click();

		wLib.switchtontitle(driver, "module=Accounts");
		cop.getSearchfield().sendKeys(orgname);
		cop.getSearcBtn().click();
		// Dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		wLib.switchtontitle(driver, "Contacts&action");

		// click on save button
		cp.getSaveBtn().click();

		// verify the header msg expected result
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderMsg().getText();
		if (headerInfo.contains(Ln)) {
			System.out.println(Ln + "is created ==Pass");
		} else {
			System.out.println(Ln + "is not created ==FAIL");
		}

		// verify the orgname
		String actOrgName = cip.getOrgNameveri().getText().trim();
		if (actOrgName.equals(orgname)) {
			System.out.println(actOrgName + "is created ==Pass");
		} else 
		{
			System.out.println(actOrgName + "is not created ==FAIL");
		}
		Thread.sleep(1000);
		hm.logout();
		driver.quit();

	}

}
