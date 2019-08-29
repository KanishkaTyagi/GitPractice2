package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class ExportPage extends TestBase {

	@FindBy(xpath="//div//h1[text()='Export']")
	WebElement exportHeader;
	
	
	public ExportPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickInvoicesLink();
		HighlightElements.flash(exportHeader, driver);

		System.out.println("Export Page Header --->>> "+exportHeader.getText());
		return exportHeader.getText();
	}
	
	public void clickInvoicesLink() {
		driver.findElement(By.linkText("Export")).click();
	}
}
