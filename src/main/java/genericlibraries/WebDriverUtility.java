package genericlibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * this class contains all reusable methods to perform driver related operations
 * @author Admin
 *
 */

public class WebDriverUtility {
private WebDriver driver;
private WebDriverWait wait;

/**
 * this method is used to launch specified browser
 * @param browser 
 * @param browser
 * @return
 */
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case"chrome":
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");			
			driver=new ChromeDriver();
			break;
		case"firefox":
			driver=new FirefoxDriver();
			break;
		case"edge":
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("invalid browser info");
				
		}
		return driver;
	}
	
	
	
	/**
	 * this method is used to maximize the browser
	 */
				public void maximizeBrowser() {
					driver.manage().window().maximize();
				}
				
				
				/**
				 * this method is used to navigate to specified application
				 *  * @param url
				 */
				public void navigateToApp(String url) {
					driver.get(url);
				}
				
				
				
				
				/**
				 * this method is used to wait till the element is found
				 * @param time
				 */
				
				public void waitTillElementFound(long time) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
				
				}
				
				
				
				/**
				 * this method is used to wait until element is enabled to visible
				 * @param time
				 * @param element
				 */
				
				public WebElement explicitWait(long time,WebElement element) {
				wait=new WebDriverWait(driver,Duration.ofSeconds(time));
					return wait.until(ExpectedConditions.visibilityOf(element));
					
				}
				
				
				
				/**
				 * this method is used to wait until the element to receOieve click
				 * @param element
				 * @param time
				 * @return
				 */
				
				public WebElement explicitWait(WebElement element,long time) {
					wait=new WebDriverWait(driver,Duration.ofSeconds(time));
					return wait.until(ExpectedConditions.elementToBeClickable(element));
					
				}
				
				
				
				/**
				 * this method is used to wait until webpage title appears  
				 * @param title
				 * @param time
				 * @return
				 */
				
				public boolean explicitWait(String title,long time) {
					wait=new WebDriverWait(driver,Duration.ofSeconds(time));
					return wait.until(ExpectedConditions.titleContains(title));
					}
				
				
				/**
				 * this method is used to mouse hover on an element 
				 * @param element
				 */
				public void mouseHover(WebElement element) {
					Actions action=new Actions(driver);
					action.moveToElement(element).perform();
				}
				
				/**
				 * it is used to right click on an element
				 * @param element
				 */
				
				public void rightClick(WebElement element) {
					Actions action=new Actions(driver);
					action.contextClick(element).perform();

				}
				
				
				/**
				 * used to double click on an element
				 * @param element
				 */
				public void doubleClickElement(WebElement element) {
					Actions action=new Actions(driver);
					action.doubleClick(element).perform();
					}
				/**
				 * used to darg and drop the element to target
				 * @param element
				 * @param target
				 */
				
				public void dragAndDrop(WebElement element,WebElement target) {
					Actions action=new Actions(driver);
					action.dragAndDrop(element,target).perform();

				}
				/**
				 * used to select an element from drop down based on index
				 * @param element
				 * @param index
				 */
				
				public void  selectFromDropdown(WebElement element,int index) {
					Select select=new Select(element);
					select.selectByIndex(index);
				}
				/**
				 * used to select an element from drop down based on value attribute
				 * @param element
				 * @param value
				 */
				
				public void  selectFromDropdown(WebElement element,String value) {
					Select select=new Select(element);
					select.selectByValue(value);
				}
				/**
				 * used to select an element from drop down based on visible text
				 * @param visibleText
				 * @param element
				 */
				
				public void  selectFromDropdown(String visibleText,WebElement element) {
					Select select=new Select(element);
					select.selectByVisibleText(visibleText);
				}
				
				
				
				/**
				 * switch to control to frame based on frame index
				 * @param index
				 */
				public void switchToFrame(int index) {
					driver.switchTo().frame(index);
				}
				
				
				
				/**
				 * switch to the control toframe based on frame id or name 
				 * @param idOrName
				 */
				
				public void switchToFrame(String idOrName) {
					driver.switchTo().frame(idOrName);
				}
				
				
				/**
				 * usedtoswitch the control to frame based on frame  element
				 * @param frameElement
				 */
				
				public void switchToFrame(WebElement frameElement) {
					driver.switchTo().frame(frameElement);
				}
				
				
				/**
				 * used to switch back from  frame to main web page
				 */
				public void switchBackFromFrame() {
					driver.switchTo().defaultContent();
				}
				
				
				/**
				 * used to take screenshot of the web page and generates image file
				 * @param className
				 * @param jUtil
				 * @return
				 */
				
				public String  takeScreenshot(String className,JavaUtility jUtil,WebDriver driver) {
					TakesScreenshot ts=(TakesScreenshot)driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
					File dest=new File("./Screenshot/"+className+"_"+jUtil.getCurrentTime()+".png");
					try {
						FileUtils.copyFile(src, dest);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					return dest.getAbsolutePath();	
				}
				 
				
				
				/**
				 * used to take the screenshot of the web page and generate BASE64 image
				 * @return
				 */
				public String TakeScreenshot() {
					TakesScreenshot ts=(TakesScreenshot)driver;
					return ts.getScreenshotAs(OutputType.BASE64);
				}
				
				public void  scrollToElement(WebElement element) {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true)",element);
					}
				
				/**
				 * this method handles alert pop up
				 * @param status
				 */
				public void handleAlert(String status) {
					Alert alert=driver.switchTo().alert();
					if(status.equalsIgnoreCase("ok"))
						alert.accept();
					else
						alert.dismiss();
					}
				
				/**
				 * this method is used to switch to child browser
				 */
				public void switchToChildWindow() {
				Set<String> set=driver.getWindowHandles();
				for(String window:set)
				{
					driver.switchTo().window(window);
				}
				}
				/**it is used to switch the specified window
				 * 
				 * @param WindowID
				 */
				
				public void switchToWindow(String WindowID) {
					driver.switchTo().window(WindowID);
				}
				/**
				 * used to get the parent window  address
				 * @return
				 */
				
				public String getParentWindowID() {
					return driver.getWindowHandle();
					
				}
				
				/**
				 * is used to close the current window
				 */
				public void closeCurrentWindow() {
					driver.close();
				}
				/**
				 * this method is used to quit all the windows 
				 */
				
				public void quitAllWindows()
				{
					driver.quit();
				}
				
				/**
				 * this method is used to convert String to dynamic Xpath
				 * @param commonPath
				 * @param replaceData
				 */
				
public WebElement convertStringToDynamicXpath(String commonPath,String replaceData) {
	String requiredPath=String.format(commonPath, replaceData);
	return driver.findElement(By.xpath(requiredPath));
}

/**
 * this method is used to convert String to dynamic xpath
 * @param commonPath
 * @param replaceData
 */

public WebElement convertStringToDynamicXpath(String commonPath,int replaceData) {
String requiredPath=String.format(commonPath, replaceData);
return driver.findElement(By.xpath(requiredPath));
}
}	
				
		