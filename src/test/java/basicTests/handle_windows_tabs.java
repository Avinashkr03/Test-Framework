package basicTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class handle_windows_tabs {
	WebDriver driver;
	@Test
	public void handler() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com/");
	
	//Opening a new tab
	Actions a = new Actions(driver);
	//hover over the element
    a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
	//waiting to load all options
    WebDriverWait d=new WebDriverWait(driver,10);
    d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Create a List')]")));
	//select and open in new tab
	a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Create a List')]"))).keyDown(Keys.CONTROL).click().build().perform();
	//opening a NEW WINDOW
	//Hover again
	a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
	//select different element
	d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Your Garage')]")));
	a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Your Garage')]"))).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
	System.out.println(driver.getTitle());//printing current window title
	Thread.sleep(2000);
	
	
	//Window Handling Starts
	
	
	
	//two new tabs are open now, getWindowHandles will provide ids for all the tabs, 
	//stored in set as string
	Set<String> handles = driver.getWindowHandles();
	System.out.println(handles); //printing windows or tabs ids
	//Iterate through the set
	Iterator<String> ids = handles.iterator();
	
	ids.next();

	//switching tabs 
	String ids1 = ids.next();
	driver.switchTo().window(ids1);
//print window title
	System.out.println(driver.getCurrentUrl());
	String id3 = ids.next();
	driver.switchTo().window(id3);
	System.out.println(driver.getTitle());
	System.out.println(id3);

}

}
