package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact1Page {
	WebDriver driver;
	public CreateContact1Page(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
}

	// lastname
	@FindBy(name = "lastname")
	private WebElement Lastname;
	// lastnametextfield
	@FindBy(className = "dvHeaderText")
	private WebElement Lastnametext;
	// mobileno
	@FindBy(id = "mobile")
	private WebElement mobileno;
	// mobilenotextfield
	@FindBy(id = "mouseArea_Mobile")
	private WebElement mobilenotext;

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getMobilenotext() {
		return mobilenotext;
	}

	public WebElement getLastnametext() {
		return Lastnametext;
	}

	

	// orgnametextfield
	@FindBy(name = "account_name")
	private WebElement Orgname;
//phoneno
	@FindBy(id = "mobile")
	private WebElement PhonNo;

	@FindBy(xpath =   "//img[@title='Create Contact...']")
	private WebElement Addimg;
	
	public WebElement getAddimg() {
		return Addimg;
	}

	// savebtn
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;
	
//addornamebtn
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	WebElement addorgname;

	@FindBy(name = "support_start_date")
	private WebElement startDate;

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	public WebElement getAddorgname() {
		return addorgname;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getPhonNo() {
		return PhonNo;
	}





	public void createContactwithlastname(String lastname) {
		getLastname().sendKeys(lastname);
		getSaveBtn().click();
	}

	public void CreateContactWithDate(String lastName, String startDate, String endDate)
	{
		getLastname().sendKeys(lastName);
		getStartDate().clear();
		getStartDate().sendKeys(startDate);
		getEndDate().clear();
		getEndDate().sendKeys(endDate);
		getSaveBtn().click();
	}

	public void CreateContactWithphno(String lastName, String orgname, String mobileNo) {
		getLastname().sendKeys(lastName);
		getOrgname().sendKeys(orgname);
		getPhonNo().sendKeys(mobileNo);
		SaveBtn.click();
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

}
