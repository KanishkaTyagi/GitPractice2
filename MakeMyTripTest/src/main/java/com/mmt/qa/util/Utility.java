package com.mmt.qa.util;

import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mmt.qa.pages.HomePage;
import com.mmt.qa.testbase.TestBase;

//Class to implement common functionalities
public class Utility extends TestBase {
	
	HomePage homePage;

	//Variables for Page_Load and Implicit_Load
	public static long PAGE_LOAD = 50;
	public static long IMPLICIT_LOAD = 50;
	
	
	//Method to get Current date
	public String getCurrentDate() {
		 DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
		 Date date = new Date();
		 return dateFormat.format(date); 
	}
	
	//Method to add days to Current date
	public String addDaystoCurrentDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 7);
		Date currentDatePlusOne = c.getTime();
		return dateFormat.format(currentDatePlusOne);
	}
	
	public void Scroll(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,1000)");
		
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
}
