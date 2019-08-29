package com.capsuleCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(xpath="//a[@class='logo']/img")
	WebElement logo;
	
	@FindBy(xpath="//input[contains(@id,'username')]")
	WebElement userName;
	
	@FindBy(xpath="//input[contains(@id,'password')]")
	WebElement password;
	
	@FindBy(id="login:login")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	} 

	public void validateTitle() {
		Reporter.log("Validating Page title...");
		Assert.assertEquals(driver.getTitle(),"Capsule CRM");
	}
	

	public HomePage Login(String UserName, String Password) {

			userName.clear();
			userName.sendKeys(UserName);
			password.clear();
			password.sendKeys(Password);
			loginButton.click();
			
			System.out.println("Login to Site successfully");
			Reporter.log("Login to Site successfully");
			
			return new HomePage();

	}
}
