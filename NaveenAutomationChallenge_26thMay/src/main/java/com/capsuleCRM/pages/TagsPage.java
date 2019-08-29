package com.capsuleCRM.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;
import com.capsuleCRM.utility.Utility;

public class TagsPage extends TestBase {

	@FindBy(xpath="//div//h2[text()='Tags and DataTags']")
	WebElement tagHeader;
	
	@FindBy(xpath="//a[text()='Add new Tag']")
	WebElement newTagButton;
	
	@FindBy(xpath="//input[contains(@id,'tagName')]")
	WebElement name;
	
	@FindBy(xpath="//a[text()='add more detail']")
	WebElement moreDetailLink;
	
	@FindBy(xpath="//input[contains(@name,'tagDetail')]")
	WebElement detail;
	
	@FindBy(id="j_id177:j_id210")
	WebElement saveButton;
	
	@FindAll( {@FindBy(xpath = "//tbody//tr//td[1]//a")} )
	private List<WebElement> tagName;
	
	public TagsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickTagsLink();
		HighlightElements.flash(tagHeader, driver);

		System.out.println("Tags Page Header --->>> "+tagHeader.getText());
		return tagHeader.getText();
	}

	public void clickTagsLink() {
		driver.findElement(By.linkText("Tags")).click();
	}

	public void addNewTag(String Name, String Detail) throws InterruptedException {
		if(newTagButton.isDisplayed()) {
			newTagButton.click();
			System.out.println("Clicked on Add New Tag button");
			Reporter.log("Clicked on Add New Tag button");

			Utility.waitForElement(name, driver);
			name.sendKeys(Name);
			moreDetailLink.click();
			detail.sendKeys(Detail);
			saveButton.click();

			System.out.println("Successfully created New Tag");
			Reporter.log("Successfully created New Tag");
			Thread.sleep(5000);

		}else {
			System.out.println("Error while Clicking on New Tag button");
			Reporter.log("Error while Clicking on New Tag button");
		}
	}

	public ArrayList<String> getAllTagsNames() {

		ArrayList<String> alltags=new ArrayList<String>();
		if(tagName!=null || !tagName.isEmpty()) {
			for(WebElement tag : tagName) {
				alltags.add(tag.getText());
			}
			
		}
		return alltags;

	}
}
