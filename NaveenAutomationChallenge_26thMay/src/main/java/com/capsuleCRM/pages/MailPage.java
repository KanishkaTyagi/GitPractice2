package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class MailPage extends TestBase {

	@FindBy(xpath="//div//h2[text()='Mail Drop Box']")
	WebElement mailDropHeader;
	
	public MailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickMailDropLink();
		HighlightElements.flash(mailDropHeader, driver);

		System.out.println("Mail Drop Page Header --->>> " + mailDropHeader.getText());
		return mailDropHeader.getText();
	}

	public void clickMailDropLink() {
		driver.findElement(By.linkText("Mail Drop Box")).click();
	}
}
