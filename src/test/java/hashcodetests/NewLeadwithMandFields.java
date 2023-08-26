package hashcodetests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewLeadwithMandFields {

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
			System.out.println("leads page is displayed");
		else
			System.out.println("leads  page not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		String name="Tcs"+randomNum;
		
	WebElement leadname=	driver.findElement(By.name("salutationtype"));
		
		Select s=new Select(leadname);
		s.selectByValue("Mrs.");
		driver.findElement(By.name("firstname")).sendKeys(name);
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.name("company")).sendKeys("tcs");
		
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//WebElement Lead=driver.findElement(By.xpath("//a[text()='Leads' and @class='hdrLink']"));
		if(driver.getTitle().contains("Leads"))
			System.out.println("Lead created succesfully");
		else
			System.out.println("Lead not created");
		
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

}
