package com.capsuleCRM.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class TracksPage extends TestBase {
	
	@FindBy(xpath="//div//h2[text()='Tracks']")
	WebElement tracksHeader;
	
	@FindBy(xpath="//a[text()='Add new Track']")
	WebElement newTrackButton;
	
	@FindBy(id="j_id123:trackDescriptionDecorate:trackDescription")
	WebElement name;
	
	@FindBy(xpath="//input[contains(@id,'trackTag')]")
	WebElement tag;
	
	@FindBy(id="j_id123:taskLines:0:taskDescriptionDecorate:taskDescription")
	WebElement taskDescription;
	
	@FindBy(xpath="//input[contains(@id,'taskDaysAfter')]")
	WebElement dueDate;
	
	@FindBy(xpath="//a[text()='Save']")
	WebElement saveButton;
	
	@FindAll( {@FindBy(xpath = "//tbody//tr//td[1]//a")} )
	private List<WebElement> tracksName;
	
	public TracksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickTracksLink();
		HighlightElements.flash(tracksHeader, driver);
		System.out.println("Tracks Page Header --->>> "+tracksHeader.getText());
		return tracksHeader.getText();
	}

	public void clickTracksLink() {
		driver.findElement(By.linkText("Tracks")).click();
	}

	public void addNewTrack(String Name, String Tag, String TaskDescription,String Duedate, String Days, String Assignee) {
		if(newTrackButton.isDisplayed()) {
			newTrackButton.click();
			System.out.println("Clicked on Add New Track button");
			Reporter.log("Clicked on Add New Track button");

			name.sendKeys(Name);
			tag.sendKeys(Tag);
			taskDescription.sendKeys(TaskDescription);			
		
			dueDate.clear();
			dueDate.sendKeys(Duedate);
			
			Select days = new Select(driver.findElement(By.id("j_id123:taskLines:0:taskDaysAfterDecorate:trackDayDelayRule")));
			days.selectByVisibleText(Days);
			
			Select assignee = new Select(driver.findElement(By.name("j_id123:taskLines:0:taskAssignmentDecorate:j_id218")));
			assignee.selectByVisibleText(Assignee);
						
			saveButton.click();

			System.out.println("Successfully created New Track");
			Reporter.log("Successfully created New Track");

		}else {
			System.out.println("Error while Clicking on New Track button");
			Reporter.log("Error while Clicking on New Track button");
		}
	}

	public ArrayList<String> getAllTracksNames() {

		ArrayList<String> alltracks=new ArrayList<String>();
		if(tracksName!=null || !tracksName.isEmpty()) {
			System.out.println(tracksName.size());

			for(WebElement track : tracksName) {
				alltracks.add(track.getText());
			}
			
		}
		return alltracks;

	}

}
