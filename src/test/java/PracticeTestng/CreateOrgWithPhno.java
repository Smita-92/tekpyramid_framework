package PracticeTestng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import excelutility.excelutility;
import javautility.javautility;
import propertyutility.propertyutility;

public class CreateOrgWithPhno {
	
	excelutility  eLib=new excelutility();
	propertyutility flib = new propertyutility();
	javautility jLib = new javautility();

	@Test(dataProvider = "craeteorgwithphnoTest")
	public void productinfoTest(String orgname) throws Throwable
	{
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
String BROWSER = flib.getDataFromPropertiesFile("Browser");
String URL = flib.getDataFromPropertiesFile("Url");
String USERNAME = flib.getDataFromPropertiesFile("UserName");
String PASSWORD = flib.getDataFromPropertiesFile("Password");
driver.get(URL);
LoginPage lp=new LoginPage(driver);
lp.LoginToApp(USERNAME, PASSWORD, URL);
HomePage hm=new HomePage(driver);
hm.getOrgLink();
CreateOrganizationsPage op=new CreateOrganizationsPage(driver);
op.getCreateOrgLink().click();
op.getOrgNameEdt().sendKeys(orgname);

op.getSavebtn().click();

}}
