package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildorgPage {
	WebDriver driver;

	public ChildorgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement addorgname;

	public WebElement getAddorgname() {
		return addorgname;
	}

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchfield;

	@FindBy(name = "search")
	private WebElement searcBtn;

	public void selectOrg(String orgname) {
		searchfield.sendKeys(orgname);
		searcBtn.click();
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearcBtn() {
		return searcBtn;
	}
}
