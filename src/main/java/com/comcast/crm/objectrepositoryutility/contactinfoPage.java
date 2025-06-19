package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactinfoPage {
	
	WebDriver driver;
	public contactinfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}

	@FindBy(id="mouseArea_Last Name")
	private WebElement LastName;
	
	public WebElement getLastName() {
		return LastName;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameveri;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getOrgNameveri() {
		return orgNameveri;
	}
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement startDateVery;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement endDateVery;
	public WebElement getStartDateVery() {
		return startDateVery;
	}

	public WebElement getEndDateVery() {
		return endDateVery;
	}

}


