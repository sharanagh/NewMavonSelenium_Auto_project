package com.selenium.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.base.Base;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;

public class LoginTest extends Base  {
Properties prop;
WebDriver driver;

	
@BeforeMethod
public void openBrowser() throws IOException {
	prop = readingDataFromProp();
	driver= selectBrowser(prop.getProperty("browserName"),prop.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAccount();
		homePage.clickOnLogin();
	}

@DataProvider(name = "SupplyTestData")
public Object[][] readDataFromExcl() throws IOException {
	Object[][] data = readTestDataFromexcel("loginData");
	return data;
}

@Test(dataProvider = "SupplyTestData")
public void validCred(String username, String password) {
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterCredentials(username, password);
	
}

@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
