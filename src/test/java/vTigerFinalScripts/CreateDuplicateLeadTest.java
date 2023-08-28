package vTigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateDuplicateLeadTest extends BaseClass {
	
	@Test
	
	public void createLeadTest() {
		  //update 2
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("LeadTestData", "Create and Duplicate Lead");
		 String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		newLeadInfo.clickDuplicateButton();
		soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating"));
		String newLastName=map.get("New Last Name")+jutil.generateRandomNum(100);
		duplicatingLead.setLastName(newLastName);
		duplicatingLead.clickSaveButton();
		if(newLeadInfo.getPageHeader().contains(newLastName))
			excel.writeToExcel("LeadTestData", "Create and Duplicate Lead", "pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("LeadTestData", "Create and Duplicate Lead", "fail", Iconstantpath.EXCEL_PATH);


	soft.assertAll();
	}

	}

	


