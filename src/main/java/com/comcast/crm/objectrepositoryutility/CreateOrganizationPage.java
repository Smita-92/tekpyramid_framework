package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
}

	@FindBy(name = "accountname")
	 private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
public void createOrg(String Orgname) {
orgNameEdt.sendKeys(Orgname);
Savebtn.click();
}
//public void toCreateNewOrg(String orgName, String industry,String type) {
//	orgNameEdt.sendKeys(orgName);
//	Select sel=new Select(industryEdit);
//	sel.selectByVisibleText(industry);
//	Select sel1=new Select(typeEdit);
//	sel.selectByVisibleText(type);
//	savebtn.click();
//}
//
//public void toCreateNewOrg(String orgName, String phoneNum) {
//	orgNameEdt.sendKeys(orgName);
//	phoneNofild.sendKeys(phoneNum);
//	savebtn.click();



	
}

