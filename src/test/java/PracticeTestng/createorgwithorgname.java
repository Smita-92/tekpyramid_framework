package PracticeTestng;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import excelutility.excelutility;
import propertyutility.propertyutility;

public class createorgwithorgname {
	excelutility  eLib=new excelutility();
	propertyutility flib = new propertyutility();

	@Test(dataProvider = "craeteorgwithorgnameTest")
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
OrganizationInfoPage oinfo=new  OrganizationInfoPage(driver);
String actOrgname = oinfo.getHeadermsg().getText();
if(actOrgname.contains(orgname)) {
		System.out.println(orgname+" name is verified");
	}
	else {
		System.out.println(orgname+" name is not verified");
	}
	hm.logout();
  driver.quit();
	}}
