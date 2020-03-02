package com.hybrid2.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid2.pageObjects.LoginPage;
import com.hybrid2.utilities.XLUtils;



public class Tc_LoginDDT_002 extends BaseClass {

	
	@Test(dataProvider ="Logindata")
	public void LoginTest(String usrName,String pwd) throws Throwable {
		driver.get(baseUrl);
		logger.info("URL is opened...");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(usrName);
		logger.info("user Provided");
		
		lp.setPassword(pwd);
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
	
	@DataProvider(name="Logindata")
	public String [][] getData() throws Throwable{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/hybrid1/testData/DataDriven.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getCellCount(path, "Sheet1", rowNum);
		String loginData[][]=new String[rowNum][colCount];
		for(int i=1;i<rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
		
	}
}
