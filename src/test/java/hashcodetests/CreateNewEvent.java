package hashcodetests;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewEvent {

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
		
		
		WebElement quickcreateToDo=driver.findElement(By.id("qccombo"));
		Select s=new Select(quickcreateToDo);
		s.selectByValue("Events");
		WebElement createToDo=driver.findElement(By.xpath("//b[text()='Create To Do']"));
		if(createToDo.isDisplayed())
			System.out.println("Create to do window is displayed");
		else
			System.out.println("create to do is not displayed ");
		
		Random random=new Random();
		int randomnum=random.nextInt(100);
		String subject="Meet"+randomnum;
		
		driver.findElement(By.name("subject")).sendKeys("subject");
		 driver.findElement(By.id("jscal_trigger_date_start")).click();
		 
		 int reqdate=19;
		 int reqmonth=10;
		 int reqyear=2025;
		 
		 String commonpath="//div[@class='calendar' and contains(@style,'block')]/descendant::td[%s]";
		 String actMonthYear=driver.findElement(By.xpath(formatPath(commonpath,"@class='title'"))).getText();
		 System.out.println(actMonthYear);
		
		 String[] str=actMonthYear.split(", ");
		int  actYear=Integer.parseInt(str[1]);
		
		while(actYear<reqyear)
		{
			driver.findElement(By.xpath(formatPath(commonpath,"text()='>>'"))).click();
			actMonthYear=driver.findElement(By.xpath(formatPath(commonpath,"@class='title'"))).getText();
			System.out.println(actMonthYear);
			
			str=actMonthYear.split(", ");
			actYear=Integer.parseInt(str[1]);
		}
		
		int  actMonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(actMonth);
		
		
		while(actMonth<reqmonth)
		{
			driver.findElement(By.xpath(formatPath(commonpath,"text()='>'"))).click();
			actMonthYear=driver.findElement(By.xpath(formatPath(commonpath,"@class='title'"))).getText();
			System.out.println(actMonthYear);
			
			str=actMonthYear.split(", ");
			actMonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actMonth);
			
			}
		
		while(actMonth>reqmonth)
		{
			driver.findElement(By.xpath(formatPath(commonpath,"text()='<'"))).click();
			actMonthYear=driver.findElement(By.xpath(formatPath(commonpath,"@class='title'"))).getText();
			System.out.println(actMonthYear);
			
			str=actMonthYear.split(", ");
			actMonth=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actMonth);
			}
		driver.findElement(By.xpath(formatPath(commonpath,"text()='"+reqdate+"'"))).click();
	}
		public static String formatPath(String commonPath,String replaceData)
		{
			return String.format(commonPath,replaceData);
		}
			
		}

