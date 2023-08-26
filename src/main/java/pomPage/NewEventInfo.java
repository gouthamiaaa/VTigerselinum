package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEventInfo {
	//Declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement pageHeader;
		//Initialization
		public NewEventInfo(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public String getPageHeader()
		{
			return pageHeader.getText();
		}

}
