package com.capsuleCRM.testcases;


import com.capsuleCRM.dataStorage.DataProviderClass;
import com.capsuleCRM.pages.AddCasePage;
import com.capsuleCRM.pages.AddPersonPage;
import com.capsuleCRM.pages.HomePage;
import com.capsuleCRM.pages.LoginPage;
import com.capsuleCRM.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PersonAndCasePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	AddPersonPage addPersonpage;
	AddCasePage addCasepage;

	public PersonAndCasePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginpage = new LoginPage();
		loginpage.validateTitle();
		loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.validateTitle();
	}

	

	@Test(priority = 1,dataProvider = "getPeopleData",dataProviderClass=DataProviderClass.class)
	public void verifyAddPersonDataTest(String title, String firstName, String lastName, String org, String tags, String email, String city, String country) {
		addPersonpage = homePage.clickPeopleIcon();
		addPersonpage.clickonAddPerson();
		addPersonpage.addPersonData(title, firstName, lastName, org, tags, email, city, country);
	}


	@Test(priority = 2, dataProvider = "getCasesData",dataProviderClass=DataProviderClass.class)
	public void verifyAddCaseDataTest(String CasesRelated, String Name, String Description, String Tags) throws InterruptedException{
		addCasepage = new AddCasePage();
		addCasepage.clickCaseIcon();
		addCasepage.clickAddCase();
		addCasepage.createCases(CasesRelated, Name, Description, Tags);

		Assert.assertEquals(addCasepage.getPersonName(), CasesRelated,"The Case is created for wrong person..!!");
		Assert.assertEquals(addCasepage.getStatus(), "Open","The Case Status is incorrect..!!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}

}
