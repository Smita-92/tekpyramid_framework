package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
}



	@FindBy(linkText = "Organizations")
	 private WebElement OrgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText = "Campaigns")
	 private WebElement CampaignLink;
	
	@FindBy(linkText = "Leads")
	 private WebElement LeadLink;
	public WebElement getLeadLink() {
		return LeadLink;
	}



	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLink;
	
	@FindBy(linkText = "More")
	 private WebElement MoreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	 private WebElement adminimg;
	
	@FindBy(linkText ="Sign Out")
	 private WebElement signoutlink;
	
	@FindBy(linkText ="Products")
	 private WebElement Prodctlink;
	
	
	
	public WebElement getProdctlink() {
		return Prodctlink;
	}
	public void navigateToCampaignPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(MoreLink).perform();
		CampaignLink.click();
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgLink() {
		return OrgLink;
	}
	public WebElement getContactLink() {
		return ContactLink;
	}
	public WebElement getCampaignLink() {
		return CampaignLink;
	}
	public WebElement getMoreLink() {
		return MoreLink;
	}
		public void logout() {
			Actions act=new Actions(driver);
			act.moveToElement(adminimg).perform();
			signoutlink.click();
		}
		public WebElement getTroubleTicketsLink() {
			return troubleTicketsLink;
		}
		public WebElement getAdminimg() {
			return adminimg;
		}
		public WebElement getSignoutlink() {
			return signoutlink;
		}
	}
	

