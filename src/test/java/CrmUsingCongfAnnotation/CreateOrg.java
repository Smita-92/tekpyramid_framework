package CrmUsingCongfAnnotation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

import webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
public class CreateOrg extends BaseClass {

	@Test(groups = "smokeTest")
	public void createorgwithnameTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgname = eLib.getDataFromExcel("org", 1, 2) + jLib.getrandomnu();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getAddorgbtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		op.createorgWithOrgname(orgname);
		
		UtilityClassObject.getTest().log(Status.INFO, orgname + "====>create a new ogr");
		String actOrgname = op.getOrgnameheader().getText();
		System.out.println(actOrgname);
		Assert.assertTrue(actOrgname.contains(orgname));
//		if (actOrgname.contains(orgname)) {
//			System.out.println(orgname + " name is verified");
//		} else {
//			System.out.println(orgname + " name is not verified");
//		}

	}

	@Test(groups = "regessionTest")
	public void CreateOrgWithPhnNo() throws Throwable {

		String orgname = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getrandomnu();
		String phno = eLib.getDataFromExcel("Sheet1", 1, 3) + jLib.getrandomnu();
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getCreateOrgLink().click();
		op.createorgWithOrgname(orgname, phno);

		String actOrgname = op.getOrgnameheader().getText();
		Assert.assertTrue(actOrgname.contains(orgname));
//		if (actOrgname.contains(orgname)) {
//			System.out.println(orgname + " name is verified");
//		} else {
//			System.out.println(orgname + " name is not verified");
//		}
		System.out.println(phno);
		Thread.sleep(2000);

		String actphno = op.getPhnotext().getText();
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actphno, phno);
		sf.assertAll();
//		if (actphno.equals(phno)) {
//			System.out.println(phno + " name is verified");
//		} else {
//			System.out.println(phno + " name is not verified");
//		}

	}

	@Test(groups = "regessionTest")
	public void CreateOrgWithindname() throws Throwable {
		String orgname = eLib.getDataFromExcel("Sheet3", 4, 2) + jLib.getrandomnu();
		String induestry = eLib.getDataFromExcel("Sheet3", 4, 3);
		String type = eLib.getDataFromExcel("Sheet3", 4, 4);
		HomePage hm = new HomePage(driver);
		hm.getOrgLink().click();
		CreateOrganizationsPage op = new CreateOrganizationsPage(driver);
		op.getCreateOrgLink().click();
		op.createContactwithOrgname(orgname, induestry, type);
		String actOrgname = op.getOrgnameheader().getText();
		String actind = op.getHeadermsgind().getText();
		String acttype = op.getHeadermsgtype().getText();
		Assert.assertTrue(actOrgname.contains(orgname));
//		if (actOrgname.contains(orgname)) {
//			System.out.println(orgname + " name is verified");
//		} else {
//			System.out.println(orgname + " name is not verified");
//		}
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actind, induestry);

//		if (actind.equals(induestry)) {
//			System.out.println(induestry + " name is verified");
//		} else {
//			System.out.println(induestry + " name is not verified");
//		}
		
		sf.assertEquals(acttype, type);
		sf.assertAll();
//		if (acttype.equals(type)) {
//			System.out.println(type + " name is verified");
//		} else {
//			System.out.println(type + " name is not verified");
//		}

	}

}
