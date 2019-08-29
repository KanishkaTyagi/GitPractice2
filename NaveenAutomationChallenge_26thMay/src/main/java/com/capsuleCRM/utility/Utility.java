package com.capsuleCRM.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static long PAGE_LOAD = 10;
	public static long IMPLICIT_LOAD = 10;
	
	
	public static void waitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static String convertDoubletoString(String text) {
		int text1 = (int) Double.parseDouble(text);
		String text2 = String.valueOf(text1);
		return text2;
	}
}
