package basicTests;
//mostly used for hovering over an element

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionClasses {
	WebDriver driver;
	@Test
	public void actions() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
	driver = new FirefoxDriver();
			
	driver.get("https://www.amazon.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions a = new Actions(driver);  
	//hover over the element
    a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
	//waiting to load all options
    WebDriverWait d=new WebDriverWait(driver,10);
    d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Create a List')]")));

	
	//select and open in new tab
	a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Create a List')]"))).keyDown(Keys.CONTROL).click().build().perform();
	//Hover again
	a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
	//select different element
    
	d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Your Garage')]")));
	a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Your Garage')]"))).keyDown(Keys.CONTROL).click().build().perform();
	

}
	}
