package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
	}	 
	@FindBy(className =  "dvHeaderText")
	private WebElement  headermsg;
	@FindBy(id="dtlview_Phone")
	private WebElement phnotext;
	@FindBy(name = "lastname")
	private WebElement Lastname;
	@FindBy(name = "accountname")
	 private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
		}

public WebElement getHeadermsg() {
		return headermsg;
	}



public WebElement getPhnotext() {
	return phnotext;
}
public void createContactwithOrgname(String lastname,String orgname) {
	getLastname().sendKeys(lastname);
	getOrgNameEdt().sendKeys(orgname);
	savebtn.click();



	}
public WebElement getSavebtn() {
	return savebtn;
}

private WebElement getLastname() {
	// TODO Auto-generated method stub
	return null;
}}


