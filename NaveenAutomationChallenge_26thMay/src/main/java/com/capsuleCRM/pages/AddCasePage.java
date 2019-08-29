package com.capsuleCRM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class AddCasePage extends TestBase {

	@FindBy(xpath="//a[@aria-label='Cases']")
	WebElement casesLink;

	@FindBy(xpath="//a[text()='Add Case']")
	WebElement addCaseButton;

	@FindBy(id="partySearch")
	WebElement caseRelated;

	@FindBy(xpath="//input[contains(@id,'name')]")
	WebElement name;

	@FindBy(xpath="//textarea[contains(@id,'description')]")
	WebElement description;

	@FindBy(xpath="//input[contains(@id,'tag')]")
	WebElement tags;

	@FindBy(xpath="//input[@value='Add tag']")
	WebElement tagsButton;

	@FindBy(xpath="//input[@value='Save']")
	WebElement saveButton;

	@FindBy(xpath="//span[@class='tooltipper party-tooltipper ember-view']//a")
	WebElement nameLabel;
	
	@FindBy(xpath="//span[@class='kase-summary-status-open']")
	WebElement status;
	
	public AddCasePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickCaseIcon() {
		if(casesLink.isDisplayed()) {
			HighlightElements.flash(casesLink, driver);
			casesLink.click();
			System.out.println("Cases link clicked successfully");
		}
		else {
			System.out.println("Error in clicking on Cases link");
		}
	}

	public void clickAddCase() {
		if(addCaseButton.isDisplayed()) {
			HighlightElements.flash(addCaseButton, driver);
			addCaseButton.click();
			System.out.println("Add Cases Button clicked successfully");
		}
		else {
			System.out.println("Error in clicking on Add cases button");
		}
	}

	public void createCases(String CasesRelated, String Name, String Description, String Tags) throws InterruptedException {
		caseRelated.sendKeys(CasesRelated);
		Thread.sleep(2000);

		caseRelated.sendKeys(Keys.DOWN);
		caseRelated.sendKeys(Keys.RETURN);

		name.sendKeys(Name);
		description.sendKeys(Description);
		tags.sendKeys(Tags);

		tagsButton.click();
		saveButton.click();
		System.out.println("Created Case sucessfully..!!");
		Reporter.log("Created Case sucessfully..!!");

	}
	
	public String getPersonName() {
		System.out.println("New Case is created for -->> "+nameLabel.getText());
		return nameLabel.getText();
	}
	
	public String getStatus() {
		System.out.println("The Status of the Case is -->> "+status.getText());
		return status.getText();
	}



}
