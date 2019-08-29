package com.mmt.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.qa.testbase.TestBase;

//Class to implement functions related to Flight Search Page
public class FlightSearchPage extends TestBase {

	@FindBy(xpath="fli-list splitVw-listing")
	WebElement departureFlights;
	
	@FindBy(xpath="//label[@for='filter_stop0']//span")
    WebElement nonStopLabel;
    
    @FindBy(xpath="//label[@for='filter_stop1']//span")
    WebElement oneStopLabel;
    
    //List <WebElement> expectedPrice = driver.findElements(By.xpath("//div[@class='pull-right marL5 text-right']/descendant::p[@class='actual-price']/span/"));
	
    String preXPath = "//div[@class='";
	String postXPath = "']/descendant::div[@class='fli-list splitVw-listing']";
	//List <WebElement> totalDepartureFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-left" +postXPath));
	//List <WebElement> totalReturnFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-right" +postXPath));
	
	
	String postXpathActualList = "']/descendant::p[@class='actual-price']/span/";
	//List <WebElement> actualPriceDepartureFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-left" +postXpathActualList));
	//List <WebElement> actualPriceReturnFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-right" +postXpathActualList));
	
	//Constructor to initialize Page factory objects with driver
	public FlightSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Method to count total no. of Departure and Return Flights
	public void getCountofFlights() {
		System.out.println("count 1");
	List <WebElement> totalDepartureFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-left" +postXPath));
	System.out.println("count 2");
	List <WebElement> totalReturnFlights =driver.findElements(By.xpath(preXPath + "splitVw-sctn pull-right" +postXPath));
	System.out.println("count 3");
		System.out.println("Total count of Departure Flights : " +totalDepartureFlights.size());
		System.out.println("count 4");
      System.out.println("Total count of Return Flights : " +totalReturnFlights.size());
      System.out.println("count 5");
	}
	
	
	//Method to count total flights with Stop as Non Stop
	/*public void getCountofFlightsWithNonStops() {
		nonStopLabel.click();
		getCountofFlights();
	}*/
	
	
	//Method to count total flights with Stop as 1 Stop
	/*public void getCountofFlightsWithOneStops() {
		oneStopLabel.click();
		getCountofFlights();
	}*/
	
	
	//Method to select Departure and Return Flights
	/*public void selectDepartureAndReturnFlight(int departureFlightNo, int returnFlightNo) {

		totalDepartureFlights.get(departureFlightNo).click();
		totalReturnFlights.get(returnFlightNo).click();
		
	}*/
	
	
	//Method to get Actual Price of selected Departure Flight
	/*public String getActualPriceforDepartureFlight(int departureFlightNo) {
		return actualPriceDepartureFlights.get(departureFlightNo).getText();
	}*/
	
	
	//Method to get Actual Price of selected Return Flight
	/*public String getActualPriceforReturnFlight(int returnFlightNo) {
		return actualPriceReturnFlights.get(returnFlightNo).getText();
	}*/
	
	
	//Method to get Expected Price of selected Departure Flight
	/*public String getExpectedPriceforDepartureFlight() {
		return expectedPrice.get(0).getText();
	}*/
	
	
	//Method to get Expected Price of selected Return Flight
	/*public String getExpectedPriceforReturnFlight() {
		return expectedPrice.get(1).getText();
	}*/
	
	
	//Method to get Total Flight price
	/*public String totalFlightPrice() {
		return driver.findElement(By.xpath("//span[@class='splitVw-total-fare']/span/")).getText();
	}*/
}
