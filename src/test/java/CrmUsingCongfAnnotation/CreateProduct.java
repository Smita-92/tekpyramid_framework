package CrmUsingCongfAnnotation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreateProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(com.comcast.crm.Listner_utility.ListnerImplementationClass.class)
@Test(groups = "regressionTest")
public class CreateProduct extends BaseClass {
	public void createProductwithlastname() throws Throwable {
		String prdctname =eLib.getDataFromExcel("Sheet7", 1, 2) + jLib.getrandomnu();
		HomePage hm = new HomePage(driver);
		hm.getProdctlink().click();
		CreateProductPage product = new CreateProductPage(driver);
		product.getAddBtn().click();
		product.createProductWithProductName(prdctname);

		String text = product.getHeadertxt().getText();
		System.out.println(text);
		Assert.assertTrue(text.contains(prdctname));
//		if (text.contains(prdctname)) {
//			System.out.println(prdctname + " name is verified");
//		} else {
//			System.out.println(prdctname + " name is not verified");
//		}

			}

	
	@Test(groups = "smokeTest")
	
	public void createProductwithctgry() throws Throwable {
		String prdctname =eLib.getDataFromExcel("Sheet4", 1, 2) + jLib.getrandomnu();
		String ctgry=eLib.getDataFromExcel("Sheet4", 1, 3);
		HomePage hm = new HomePage(driver);
		hm.getProdctlink().click();
		CreateProductPage product = new CreateProductPage(driver);
		product.getAddBtn().click();
		product.createProductWithCategory(prdctname, ctgry);
		String text = product.getHeadertxt().getText();
		String prdcttext = product.getProdctgryText().getText();
		Assert.assertTrue(text.contains(prdctname));
//		if (text.equals(prdctname)) {
//			System.out.println(prdctname + " name is verified");
//		} else {
//			System.out.println(prdctname + " name is not verified");
//		}
		
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(prdcttext, ctgry);
		sf.assertAll();
//		if (prdcttext.equals(ctgry)) {
//			System.out.println(ctgry + " name is verified");
//		} else {
//			System.out.println(ctgry + " name is not verified");
//		}

			}
	}
		
	
	


