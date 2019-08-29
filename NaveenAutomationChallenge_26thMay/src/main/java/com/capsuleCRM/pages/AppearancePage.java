package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class AppearancePage extends TestBase {
	
	@FindBy(xpath="//div//h1[text()='Appearance']")
	WebElement appearancetHeader;
	
	@FindBy(xpath="//input[contains(@id,'logoImage')]")
	WebElement attachFile;
	
	
	public AppearancePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickInvoicesLink();
		HighlightElements.flash(appearancetHeader, driver);

		System.out.println("Appearance Page Header --->>> "+appearancetHeader.getText());
		return appearancetHeader.getText();
	}
	
	public void clickInvoicesLink() {
		driver.findElement(By.linkText("Appearance")).click();
	}
	
	public void uploadLogo() {
		attachFile.sendKeys(System.getProperty("user.dir") + "\\LogoImage");
		
		System.out.println("Sucessfully uploaded logo..!!");
	}
}

