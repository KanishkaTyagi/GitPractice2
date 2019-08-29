package com.capsuleCRM.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.HighlightElements;

public class AddPersonPage extends TestBase{

	@FindBy(xpath="//a[text()='Add Person']")
	WebElement addPersonLink;
	
	@FindBy(name="party:j_id108:j_id116")
	WebElement title;
	
	@FindBy(xpath="//input[contains(@id,'fn')]")
	WebElement firstName;
	
	@FindBy(xpath="//input[contains(@id,'ln')]")
	WebElement lastName;
	
	@FindBy(xpath="//input[contains(@id,'org')]")
	WebElement orgName;
	
	@FindBy(xpath="//input[contains(@id,'tagComboBox')]")
	WebElement tags;
	
	@FindBy(id="party:tagsDecorate:j_id187")
	WebElement addTagBtn;
	
	@FindBy(xpath="//input[contains(@id,'nmbr')]")
	WebElement email;
	
	@FindBy(id="party:j_id352")
	WebElement addEmailBtn;
	
	@FindBy(id="party:j_id443")
	WebElement addressLink;
	
	@FindBy(xpath="//input[contains(@id,'cty')]")
	WebElement city;
    
    @FindBy(id="party:save")
    WebElement saveBtn;
	
	public AddPersonPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAddPerson() {
		if(addPersonLink.isDisplayed()) {
			HighlightElements.flash(addPersonLink, driver);
			addPersonLink.click();
			System.out.println("Clicked on Add Person button");
			}
		else {
			System.out.println("Error in clicking on Add Person button..!!");
			Reporter.log("Error in clicking on Add Person button..!!");
		}
		
	}
	
	
	public void addPersonData(String Title, String fName, String lName,String Org, String Tags,String Email, String City, String Country){
		
		Select title = new Select(driver.findElement(By.name("party:j_id108:j_id116")));
		title.selectByVisibleText(Title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		orgName.sendKeys(Org);
		
		tags.sendKeys(Tags);
		addTagBtn.click();
		
		email.sendKeys(Email);
		addEmailBtn.click();
		
		addressLink.click();
		
		city.sendKeys(City);
		
		Select country=new Select(driver.findElement(By.xpath("//select[contains(@name,'cntry')]")));
		country.selectByVisibleText(Country);
		
		saveBtn.click();
		System.out.println("Created Person Profile sucessfully..!!");
		Reporter.log("Created Person Profile sucessfully..!!");

		}

	}
	

