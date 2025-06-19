package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationsPage
{
	WebDriver driver;
	public CreateOrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	//organization link
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLink;
	//add image
	@FindBy(xpath  = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addorgbtn;
	//add lastname
	@FindBy(name = "lastname")
	private WebElement Lastname;
	//save button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	//orgname header text
	@FindBy(className =  "dvHeaderText")
	private WebElement  orgnameheader;

	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	

	
	
	public WebElement getAddorgbtn() {
		return addorgbtn;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	public void setLastname(WebElement lastname) {
		Lastname = lastname;
	}

	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDropDown;
	@FindBy(name = "accountname")
	 private WebElement orgNameEdt;

	@FindBy(xpath  = "(//input[@type='text'])[5]")
	 private WebElement phoneEdt;
	@FindBy(name = "industry")
	 private WebElement indEdt;
	
	@FindBy(name = "accounttype")
	 private WebElement typeEdt;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phnotext;
	
	public WebElement getPhnotext() {
		return phnotext;
	}
	public WebElement getTypeEdt() {
		return typeEdt;
	}

	public void setTypeEdt(WebElement typeEdt) {
		this.typeEdt = typeEdt;
	}

	public WebElement getIndEdt() {
		return indEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
		
		@FindBy(name="submit")
		private WebElement searchBtn;
		
		public WebElement getSearchBtn() {
			return searchBtn;
		}
		@FindBy(className =  "dvtCellInfo")
		private WebElement  headermsg;
		public WebElement getHeadermsg() {
			return headermsg;
		}
		@FindBy(id =  "mouseArea_Industry")
		private WebElement  headermsgind;
		
		
		public WebElement getHeadermsgind() {
			return headermsgind;
		}

		public void setHeadermsgind(WebElement headermsgind) {
			this.headermsgind = headermsgind;
		}

		public WebElement getHeadermsgtype() {
			return headermsgtype;
		}

		public void setHeadermsgtype(WebElement headermsgtype) {
			this.headermsgtype = headermsgtype;
		}

		public WebElement getOrgnameheader() {
			return orgnameheader;
		}

		@FindBy(id =  "dtlview_Type")
		private WebElement  headermsgtype;
		

		public WebElement getPhoneEdt1() {
			// TODO Auto-generated method stub
			return null;
		}

		public WebElement getHeadermsg1() {
			// TODO Auto-generated method stub
			return null;
		}

		public void selectind(String indname) {
		Select s=new Select(indEdt);
		s.selectByValue("Apparel");
		
		}
	

		public void selectype(String typename) {
		Select s=new Select(typeEdt);
		s.selectByValue("Analyst");
		
		}
		
		
		public void createorgWithOrgname(String orgname) 
		{
			getOrgNameEdt().sendKeys(orgname);
			getSavebtn().click();
			
		}
		
		public void createorgWithOrgname(String orgname,String phoneno) {
			getOrgNameEdt().sendKeys(orgname);
			getPhoneEdt().sendKeys(phoneno);
			getSavebtn().click();
		}
		
public void createContactwithOrgname(String orgname,String industry,String type) {
	getOrgNameEdt().sendKeys(orgname);
	getIndEdt().sendKeys(industry);
	getTypeEdt().sendKeys(type);
	getSavebtn().click();
	}
}