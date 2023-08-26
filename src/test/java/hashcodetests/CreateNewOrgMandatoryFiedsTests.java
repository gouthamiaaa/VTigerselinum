package hashcodetests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgMandatoryFiedsTests {

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
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		
		
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organizaion page is displayed");
		else
			System.out.println("Organization page not found");
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	WebElement createorg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));

	if(createorg.getText().contains("Creating New Organization"))
		System.out.println("Creating New Organization page is displayed");
	else
		System.out.println("Creating New Organization is not found");

	Random random=new Random();
	int randomNum=random.nextInt(100);
	String orgName="Tcs"+randomNum;
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	WebElement industry=driver.findElement(By.name("industry"));
	
	Actions a=new Actions(driver);
	a.moveToElement(industry).perform();
	
	Select s = new Select(industry);
	s.selectByValue("Communications");
	
	
	WebElement type=driver.findElement(By.name("accounttype"));
	//Actions a1=new Actions(driver);
	a.moveToElement(type).perform();
	
	Select s1 = new Select(type);
	s1.selectByValue("Competitor");
	
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	
	String neworginfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(neworginfo.contains(orgName))
		System.out.println("organization created with type& industry succesfully");
	else
		System.out.println("organization not created");

	WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   a.moveToElement(adminIcon).perform();
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.quit();
	
	}

}
