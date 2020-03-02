package com.hybrid2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustmerPage {

	public WebDriver idriver;

	public AddCustmerPage(WebDriver rdriver) {
		idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu = By.xpath("//span[text()='Customers']");
	By lnkCustomers_menuItems = By.xpath("(//span[text()='Customers'])[2]");

	By btnAddnew = By.xpath("//a[contains(@href,'/Admin/Customer/Create')]");
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");

	By txtDOB = By.id("DateOfBirth");
	By txtCompanyName = By.id("Company");
//	By chkBox_IsTaxEmpty=By.xpath("//input[@id='IsTaxExempt' and @type='checkbox']");
//	By chkBox_NewsLetter1=By.xpath("//input[@value='1']");
//	By chkBox_newsLetter2=By.xpath("//input[@value='2']");
	By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	By lstitem_Administrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitem_ForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitem_Guests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitm_Registered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitem_Test1 = By.xpath("//li[contains(text(),'Test1')]");
	By lstitem_Vendors = By.xpath("//li[contains(text(),'Vendors')]");
	By drpManager_vendor=By.id("VendorId");
	By chkBox_Active = By.id("Active");

	By txtAdminContent = By.id("AdminComment");

	By btnSave = By.xpath("//button[@name='save']");

	public void cleckOnCustomersMenu() {
		idriver.findElement(lnkCustomers_menu).click();
	}

	public void cleckOnCustomersIteams() {
		idriver.findElement(lnkCustomers_menuItems).click();
	}

	public void cleckOnAddNew() {
		idriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		idriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		idriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) {
		idriver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']")).click();
		idriver.findElement(txtCustomerRoles).click();
		WebElement listIteam;

		switch (role) {
		case "Administrators":
			listIteam = idriver.findElement(lstitem_Administrators);
			break;

		case "Forum Moderators":
			listIteam = idriver.findElement(lstitem_ForumModerators);
			break;

		case "Guests":
			listIteam = idriver.findElement(lstitem_Guests);
			break;

		case "Registered":
			listIteam = idriver.findElement(lstitm_Registered);
			break;

		case "Test1":
			listIteam = idriver.findElement(lstitem_Test1);
			break;

		default:
			listIteam = idriver.findElement(lstitem_Vendors);
			break;
		}
		JavascriptExecutor js = (JavascriptExecutor) idriver;
		js.executeScript("arguments[0].click();", listIteam);

	}

	public void setManagerOfVendor(String value) {

		Select drp = new Select(idriver.findElement(drpManager_vendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			idriver.findElement(rdMaleGender).click();

		} else if (gender.equals("Female")) {
			idriver.findElement(rdFemaleGender).click();
		} else {
			idriver.findElement(rdMaleGender).click();
		}
	}

	public void setFirstName(String fname) {
		idriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		idriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDOB(String dob) {
		idriver.findElement(txtDOB).sendKeys(dob);
	}

	/*
	 * public void ClickOnCheckBoxs() {
	 * if(!(idriver.findElement(chkBox_IsTaxEmpty)).isEnabled()) {
	 * idriver.findElement(chkBox_IsTaxEmpty).click(); }
	 * if(!(idriver.findElement(chkBox_NewsLetter1)).isEnabled()) {
	 * idriver.findElement(chkBox_NewsLetter1).click(); } if
	 * (!(idriver.findElement(chkBox_newsLetter2)).isEnabled()) {
	 * idriver.findElement(chkBox_newsLetter2).click(); }
	 * if(!(idriver.findElement(chkBox_Active)).isEnabled()) {
	 * idriver.findElement(chkBox_Active).click(); }
	 * 
	 * }
	 */
	public void setManagerVendor() {
		
	}
	public void setCompanyName(String compName) {
		idriver.findElement(txtCompanyName).sendKeys(compName);
	}

	public void setAdminContent(String content) {
		idriver.findElement(txtAdminContent).clear();
		idriver.findElement(txtAdminContent).click();
	}

	public void clickSave() {
		idriver.findElement(btnSave);
	}
	
}
