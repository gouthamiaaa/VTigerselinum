package pomPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class LeadsPage {
	

	//Declaration
	private String commonPath="//table[@classs='lvt small']/descendant::tr";
	private String leadNamePath=commonPath+"[%d]/td[3]";
	private String leadCheckBox=commonPath+"[%d]/td[1]/input";
	@FindBy (xpath="table[@class='lvt small']descendant::tr")
	private List<WebElement> leadList;
		@FindBy(xpath="//img[@alt='Create Lead...']")
		private WebElement plusButton;
		
		@FindBy(xpath="//input[@value='Delete']")
		private WebElement DeleteButton;
		//Initialization
		public LeadsPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//utilization
		public void clickPlusButton() {
			plusButton.click();
		}
		
		public void taverseToRequiredLead(WebDriverUtility web,String requiredLead) {
			for(int i=2;i<leadList.size();i++) {
				String leadName=web.convertStringToDynamicXpath(leadNamePath,(i+1)).getText();
				if(leadName.equals(requiredLead)) {
					web.convertStringToDynamicXpath(leadCheckBox,(i+1)).click();
					break;
				}
			}
			
			
		}

}
