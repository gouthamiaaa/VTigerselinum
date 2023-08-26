package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusButton;
	
	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public void clickPlusButton() {
		plusButton.click();
	}
	
	
	
}
