package vTigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest() {
		
		SoftAssert soft=new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String,String> map=excel.readFromExcel("contacts test_data","Create Contact");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("contacts test_data", "Create Contact", "pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("contacts test_data", "Create Contact", "fail", Iconstantpath.EXCEL_PATH);
	
	
	soft.assertAll();}

}
