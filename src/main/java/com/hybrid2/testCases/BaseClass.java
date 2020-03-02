package com.hybrid2.testCases;


import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.hybrid2.utilities.ReadConfig;


public class BaseClass {

ReadConfig readConfig=new ReadConfig();
	
	public String baseUrl=readConfig.getApplicationUrl();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
	
		if(browser.toLowerCase().equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers/firefoxdriver.exe");
		driver=new FirefoxDriver();
		logger=Logger.getLogger("hybrid2");
		PropertyConfigurator.configure("log4j.properties");
		}
		else if(browser.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Drivers/iedriver.exe");
		driver=new InternetExplorerDriver();
		}
		else{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers/edgedriver.exe");
		driver=new EdgeDriver();
		}
	}
	
	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sorce=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshort/"+ tname + ".png");
		FileUtils.copyFile(sorce, target);
		System.out.println("screenshort captured");
		
	}
	
	public static String randomString() {
		String generatedString1=RandomStringUtils.randomAlphabetic(4, 20);
		return (generatedString1);
	}
	
	public static String randomNumbers() {
		
	String randomNumeric=RandomStrtingut
	return(randomNumeric);
		}
}
