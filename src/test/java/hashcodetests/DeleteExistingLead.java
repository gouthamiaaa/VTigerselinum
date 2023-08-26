package hashcodetests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteExistingLead {

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
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		if(driver.getTitle().contains("Leads"))
		{
			System.out.println("leads page is displayed");
		}
		else
		{
			System.out.println("Leads page not found");
			
		}
		
		String commonpath="//table[@class=\"lvt small\"]/descendant::tr";
	
		List<WebElement> leadsList=driver.findElements(By.xpath(commonpath));
		for(int i=2;i<leadsList.size();i++)
		{
			String leadName=driver.findElement(By.xpath("")).getText();
		
		if(leadName.equals(""))
		{
			driver.findElement(By.xpath("")).click();
			break;
		}
		}
		driver.findElement(By.xpath("")).click();
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		List<WebElement> newleadsList=driver.findElements(By.xpath(commonpath));
		
		boolean status=false;
		for(int i=2;i<newleadsList.size();i++)
		{
			String leadName=driver.findElement(By.xpath(commonpath+"["+(i+1)+"]/td[3]")).getText();
			if(!(leadName.equals("LEA7")))
			{
				status=true;
			}
		}
		if(status)
		System.out.println("lead deleted succesfully");
		else
			System.out.println("lead deletion failed");
		
		

		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
		
		
			

	

