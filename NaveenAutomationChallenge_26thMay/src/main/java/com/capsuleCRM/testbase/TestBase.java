package com.capsuleCRM.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.capsuleCRM.utility.Utility;
import com.capsuleCRM.utility.WebEventListener;


public class TestBase {

    private final static String ConfigFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\capsuleCRM\\config\\config.properties";
	

	public static Properties prop;
	public static WebDriver driver;
    String BrowserName;
    String Url;
    
    
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

    public TestBase(){
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(new File(ConfigFilePath));
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Initialization() {

		BrowserName = prop.getProperty("BrowserName");
		if(BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
		else {
			Reporter.log(BrowserName + " is invalid");

			try {
				throw new Exception("Invalid Browser Name. Please try to connect with valid browser..!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		Reporter.log("Navigated to "+BrowserName);
		
		driver.manage().window().maximize();
		Reporter.log("Maixmized the "+BrowserName +"Browser");
		
        driver.manage().deleteAllCookies();
		Reporter.log("Deleted all cookies.");

		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_LOAD, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD, TimeUnit.MINUTES);

		Url = prop.getProperty("url");
		driver.get(Url);
		Reporter.log("!!..Sucessfully navigated to "+ Url +"..!!" );

	}
}


