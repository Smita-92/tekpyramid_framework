package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement addBtn;
		
		@FindBy(name = "productname")
		private WebElement Prodctname;
		
		@FindBy(xpath =  "(//input[@title='Save [Alt+S]'])[1]")
		private WebElement SaveBtn;
		
		@FindBy(xpath =  "//span[@class='lvtHeaderText']")
		private WebElement Headertxt;
		
		@FindBy(name = "productcategory")
		private WebElement Prodctgry;
		
		@FindBy(xpath  = "(//td[@class='dvtCellInfo'])[7]")
		private WebElement ProdctgryText;
		
		public WebElement getProdctgryText() {
			return ProdctgryText;
		}

		public WebElement getHeadertxt() {
			return Headertxt;
		}

		public void setHeadertxt(WebElement headertxt) {
			Headertxt = headertxt;
		}

		public WebElement getProdctgry() {
			return Prodctgry;
		}

		public void setProdctgry(WebElement prodctgry) {
			Prodctgry = prodctgry;
		}

		public WebElement getAddBtn() {
			return addBtn;
		}

		public WebElement getProdctname() {
			return Prodctname;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}
		public void createProductWithProductName(String productname)
		{
			getProdctname().sendKeys(productname);
			getSaveBtn().click();
		}
		
		public void createProductWithCategory(String productname ,String category)
		{
			getProdctname().sendKeys(productname);
			getProdctgry().sendKeys(category);
			getSaveBtn().click();
		}
}


