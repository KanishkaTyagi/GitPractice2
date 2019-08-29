package com.mmt.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mmt.qa.util.Utility;

//Class to implement initial functionalities
public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	Utility utility;
	
	//Constructor to initialize config file
	public TestBase(){
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Users\\katyagi\\Desktop\\Selenium\\MakeMyTripTest\\src\\main\\java\\com\\mmt\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method to initialize driver and get URL
	public void initialization() {
		
		if(prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\katyagi\\Desktop\\Selenium\\MakeMyTripTest\\ChromeDriver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
        }
		else if(prop.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Users\\katyagi\\Desktop\\Selenium\\geckodriver.exe\\");
			driver = new FirefoxDriver();
        }
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		
		
	}
}
