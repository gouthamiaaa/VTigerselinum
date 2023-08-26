package vTigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void CreateOrgTest() {
		SoftAssert soft=new SoftAssert();
		home.clickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSaveButton();
		
		
		soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		if(newOrgInfo.getPageHeader().contains(orgName))
			excel.writeToExcel("OrganizationTestData", "Create Organization", "Pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("OrganizationTestData", "Create Organization", "Fail", Iconstantpath.EXCEL_PATH);
		soft.assertAll();
		
	}

}
