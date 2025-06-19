package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	WebDriver driver;

	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement addbtn;

	@FindBy(name = "lastname")
	WebElement lastname;

	@FindBy(name = "company")
	WebElement companyname;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement SaveBtn;
	@FindBy(className  = "dvHeaderText")
	WebElement HeaderText;

@FindBy(id="mouseArea_Company")
WebElement companytext;
	
@FindBy(id ="phone")
WebElement mobilenoEdt;
@FindBy(id ="mouseArea_Phone")
WebElement mobilenotext;


	public WebElement getMobilenotext() {
	return mobilenotext;
}



	public WebElement mobilenoEdt() {
	return mobilenoEdt;
}



	public WebDriver getDriver() {
	return driver;
}



public WebElement getCompanytext() {
	return companytext;
}



	public WebElement getcmpnyText() {
		return HeaderText;
	}

	

	public WebElement getHeaderText() {
		return HeaderText;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCmpnyText() {
		// TODO Auto-generated method stub
		return null;
	}
	public void CreateLead(String lastname,String Companyname) {
		getLastname().sendKeys(lastname);
		getCompanyname().sendKeys(Companyname);
		getSaveBtn().click();
		
	}
	public void CreateLeadwithphon(String lastname,String Companyname,String phoneno) {
		getLastname().sendKeys(lastname);
		getCompanyname().sendKeys(Companyname);
		getMobilenoEdt().sendKeys(phoneno);
		getSaveBtn().click();
		
	}



	public WebElement getMobilenoEdt() {
		return mobilenoEdt;
	}

}
