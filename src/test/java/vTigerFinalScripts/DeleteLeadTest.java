package vTigerFinalScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class DeleteLeadTest extends BaseClass {
	@Test
	
	public void deleteLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		lead.taverseToRequiredLead(web, "Lead4");
		lead.clickDelete();
		web.handleAlert("ok");
		List<WebElement> leadsNameList=lead.getLeadNamesList();
		boolean status=false;
		for(WebElement leads:leadsNameList)
		{
			if(!(leads.getText().equals("Lead4")))
				status=true;
		}
		soft.assertTrue(status);
		if(status)
		
			excel.writeToExcel("LeadsTestData", "Delete Lead", "pass", Iconstantpath.EXCEL_PATH);
		
		else
			excel.writeToExcel("LeadsTestData", "Delete Lead", "fail", Iconstantpath.EXCEL_PATH);
		soft.assertTrue(status);
		soft.assertAll();
		
	}

}

