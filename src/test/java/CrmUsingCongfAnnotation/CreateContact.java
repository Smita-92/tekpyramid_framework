package CrmUsingCongfAnnotation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ChildorgPage;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContact1Page;

import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
public class CreateContact extends BaseClass {

	@Test(groups = "smokeTest")
	public void createcontactlnTest() throws Throwable {
		String Ln = eLib.getDataFromExcel("Sheet2", 1, 2) + jLib.getrandomnu();

		HomePage hm = new HomePage(driver);
		hm.getContactLink().click();
		Thread.sleep(2000);
		CreateContact1Page cp = new CreateContact1Page(driver);
		cp.getAddimg().click();
		cp.createContactwithlastname(Ln);
		String text = cp.getLastnametext().getText();
		System.out.println(text);
		Assert.assertTrue(text.contains(Ln));
//		if (text.equals(Ln)) {
//			System.out.println(Ln + " name is verified");
//		} else {
//			System.out.println(Ln + " name is not verified");
//
//		}
	}

	@Test(groups = "smokeTest")
	public void CreateContactWithphno() throws Throwable {

		String orgname = eLib.getDataFromExcel("Sheet9", 7, 2) + jLib.getrandomnu();
		String Ln = eLib.getDataFromExcel("Sheet9", 7, 3) + jLib.getrandomnu();
		String mbleno = eLib.getDataFromExcel("Sheet9", 10, 2);
		HomePage hm = new HomePage(driver);
		hm.getContactLink().click();
		CreateContact1Page cp = new CreateContact1Page(driver);
		cp.getAddimg().click();
		cp.CreateContactWithphno(Ln, orgname, mbleno);

		String text = cp.getLastnametext().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(text.contains(Ln));
//		if (text.contains(Ln)) {
//			System.out.println(Ln + " name is verified");
//		} else {
//			System.out.println(Ln + " name is not verified");
//		}
		String mobno = cp.getMobilenotext().getText();
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(mobno, mbleno);
//		if (mobno.equals(mbleno)) {
//			System.out.println(mbleno + " name is verified");
//		} else {
//			System.out.println(mbleno + " name is not verified");
//		}
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateContactWithStartdateandEnddate() throws Throwable {
		String Ln = eLib.getDataFromExcel("Sheet9", 7, 3) + jLib.getrandomnu();
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
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actStartdate, startDate);
//		if (actStartdate.equals(startDate)) {
//			System.out.println(startDate + " is verified==PASS");
//		} else {
//			System.out.println(startDate + " is not verified==Fail");
//		}

		String actEnddate = cip.getEndDateVery().getText().trim();
		System.out.println(actEnddate);
		
		sf.assertEquals(actEnddate, endDate);
//		if (actEnddate.equals(endDate)) {
//			System.out.println(endDate + " is verified==PASS");
//		} else {
//			System.out.println(endDate + "  is not verified==Fail");
//		}
		sf.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateContactWithorgname() throws Throwable {
		String orgname = eLib.getDataFromExcel("Sheet9", 7, 2) + jLib.getrandomnu();
		String Ln = eLib.getDataFromExcel("Sheet9", 7, 3) + jLib.getrandomnu();
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getCreateOrgLink().click();
		op.createorgWithOrgname(orgname);

		String actOrgname = op.getOrgnameheader().getText();
		System.out.println(actOrgname);
		Assert.assertTrue(actOrgname.contains(orgname));
//		if (actOrgname.contains(orgname)) {
//			System.out.println(orgname + " name is verified");
//		} else {
//			System.out.println(orgname + " name is not verified");
//		}

		hm.getContactLink().click();
		CreateContact1Page cp = new CreateContact1Page(driver);
		cp.getAddimg().click();
		cp.getLastname().sendKeys(Ln);
		ChildorgPage cop = new ChildorgPage(driver);
		cop.getAddorgname().click();

		wbLib.switchtontitle(driver, "module=Accounts");
		cop.getSearchfield().sendKeys(orgname);
		cop.getSearcBtn().click();
		// Dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		wbLib.switchtontitle(driver, "Contacts&action");

		// click on save button
		cp.getSaveBtn().click();

		// verify the header msg expected result
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderMsg().getText();
		Assert.assertTrue(headerInfo.contains(Ln));
		/*if (headerInfo.contains(Ln)) {
			System.out.println(Ln + "is created ==Pass");
		} else {
			System.out.println(Ln + "is not created ==FAIL");
		}*/

		// verify the orgname
		
		String actOrgName = cip.getOrgNameveri().getText().trim();
		Assert.assertTrue(actOrgName.equals(orgname));
//		if (actOrgName.equals(orgname)) {
//			System.out.println(actOrgName + "is created ==Pass");
//		} else {
//			System.out.println(actOrgName + "is not created ==FAIL");
//		}
	}
}
