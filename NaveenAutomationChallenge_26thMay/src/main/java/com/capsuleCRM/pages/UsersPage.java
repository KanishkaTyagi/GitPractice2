package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class UsersPage extends TestBase{

	@FindBy(xpath="//div//h2[text()='Users']")
	WebElement usersHeader;
	
	@FindBy(xpath="//a[text()='Add new User']")
	WebElement newUserButton;
	
	@FindBy(xpath="//input[contains(@id,'firstName')]")
	WebElement firstname;
	
	@FindBy(xpath="//input[contains(@id,'lastName')]")
	WebElement lastname;
	
	@FindBy(xpath="//input[contains(@id,'email')]")
	WebElement email;
	
	@FindBy(xpath="//input[contains(@id,'username')]")
	WebElement username;
	
	@FindBy(id="register:save")
	WebElement inviteUserButton;
	
	@FindBy(xpath="//tr[@class='even-row']//td//a")
	WebElement addedUser;
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickUsersLink();
		HighlightElements.flash(usersHeader, driver);

		System.out.println("Users Page Header --->>> "+usersHeader.getText());
		return usersHeader.getText();
	}
	
	public void clickUsersLink() {
		driver.findElement(By.linkText("Users")).click();
	}
	
	public void addNewUser(String firstName, String lastName, String Email, String Username) {
		if(newUserButton.isDisplayed()) {
			newUserButton.click();
			System.out.println("Clicked on New User button");
			Reporter.log("Clicked on New User button");
			
			firstname.sendKeys(firstName);
			lastname.sendKeys(lastName);
			email.sendKeys(Email);
			username.sendKeys(Username);
			inviteUserButton.click();
			
			System.out.println("Successfully created New User");
			Reporter.log("Successfully created New User");
			
		}else {
			System.out.println("Error while Clicking on New User button");
			Reporter.log("Error while Clicking on New User button");
		}
	}
	
	public String getNewUser() {
		System.out.println("The New User Name is -->>> "+addedUser.getText());
		return addedUser.getText();
	}
	
	
}
