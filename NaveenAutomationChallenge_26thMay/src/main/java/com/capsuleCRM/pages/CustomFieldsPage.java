package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class CustomFieldsPage extends TestBase {

	@FindBy(xpath="//div//h2[text()='Custom Fields']")
	WebElement customFieldsHeader;
	
	public CustomFieldsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickCustomFieldLink();
		HighlightElements.flash(customFieldsHeader, driver);

		System.out.println("Custom Fields Page Header --->>> "+customFieldsHeader.getText());
		return customFieldsHeader.getText();
	}

	public void clickCustomFieldLink() {
		driver.findElement(By.linkText("Custom Fields")).click();
	}
}
