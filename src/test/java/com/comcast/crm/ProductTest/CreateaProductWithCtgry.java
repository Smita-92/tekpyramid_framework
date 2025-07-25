package com.comcast.crm.ProductTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.objectrepositoryutility.CreateProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class CreateaProductWithCtgry {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		propertyutility flib = new propertyutility();
		excelutility eLib = new excelutility();
		javautility jLib = new javautility();
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL = flib.getDataFromPropertiesFile("Url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String PASSWORD = flib.getDataFromPropertiesFile("Password");
		String prdctname = eLib.getDataFromExcel("Sheet4", 1, 2) + jLib.getrandomnu();
		String ctgry = eLib.getDataFromExcel("Sheet4", 1, 3);
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
		hm.getProdctlink().click();
		CreateProductPage product = new CreateProductPage(driver);
		product.getAddBtn().click();
		product.createProductWithCategory(prdctname, ctgry);
		String text = product.getHeadertxt().getText();
		String prdcttext = product.getProdctgryText().getText();
		if (text.contains(prdctname)) {
			System.out.println(prdctname + " name is verified");
		} else {
			System.out.println(prdctname + " name is not verified");
		}
		if (prdcttext.contains(ctgry)) {
			System.out.println(ctgry + " name is verified");
		} else {
			System.out.println(ctgry + " name is not verified");
		}
		hm.logout();
		driver.quit();
	}

}
