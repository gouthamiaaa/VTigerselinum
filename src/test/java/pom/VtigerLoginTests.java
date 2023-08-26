package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomPage.LoginPage;

public class VtigerLoginTests {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage login=new LoginPage(driver);
		login.loginToApp("admin", "admin");
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("log in passed");
		
		else
			System.out.println("log in failed");
		driver.quit();
		
		
		
	}

}
