package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;

public class LoginPage  {
WebDriver driver;
Properties prop;

public LoginPage(WebDriver driver){
	this.driver = driver;
}

public void enterCredentials(String username, String password) {
	
	driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
}

public void verifyLoginSuccessOrNot() {
	String expectedText = "Edit your account information";
	WebElement text = driver.findElement(By.xpath("//a[text()='Edit your account information']"));
	String actualText = text.getText();
	org.testng.Assert.assertTrue(expectedText.contains(actualText), "test result failed");
}

}
