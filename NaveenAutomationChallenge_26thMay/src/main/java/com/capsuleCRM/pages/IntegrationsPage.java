package com.capsuleCRM.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class IntegrationsPage extends TestBase {


	@FindBy(xpath="//div//h2[text()='Integrations']")
	WebElement integrationsHeader;
	
	@FindAll( {@FindBy(xpath = "//tbody//tr//td[3]")} )
	private List<WebElement> configureButtons;
	
	
	public IntegrationsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickIntegrationsLink();
		HighlightElements.flash(integrationsHeader, driver);

		System.out.println("Integrations Page Header --->>> "+integrationsHeader.getText());
		return integrationsHeader.getText();
	}

	public void clickIntegrationsLink() {
		driver.findElement(By.linkText("Integrations")).click();
	}

    public int getConfigureButtons() {
		for(WebElement button : configureButtons) {
			HighlightElements.flash(button, driver);
		}    
    	return configureButtons.size();
    }

}
