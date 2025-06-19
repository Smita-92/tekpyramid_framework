package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriverutility.webdriverutility;
/**
 * 
 * 
 * @author Debasmita
 * 
 * contains Login page elements and business Lib like Login()
 *
 */

public class LoginPage extends webdriverutility
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
		 
	}
	@FindBy(name="user_name")
	 private WebElement userEdt;
	
	@FindBy(name="user_password")
	 private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	 private WebElement LoginBtn;
	
	//rule 3-object initialization
	//rule 4-object encapsulation

	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	

	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */

//rule 5-we can provide action
	public void LoginToApp(String url,String username,String password)
	{
		waitforpagetoload(driver);
		maximizethewindow(driver);
		driver.get(url);
		driver.manage().window().maximize();
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
	
	
}

