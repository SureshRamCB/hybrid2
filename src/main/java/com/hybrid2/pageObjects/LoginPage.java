package com.hybrid2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver idriver;
	
	public LoginPage(WebDriver rdriver){
		idriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "Email")
	WebElement txtusername;
	
	
	@FindBy(id = "Password")
	WebElement txtpassword;
	
	@FindBy(xpath = "//div[@class='buttons']")
	WebElement btnLogin;
	
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement btnlogout;
	
	public void  setUserName(String usrName) {
		txtusername.sendKeys(usrName);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
		
	}
	public void clickLogout() {
		btnlogout.click();
	}
	
	
}
