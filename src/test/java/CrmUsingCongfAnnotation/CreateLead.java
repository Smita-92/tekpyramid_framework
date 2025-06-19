package CrmUsingCongfAnnotation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
@Test(groups = "smokeTest")
public class CreateLead extends BaseClass {
	
	public void creatreLead() throws Throwable {
		String lastname = eLib.getDataFromExcel("Sheet8", 1, 2) + jLib.getrandomnu();
		String company = eLib.getDataFromExcel("Sheet8", 1, 3)+ jLib.getrandomnu();
		System.out.println(company);
		
		HomePage hm = new HomePage(driver);
		hm.getLeadLink().click();
		LeadPage lead = new LeadPage(driver);
		lead.getAddbtn().click();
		lead.CreateLead(lastname, company);
		String text = lead.getHeaderText().getText();
		String companytext = lead.getCompanytext().getText();
		System.out.println(companytext);
		Assert.assertTrue(text.trim().contains(lastname));

		/*if (text.contains(lastname)) {
			System.out.println(lastname + " name is verified");
		} else {
			System.out.println(lastname + " name is not verified");
		}*/
		Assert.assertEquals(companytext.trim(), company);
		/*if (companytext.equals(company)) {
			System.out.println(company + " name is verified");
		} else {
			System.out.println(company + " name is not verified");
		}*/


		
	}
	@Test(groups = "regressionTest")

	public void createLeadwithphno() throws Throwable {
		String lastname = eLib.getDataFromExcel("Sheet8", 1, 2) + jLib.getrandomnu();
		String company = eLib.getDataFromExcel("Sheet8", 1, 3) + jLib.getrandomnu();
		String phoneno = eLib.getDataFromExcel("Sheet8", 1, 4) + jLib.getrandomnu();
		HomePage hm = new HomePage(driver);
		hm.getLeadLink().click();
		LeadPage lead = new LeadPage(driver);
		lead.getAddbtn().click();
		lead.CreateLeadwithphon(lastname, company, phoneno);
		String text = lead.getHeaderText().getText();
		String companytext = lead.getCompanytext().getText();
		String mbnotext = lead.getMobilenotext().getText();
		Assert.assertTrue(text.trim().contains(lastname));
//		if (text.equals(lastname)) {
//			System.out.println(lastname + " name is verified");
//		} else {
//			System.out.println(lastname + " name is not verified");
//		}
		Assert.assertEquals(companytext.trim(), company);	
//		if (companytext.equals(company)) {
//			System.out.println(company + " name is verified");
//		} else {
//			System.out.println(company + " name is not verified");
//		}
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(mbnotext, phoneno);
		sf.assertAll();
//		if (mbnotext.equals(phoneno)) {
//			System.out.println(phoneno + " name is verified");
//		} else {
//			System.out.println(phoneno + " name is not verified");
//		}


	}

	}


