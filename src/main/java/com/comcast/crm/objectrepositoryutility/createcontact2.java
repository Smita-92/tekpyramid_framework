package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createcontact2 {
	WebDriver driver;
	public createcontact2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement getLastName;
	
	
	@FindBy(name="company")
	private WebElement getCompanyName;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgIcon;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	public WebElement getOrgIcon() {
		return orgIcon;
		
	}
	public WebElement getGetLastName() {
		return getLastName;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void toCreateContact(String lastName) {
		getLastName.sendKeys(lastName);
		savebtn.click();
	}
	
	public void toCreateContactwitOrg(String lastName) {
		getLastName.sendKeys(lastName);
		orgIcon.click();
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
	public void toCreateContactWithDate(String lastName, String startDate, String endDate) {
		getLastName.sendKeys(lastName);
		getStartDate().clear();
		getStartDate().sendKeys(startDate);
		getEndDate().clear();
		getEndDate().sendKeys(endDate);
		savebtn.click();
	}

}



