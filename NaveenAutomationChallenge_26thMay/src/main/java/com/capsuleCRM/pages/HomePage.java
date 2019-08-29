package com.capsuleCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[@aria-label='People & Organisations']")
	WebElement peopleIcon;

	@FindBy(xpath="//div[@class='nav-bar-account-details']")
	WebElement accountNameIcon;

	@FindBy(xpath="//a[text()='Account Settings']")
	WebElement accountSettingsLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	} 

	public void validateTitle() {
		Reporter.log("Validating Home Page title...");
		Assert.assertEquals(driver.getTitle(),"Dashboard | Capsule CRM");
	}

	public AddPersonPage clickPeopleIcon() {
		if(peopleIcon.isDisplayed()) {
			HighlightElements.flash(peopleIcon, driver);
			peopleIcon.click();
			System.out.println("Sucessfully clicked on Person Icon");
			Reporter.log("Sucessfully clicked on Person Icon");
		}
		else {
			System.out.println("Error in clicking on People Icon..!!");
			Reporter.log("Error in clicking on People Icon..!!");
		}

		return new AddPersonPage();
	}

	public void clickAccountSettings() {
		if(accountNameIcon.isDisplayed()){
			HighlightElements.flash(accountNameIcon, driver);
			accountNameIcon.click();
			System.out.println("Clicked on Account Name");
			Reporter.log("Clicked on Account Name");

			if(accountSettingsLink.isDisplayed()) {
				HighlightElements.flash(accountSettingsLink, driver);
				accountSettingsLink.click();

				System.out.println("Clicked on Account Settings icon");
				Reporter.log("Clicked on Account Settings icon");
			}else {
				System.out.println("Error while Clicking on Account Settings icon");
				Reporter.log("Error while clicking on Account Settings icon");
			}

		}
		else {
			System.out.println("Error in clicking on Account name icon");
			Reporter.log("Error in clicking on Account name icon");

		}
	}
}
