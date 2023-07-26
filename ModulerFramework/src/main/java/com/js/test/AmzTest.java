package com.js.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.js.pages.AmzHomePage;

import commonLib.CommonDriver;

public class AmzTest {
	CommonDriver commonDriver;
	AmzHomePage amzHomePage;
	String url = "https://www.amazon.in";

	WebDriver driver;

	@BeforeClass
	public void invokeBrowser() throws Exception {
		
		commonDriver = new CommonDriver("chrome");
		commonDriver.setPageloadTimeout(60);
		commonDriver.setElementDetectionTimeout(10);
		
		commonDriver.navigateToFirstURL(url);
		driver = commonDriver.getDriver();
		amzHomePage = new AmzHomePage(driver);

	}
	
	@Test
	public void searchProduct() throws Exception{
		amzHomePage.searchProduct("iPhone", "Electronics");
	}
	
	@AfterClass
	public void closeBrowser() throws Exception{
//		commonDriver.closeAllBrowser();
	}

}
