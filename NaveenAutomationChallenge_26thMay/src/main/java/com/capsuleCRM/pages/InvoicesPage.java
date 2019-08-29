package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class InvoicesPage extends TestBase {

	@FindBy(xpath="//div//header[text()='Invoices']")
	WebElement invoicesHeader;
	
	
	public InvoicesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickInvoicesLink();
		HighlightElements.flash(invoicesHeader, driver);
		System.out.println("Invoices Page Header --->>> "+invoicesHeader.getText());
		return invoicesHeader.getText();
	}
	
	public void clickInvoicesLink() {
		driver.findElement(By.linkText("Invoices")).click();
	}
}
