package basicTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class alerts {
	@Test
	public void automate_htmlAlerts() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://book.goindigo.in/Booking/GSTInvoiceDetails#book-flight");
		driver.findElement(By.id("Oneway_")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='oneWaySearchModal']/div/div/div[3]/div/a")).click();
		driver.close();
	}
	@Test//Alerts whose HTML code is not present , no way to identify these type of alerts using locators
	public void automate_javascriptAlert() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.cssSelector("[value='Confirmation Alert']")).click();
		System.out.println(driver.switchTo().alert().getText());
		String s = driver.switchTo().alert().getText();
		Assert.assertEquals(s, "Are you sure you want to give us the deed to your house?");
		driver.switchTo().alert().accept(); 
		//driver.switchTo().alert().dismiss();//for negative selection(no, cancel)
	}
}
	