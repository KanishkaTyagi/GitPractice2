package com.mmt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.qa.pages.FlightSearchPage;
import com.mmt.qa.pages.HomePage;
import com.mmt.qa.testbase.TestBase;
import com.mmt.qa.util.Utility;

//Class to execute test cases related to Flight Search page
public class FlightSearchPageTest extends TestBase {
 
	HomePage homePage;
	FlightSearchPage flightSearchPage;
	Utility util;
	
	int departureFlightNo = 1;
	int returnFlightNo = 1;
	  
    // Constructor to call Parent class' constructor
	public FlightSearchPageTest() {
		super();
	}
	
	//Method to perform functions required before running test case
   @BeforeMethod
   public void setUp() {
	  initialization();
	  
	  homePage = new HomePage();
	  util = new Utility();
	  flightSearchPage = new FlightSearchPage();
	  

	 // homePage.removePopup();
	  homePage.clickOnElement(homePage.flightLink);
	  System.out.println("2");
	  homePage.clickOnElement(homePage.roundTripLink);
	  System.out.println("3");
	  homePage.selectCity(prop.getProperty("sourceCity"), prop.getProperty("destinationCity"));
	  System.out.println("4");
      homePage.selectDate(util.getCurrentDate());
      System.out.println("5");
      homePage.selectDate(util.addDaystoCurrentDate());
      System.out.println("6");
      homePage.clickOnSearchBtn();
      System.out.println("7");
      flightSearchPage.getCountofFlights();
      System.out.println("8");
     /* flightSearchPage.getCountofFlightsWithNonStops();
      flightSearchPage.getCountofFlightsWithOneStops();
      flightSearchPage.selectDepartureAndReturnFlight(departureFlightNo,returnFlightNo);*/
      
        }

   //Test case to verify Actual and Expected  Departure Flight price
  @Test(priority = 1)
  public void verifyActualExpectedDepartureFlightPrice() {
	  /*String actualPrice = flightSearchPage.getActualPriceforDepartureFlight(departureFlightNo);
	  String expectedPrice = flightSearchPage.getExpectedPriceforDepartureFlight();
	  Assert.assertEquals(actualPrice, expectedPrice);*/
	  
	  
  }
  
  //Test case to verify Actual and Expected  Return Flight price
  /*@Test(priority = 2)
  public void verifyActualExpectedReturnFlightPrice() {
	  String actualPrice = flightSearchPage.getActualPriceforReturnFlight(returnFlightNo);
	  String expectedPrice = flightSearchPage.getExpectedPriceforReturnFlight();
	  Assert.assertEquals(actualPrice, expectedPrice);
 }*/

  //Test case to verify Actual and Expected  Total Flight price
  /*@Test(priority = 3)
  public void verifyTotalActualExpectedFlightPrice() {
	  int expectedPriceDep = Integer.parseInt(flightSearchPage.getExpectedPriceforDepartureFlight());
	  int expectedPriceRet = Integer.parseInt(flightSearchPage.getExpectedPriceforReturnFlight());
	  int totalActual = expectedPriceDep + expectedPriceRet;
	  int totalExpected = Integer.parseInt(flightSearchPage.totalFlightPrice());
	  Assert.assertEquals(totalActual, totalExpected);
 }*/
  
  //Method to close browser after test case execution
  @AfterMethod
  public void tearDown() {
   
  }

}
