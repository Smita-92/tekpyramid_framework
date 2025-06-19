package CrmUsingCongfAnnotation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketPage;
@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
@Test(groups = "regressionTest")

public class CreateTroubleTickt extends BaseClass {
	public void troubleticket() throws Throwable {
		String title = eLib.getDataFromExcel("Sheet5", 1, 2);
		HomePage hm = new HomePage(driver);
		hm.getTroubleTicketsLink().click();
		TroubleTicketPage ttp = new TroubleTicketPage(driver);
		ttp.getCreateTroubleLink().click();
		ttp.createTroubleTicketTitle(title);
		String text = ttp.getHeadrtext().getText();
		Assert.assertTrue(text.contains(title));
		/*if (text.equals(title)) {

			System.out.println(text + "is verified ==Pass");
		} else {
			System.out.println(text + "is not verified ==FAIL");

		}*/

	}

}
