*********************************SELENIUM Coding Challenge Part 3- NAVEEN Automation Labs***************************

Code URl: https://kanishkat.capsulecrm.com/login


*************************************************PRE Conditions*****************************************************

PRE-Conditions (Manual Step):
1.	Go to capsulecrm.com
2.	Create a free account
EX: http://naveenlabs.capsulecrm.com


************************************************TestCases Covered****************************************************

Test Case 1:

1. Go to this URL - https://kanishkat.capsulecrm.com/login
		a.	Login with correct credentials	
2. Click on person icon and add a person
3. Click on cases icon 
4. Click on Add Case button
5. Create a new case with the added person
6. Verify the correct case got created for the same person
7. verify the case status: Open
8. Close the browser.

Test Case 2:

1.  Go to this URL -https://kanishkat.capsulecrm.com/login
        a. Login with correct credentials
2.  Click on account name at left top corner
3.  Go to account settings
4.  Verify Account Settings page header
5.  Click on each link available at left panel:
6.  After clicking on each link, verify the page header
7.  Click on Appearance and upload a LOGO image
8.  Click on Users : Add New User and verify the same user
9.  Click on Opportunities : Add new milestone and verify the same
10. Click on Tracks : Add new track and verify the same
11. Click on Task Categories : Add new category and verify the same
12. Click on Tags : Add new milestone and verify the same
13. Click on Integrations and verify total number of Configure buttons
14. Close the browser

******************************************Instructions for Running the Project*********************************************************

1. All data in Excel file should be unique and same data must not be present in the Site.
2. The values given in Excel file for Dropdown should be valid. It should be there in the dropdown.

************************************Details of Project and Structure Hierarchy******************************************
There are three Packages:

1. src/main/java -->> This contains all Test cases implementation classes
2. src/test/java -->> This contains all Test Cases
3. src/main/java -->> This contains Testng.xml File

1. src/main/java --> com.capsuleCRM.config -->> Contains all Config data
                 --> com.capsuleCRM.dataStorage  -->> Contains data that is generated from Excel
                 --> com.capsuleCRM.ExtentReportListener -->> Used to Generate Extent Reports
                 --> com.capsuleCRM.pages -->> Contains Java classes for all Pages
                 --> com.capsuleCRM.testbase -->> Contains all base implementation such as getting properties file, initializing WebDriver
                 --> com.capsuleCRM.testdata -->> Contains Excel file having data
                 --> com.capsuleCRM.utility --> Contains all generic utilities
                 
2. src/test/java --> AccountsPageTest.java --> All Test cases related to Account Section.
                 --> PersonAndCasePageTest.java -->> All Test cases related to Person and Case Section.
                 
3. src/main/resources -->> testng.xml --> Test Suite for all Test Cases

4. Drivers --> Folder having all drivers .exe file
5. LogoImage -->> Image for attaching logo in Appearance Page Section.
6. Screenshots --> Contain screenshots for any failed scenarios.
7. test-output --> Contain output for Test NG report. 