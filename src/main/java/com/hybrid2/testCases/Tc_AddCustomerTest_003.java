package com.hybrid2.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid2.pageObjects.AddCustmerPage;
import com.hybrid2.pageObjects.LoginPage;



public class Tc_AddCustomerTest_003 extends BaseClass {

	
	@Test
	public void addNewCustomer() throws Throwable {
		
		driver.get(baseUrl);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided ");
		
		lp.setPassword(password);
		logger.info("password provided");
		
		lp.clickLogin();
		logger.info("clicked on login");
		
		AddCustmerPage addcust=new AddCustmerPage(driver);
		
		addcust.cleckOnCustomersMenu();
		addcust.cleckOnCustomersIteams();
		
		addcust.cleckOnAddNew();
		
		String gmail=randomString()+"@gmail.com";
		addcust.setEmail(gmail);
		
		addcust.setPassword("test123");
		
		addcust.setFirstName("Suresh");
		addcust.setLastName("Babu CB");
		addcust.setGender("Male");
		Thread.sleep(2000);
		addcust.setDOB("27/04/1993");
		addcust.setCompanyName("Satwa QA");
	//	addcust.ClickOnCheckBoxs();
		addcust.setCustomerRoles("Guests");
		addcust.setManagerOfVendor("Vendor 2");
		//addcust.ClickOnCheckBoxs();
		addcust.setAdminContent("thanks everyone");
		addcust.clickSave();
		
		logger.info("validation started...");
		
		String mgs=driver.findElement(By.tagName("body")).getText();
		if(mgs.contains("Add a new customer back to customer list")) {
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed...");
				
			}
		
		
	}
}
