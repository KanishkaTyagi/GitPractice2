package com.capsuleCRM.testcases;

import org.testng.annotations.Test;

import com.capsuleCRM.dataStorage.DataProviderClass;
import com.capsuleCRM.pages.AccountPage;
import com.capsuleCRM.pages.AppearancePage;
import com.capsuleCRM.pages.CustomFieldsPage;
import com.capsuleCRM.pages.ExportPage;
import com.capsuleCRM.pages.HomePage;
import com.capsuleCRM.pages.IntegrationsPage;
import com.capsuleCRM.pages.InvoicesPage;
import com.capsuleCRM.pages.LoginPage;
import com.capsuleCRM.pages.MailPage;
import com.capsuleCRM.pages.OpportunitiesPage;
import com.capsuleCRM.pages.TagsPage;
import com.capsuleCRM.pages.TaskPage;
import com.capsuleCRM.pages.TracksPage;
import com.capsuleCRM.pages.TrashPage;
import com.capsuleCRM.pages.UsersPage;
import com.capsuleCRM.testbase.TestBase;
import com.capsuleCRM.utility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AccountsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	AccountPage accountpage;
	InvoicesPage invoicepage;
	ExportPage exportpage;
	AppearancePage appearancepage;
	MailPage mailpage;
	UsersPage userspage;
	OpportunitiesPage opportunitiespage;
	TracksPage trackpage;
	TaskPage taskpage;
	CustomFieldsPage customfieldpage;
	TagsPage tagspage;
	IntegrationsPage integrationspage;
	TrashPage trashpage;
	


	public AccountsPageTest() {
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
		homePage.clickAccountSettings();
	}


	@Test(priority = 1)
	public void verifyPageHeader() {

		accountpage = new AccountPage();
		Assert.assertEquals(accountpage.getHeaderValue(), "Account");

		invoicepage = new InvoicesPage();
		Assert.assertEquals(invoicepage.getHeaderValue(), "Invoices");

		exportpage=new ExportPage();
		Assert.assertEquals(exportpage.getHeaderValue(), "Export");


		appearancepage= new AppearancePage();
		Assert.assertEquals(appearancepage.getHeaderValue(), "Appearance");
		appearancepage.uploadLogo();

		mailpage = new MailPage();
		Assert.assertEquals(mailpage.getHeaderValue(), "Mail Drop Box");

		userspage= new UsersPage();
		Assert.assertEquals(userspage.getHeaderValue(), "Users");

		opportunitiespage= new OpportunitiesPage();
		Assert.assertEquals(opportunitiespage.getHeaderValue(), "Opportunities");
		
		trackpage= new TracksPage();
		Assert.assertEquals(trackpage.getHeaderValue(), "Tracks");
		
		taskpage= new TaskPage();
		Assert.assertEquals(taskpage.getHeaderValue(), "Task Categories");
		
		customfieldpage = new CustomFieldsPage();
		Assert.assertEquals(customfieldpage.getHeaderValue(), "Custom Fields");

		tagspage= new TagsPage();
		Assert.assertEquals(tagspage.getHeaderValue(), "Tags and DataTags");

		integrationspage = new IntegrationsPage();
		Assert.assertEquals(integrationspage.getHeaderValue(), "Integrations");

		trashpage = new TrashPage();
		Assert.assertEquals(trashpage.getHeaderValue(), "Trash");

	}


	@Test(priority = 2, dataProvider = "getUserData", dataProviderClass = DataProviderClass.class)
	public void verifyAddNewUser(String firstName, String lastName, String Email, String Username) {
		userspage= new UsersPage();
		userspage.clickUsersLink();
		userspage.addNewUser(firstName, lastName, Email, Username);

		Assert.assertEquals(userspage.getNewUser(), firstName + " " + lastName, "The User is not added..!!");
	}


	@Test(priority = 3, dataProvider = "getMilestoneData", dataProviderClass = DataProviderClass.class)
	public void verifyAddNewMilestone(String Name, String Description, String Probability, String DaysUntilStale) throws InterruptedException {
		opportunitiespage= new OpportunitiesPage();
		opportunitiespage.clickOppurtunitiesLink();
		opportunitiespage.addNewMilestone(Name, Description, Probability, DaysUntilStale);
		System.out.println("All Milestones are -->> "+opportunitiespage.getAllMilestoneNames());
		Assert.assertTrue(opportunitiespage.getAllMilestoneNames().contains(Name), "The New Milestone is not added..!!");
		System.out.println("New milestone added is verified successfully");

	}
	
	@Test(priority = 4, dataProvider = "getTracksData", dataProviderClass = DataProviderClass.class)
	public void verifyAddNewTracks(String Name, String Tag, String TaskDescription, String Duedate, String Days, String Assignee) throws InterruptedException {
		String Due = Utility.convertDoubletoString(Duedate);
	    trackpage= new TracksPage();
		trackpage.clickTracksLink();
		trackpage.addNewTrack(Name, Tag, TaskDescription,Due, Days, Assignee);
		Assert.assertTrue(trackpage.getAllTracksNames().contains(Name), "The New Track is not added..!!");
		System.out.println("New track is verified successfully");
	}
	
	@Test(priority = 5, dataProvider = "getTasksData", dataProviderClass = DataProviderClass.class)
	public void verifyAddNewTasks(String Name) throws InterruptedException {
		
		taskpage= new TaskPage();
		taskpage.clickTasksLink();
		taskpage.addNewTrack(Name);
		System.out.println("All Tasks are -->> "+taskpage.getAllTasksNames());
		Assert.assertTrue(taskpage.getAllTasksNames().contains(Name), "The New Task is not added..!!");
		System.out.println("New task is verified successfully");
	}

	@Test(priority = 6, dataProvider = "getTagsData", dataProviderClass = DataProviderClass.class)
	public void verifyAddNewTags(String Name, String Detail) throws InterruptedException {
		
		tagspage= new TagsPage();
		tagspage.clickTagsLink();
		tagspage.addNewTag(Name, Detail);
		System.out.println("All Tags are -->> " + tagspage.getAllTagsNames());
		Assert.assertTrue(tagspage.getAllTagsNames().contains(Name), "The New Tag is not added..!!");
		System.out.println("New tag is verified successfully");
	}
	
	@Test(priority = 7)
	public void verifyAddNewIntegrations() throws InterruptedException {
		
		integrationspage = new IntegrationsPage();
		integrationspage.clickIntegrationsLink();
		System.out.println("Total number of Configure buttons are  -->> " + integrationspage.getConfigureButtons());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
