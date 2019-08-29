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

public class OpportunitiesPage extends TestBase {

	@FindBy(xpath="//div//header[text()='Opportunities']")
	WebElement opportunitiesHeader;
	
	@FindBy(xpath="//button[text()='Add new Milestone']")
	WebElement newMilestoneButton;
	
	@FindBy(xpath="//input[contains(@class,'name')]")
	WebElement name;
	
	@FindBy(xpath="//textarea[contains(@class,'description')]")
	WebElement description;
	
	@FindBy(xpath="//input[contains(@class,'probability')]")
	WebElement probability;
	
	@FindBy(xpath="//input[contains(@class,'stale')]")
	WebElement daysuntilstale;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	@FindAll( {@FindBy(xpath = "//button[@class='hyperlink-button milestone-item-edit']")} )
	private List<WebElement> milestoneNames;
	
	public OpportunitiesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickOppurtunitiesLink();
		HighlightElements.flash(opportunitiesHeader, driver);

		System.out.println("Opportunities Page Header --->>> "+opportunitiesHeader.getText());
		return opportunitiesHeader.getText();
	}
	
	public void clickOppurtunitiesLink() {
		driver.findElement(By.linkText("Opportunities")).click();
	}
	
	public void addNewMilestone(String Name, String Description, String Probability, String DaysUntilStale) throws InterruptedException {
		if(newMilestoneButton.isDisplayed()) {
			newMilestoneButton.click();
			System.out.println("Clicked on New Milestone button");
			Reporter.log("Clicked on New Milestone button");
			
			name.sendKeys(Name);
			description.sendKeys(Description);
			probability.sendKeys(Probability);
			daysuntilstale.sendKeys(DaysUntilStale);
			saveButton.click();
			
			System.out.println("Successfully created New Milestone");
			Reporter.log("Successfully created New Milestone");
			Thread.sleep(5000);

			
		}else {
			System.out.println("Error while Clicking on New Milestone button");
			Reporter.log("Error while Clicking on New Milestone button");
		}
	}
	
	public ArrayList<String> getAllMilestoneNames() {
		
		ArrayList<String> allmilestones=new ArrayList<String>();
		if(milestoneNames!=null || !milestoneNames.isEmpty()) {			
			for(WebElement milestone : milestoneNames) {
	
				allmilestones.add(milestone.getText());
			}
		    
		}
		
      return allmilestones;
		
	}
	
}	

