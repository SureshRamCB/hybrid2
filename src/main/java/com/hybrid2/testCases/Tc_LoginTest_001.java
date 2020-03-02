package com.hybrid2.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid2.pageObjects.LoginPage;



public class Tc_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void LoginTest() throws Throwable {
		driver.get(baseUrl);
		logger.info("URL is opened...");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user Provided");
		
		lp.setPassword(password);
		logger.info("password Provided");
		
		lp.clickLogin();
		logger.info("login is clicked");
		Thread.sleep(5000);
		if (driver.getPageSource().contains("Logout")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed");
		}else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("login is failed");
		}
	}
	

}
