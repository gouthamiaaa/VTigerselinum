package vTigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.Iconstantpath;

public class CreateEventTest extends BaseClass{

	@Test
	public void createEventTest()
	{
		SoftAssert soft=new SoftAssert();
		Map<String,String> map=excel.readFromExcel("EventsTestData", "CreateNewEvent");
		home.selectFromQuickCreate(web, map.get("Quick Create"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject=map.get("subject")+jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.clickOnstartDate();
		createEvent.chooseRequiredDate(web, map.get("Start date"), jutil);
		createEvent.clickOnDueDate();
		createEvent.chooseRequiredDate(web, map.get("Due Date"), jutil);
		createEvent.clickSaveButton();
		soft.assertTrue(newEventInfo.getPageHeader().contains(subject));
		if(newEventInfo.getPageHeader().contains(subject))
			excel.writeToExcel("EventsTestData", "CreateNewEvent", "pass", Iconstantpath.EXCEL_PATH);
		else
			excel.writeToExcel("EventsTestData", "CreateNewEvent", "fail", Iconstantpath.EXCEL_PATH);
		soft.assertAll();
	}

}

