package com.mmt.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.qa.testbase.TestBase;
import com.mmt.qa.util.Utility;

//Class to implement functions related to Home Page
public class HomePage extends TestBase {

	//Page Factory objects
	@FindBy(xpath = "//a[contains(@class,'active makeFlex')]")
	public WebElement flightLink;
	
	@FindBy(xpath = "//li[contains(text(),'Round Trip')]")
	public WebElement roundTripLink;
	
	@FindBy(id = "fromCity")
	public WebElement fromCity;
	
	@FindBy(id = "toCity")
	public WebElement toCity;
	
	@FindBy(xpath = "//span[@class='lbl_input latoBold appendBottom10']")
	WebElement travelDate;
	
	
	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn ')]")
	WebElement searchBtn;

	
	//Constructor to initialize Page factory objects with driver
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to remove Site Subscription Popup
	public void removePopup() {
		if(driver.findElement(By.xpath("//iframe[@name='webpush-bubble']")).isDisplayed()){
			driver.switchTo().frame("webpush-bubble");
			driver.findElement(By.xpath("//button[@id='deny']")).click();
		}
    }
	
	//Method to click on element
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	//Method to select Source and Destination city
	public void selectCity(String sourceCity, String destinationCity) {
	   fromCity.sendKeys(sourceCity);
	   
       driver.findElement(By.xpath("//p[@class='font16 appendBottom8' and starts-with(text(),'"+ sourceCity +"')]")).click();
       toCity.sendKeys(destinationCity);
       driver.findElement(By.xpath("//p[@class='font16 appendBottom8' and starts-with(text(),'"+ destinationCity +"')]")).click();
	  
	}
	
	//Method to select Date for Departure and Return
    public void selectDate(String date) {
		
		travelDate.click();
		List <WebElement> dateLabel =driver.findElements(By.xpath("//span[@class='lbl_input latoBold appendBottom10']"));
		
		for(int i=0;i<dateLabel.size();i++) {
			if(dateLabel.get(i).getText().equalsIgnoreCase("DEPARTURE"))
			{
				dateLabel.get(i).click();
	            driver.findElement(By.xpath("//div[@aria-label='" + date + "']")).click();
	            return;
			}

			 if(dateLabel.get(i).getText().equalsIgnoreCase("RETURN"))
				{
		            driver.findElement(By.xpath("//div[@aria-label='" + date + "']")).click();
		            return;
				}
		}
		

	}
    
    //Method to click on the Search button 
    public void clickOnSearchBtn() {
    	 searchBtn.click();
    	 driver.manage().deleteAllCookies();
 		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_LOAD, TimeUnit.SECONDS);
 		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD, TimeUnit.SECONDS);
    	 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
       
      
}

	
	
	
	

