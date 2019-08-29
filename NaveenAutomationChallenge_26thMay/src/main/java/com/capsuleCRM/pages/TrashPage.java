package com.capsuleCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class TrashPage extends TestBase{

	@FindBy(xpath="//div//h2[text()='Trash']")
	WebElement trashHeader;
	
	public TrashPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickTrashLink();
		HighlightElements.flash(trashHeader, driver);

		System.out.println("Trash Page Header --->>> "+ trashHeader.getText());
		return trashHeader.getText();
	}

	public void clickTrashLink() {
		driver.findElement(By.linkText("Trash")).click();
	}
}
