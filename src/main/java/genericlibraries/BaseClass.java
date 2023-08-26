package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import pomPage.ContactsPage;
import pomPage.CreateNewContactPage;
import pomPage.CreateNewEvent;
import pomPage.CreateNewLeadPage;
import pomPage.CreateNewOrganizationPage;
import pomPage.DuplicatingLeadPage;
import pomPage.HomePage;
import pomPage.LeadsPage;
import pomPage.LoginPage;
import pomPage.NewContactInfoPage;
import pomPage.NewEventInfo;
import pomPage.NewLeadInfoPage;
import pomPage.NewOrgInfoPage;
import pomPage.OrganizationsPage;

public class BaseClass {

	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEvent createEvent;
	protected CreateNewLeadPage createLead;
	protected NewOrgInfoPage newOrgInfo;
	protected NewContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfo newEventInfo;
	protected DuplicatingLeadPage duplicatingLead;

	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classSetup() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		web=new WebDriverUtility();
		
		property.propertiesInitialization(Iconstantpath.PROPERTIES_PATH);
		driver=web.launchBrowser(property.readFromProperties("browser"));
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		sdriver=driver;
		sjutil=jutil;
	}
	@BeforeMethod
	public void methodSetUp() {
		excel.excelInitialization(Iconstantpath.EXCEL_PATH);
		
		login=new LoginPage(driver);
		home=new HomePage(driver);
		org=new OrganizationsPage(driver);
		contacts=new ContactsPage(driver);
		lead=new LeadsPage(driver);
		createOrg=new CreateNewOrganizationPage(driver);
		createContact=new CreateNewContactPage(driver);
		createEvent= new CreateNewEvent(driver);
		createLead=new CreateNewLeadPage(driver);
		newOrgInfo=new NewOrgInfoPage(driver);
		newContactInfo=new NewContactInfoPage(driver);
		newLeadInfo=new NewLeadInfoPage(driver);
		newEventInfo=new NewEventInfo(driver);
		duplicatingLead=new DuplicatingLeadPage(driver);
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
	   
	}
	
	@AfterMethod
	public void methodTearDown() {
		home.signOutOfVtiger(web);
		excel.closeExcel();
	}
	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	//AfterTest
	//AfterSuite
	
	
}
