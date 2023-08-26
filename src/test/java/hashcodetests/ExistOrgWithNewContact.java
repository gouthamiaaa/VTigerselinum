package hashcodetests;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExistOrgWithNewContact {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("log in page is displayed");
		else
			System.out.println("log in page not found");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
		System.out.println("Home pagenot found");
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		if(driver.getTitle().contains("Contacts"))
			System.out.println("contacts page is dipalyed");
		else
			System.out.println("contacts page not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement createCont=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	
	
	if(createCont.getText().equals("Creating New Contact"))
	System.out.println("create new contact page is displayed");
	else
		System.out.println("create new contact page is not displayed");
	
	Random random=new Random();
	int randomnum=random.nextInt(100);
	String lastName="abc"+randomnum;
	
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.xpath("//img[contains(@onclick,'specific_contact_account_address')]")).click();
	
	String parentId=driver.getWindowHandle();
	Set<String> ids=driver.getWindowHandles();
	for(String s:ids)
	{
		driver.switchTo().window(s);
	}
	
	List<WebElement> orgList =driver.findElements(By.xpath("//div[@id='ListViewContents']/descendant::table[@cellspacing='1']/descendant::tr/td[1]/a"));
	
	for(int i=1;i<orgList.size();i++)
	{
		if(orgList.get(i).getText().equals("Tcs64"))
		{
			
			System.out.println(orgList.get(i).getText());
			orgList.get(i).click();
			break;
			
		}
	}
	driver.switchTo().window(parentId);
	driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	String newOrginfo=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	
	
	
	if(newOrginfo.contains(lastName))
		System.out.println("contact created successfully");
	else
		System.out.println("contact not created");
	
	WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a=new Actions(driver);
	a.moveToElement(adminIcon).perform();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
	}

}
