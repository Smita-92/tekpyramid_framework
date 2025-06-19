package com.comcast.crm.LeadsTest;

import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class CreateLeads {

	public static void main(String[] args) throws Throwable {
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String lastname = eLib.getDataFromExcel("Sheet8", 1, 2) + jLib.getrandomnu();
		String company = eLib.getDataFromExcel("Sheet8", 1, 3);
		jLib.getrandomnu();
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
		hm.getLeadLink().click();
		LeadPage lead = new LeadPage(driver);
		lead.getAddbtn().click();
		lead.CreateLead(lastname, company);
		String text = lead.getHeaderText().getText();
		String companytext = lead.getCompanytext().getText();
		System.out.println(companytext);

		if (text.contains(lastname)) {
			System.out.println(lastname + " name is verified");
		} else {
			System.out.println(lastname + " name is not verified");
		}
		if (companytext.contains(company)) {
			System.out.println(company + " name is verified");
		} else {
			System.out.println(company + " name is not verified");
		}

		hm.logout();
		driver.quit();

	}

}
