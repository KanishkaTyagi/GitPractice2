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

public class TaskPage extends TestBase {

	@FindBy(xpath="//div//h2[text()='Task Categories']")
	WebElement tasksHeader;
	
	@FindBy(xpath="//a[text()='Add new Category']")
	WebElement newTaskButton;
	
	@FindBy(xpath="//input[@id='editCategoryForm:taskCategoryNameDecorate:taskCategoryName']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='editCategoryForm:j_id175']")
	WebElement saveButton;
	
	@FindAll( {@FindBy(xpath = "//tbody//tr//td[2]//a")} )
	private List<WebElement> taskName;
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderValue() {
		clickTasksLink();
		HighlightElements.flash(tasksHeader, driver);

		System.out.println("Tasks Categories Page Header --->>> "+tasksHeader.getText());
		return tasksHeader.getText();
	}

	public void clickTasksLink() {
		driver.findElement(By.linkText("Task Categories")).click();
	}

	public void addNewTrack(String Name) throws InterruptedException {
		if(newTaskButton.isDisplayed()) {
			newTaskButton.click();
			System.out.println("Clicked on Add New Task button");
			Reporter.log("Clicked on Add New Task button");

			Utility.waitForElement(name, driver);
			name.sendKeys(Name);
			saveButton.click();

			System.out.println("Successfully created New Task");
			Reporter.log("Successfully created New Task");
			Thread.sleep(5000);

		}else {
			System.out.println("Error while Clicking on New Task button");
			Reporter.log("Error while Clicking on New Task button");
		}
	}

	public ArrayList<String> getAllTasksNames() {

		ArrayList<String> alltasks=new ArrayList<String>();
		if(taskName!=null || !taskName.isEmpty()) {
			for(WebElement task : taskName) {
				alltasks.add(task.getText());
			}
			
		}
		return alltasks;

	}

}
