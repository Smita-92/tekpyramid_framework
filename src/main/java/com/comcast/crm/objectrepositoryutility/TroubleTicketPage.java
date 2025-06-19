package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	WebDriver driver;
	public TroubleTicketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//add image
	@FindBy(xpath="//img[@alt='Create Ticket...']")
	private WebElement createTroubleLink;
	//title text field
	@FindBy(name ="ticket_title")
	private WebElement titleEdt;
	//save button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement SaveBtn;
	//trouble ticket header message
	@FindBy(className ="dvHeaderText")
	private WebElement Headrtext;


	
	
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getHeadrtext() {
		return Headrtext;
	}


	public WebElement getTitleEdt() {
		return titleEdt;
	}


	public WebElement getCreateTroubleLink() {
		return createTroubleLink;
	}
	
	public void createTroubleTicketTitle(String title) {
		getTitleEdt().sendKeys(title);
		getSaveBtn().click();
	}
	

}
