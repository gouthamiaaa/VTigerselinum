package vTigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateLeadTest extends BaseClass{
	 public static String lastName;
	@Test
	
	public void createLeadTest() {
		  
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("LeadTestData", "Create lead");
		lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("LeadTestData", "Create Lead", "pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("LeadTestData", "Create Lead", "fail", Iconstantpath.EXCEL_PATH);


	soft.assertAll();
	}

	}

	
