package com.capsuleCRM.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.capsuleCRM.testbase.TestBase;

public class HighlightElements extends TestBase {

	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<4;i++) {
			changeColor("rgb(186,232,237)",element,driver);
			changeColor(bgcolor,element,driver);

		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
        try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
