package com.capsuleCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class AccountPage extends TestBase {

	@FindBy(xpath="//div//h1[text()='Account']")
	WebElement accountHeader;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		HighlightElements.flash(accountHeader, driver);
		System.out.println("Account Page Header --->>> "+accountHeader.getText());
		return accountHeader.getText();
	}
	
	
}
