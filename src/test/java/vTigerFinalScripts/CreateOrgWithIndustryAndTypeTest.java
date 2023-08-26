package vTigerFinalScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateOrgWithIndustryAndTypeTest extends BaseClass {
	public void CreateOrgTest() {
		SoftAssert soft=new SoftAssert();
		home.clickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization  withindustry and type");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.selectIndustry(web, map.get("Industry"));
		createOrg.selectType(web,map.get("Type"));
		createOrg.clickSaveButton();
		
		
		soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		if(newOrgInfo.getPageHeader().contains(orgName))
			excel.writeToExcel("OrganizationTestData", "Create Organization  withindustry and type", "Pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("OrganizationTestData", "Create Organization  withindustry and type", "Fail", Iconstantpath.EXCEL_PATH);
		soft.assertAll();
		
	}

 
}
