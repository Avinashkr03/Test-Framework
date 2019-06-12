package basicTests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class wait {
	
	public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("www.spicejet.com");
	driver.findElement(By.id("H-destination")).sendKeys("nyc");
	driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);
	driver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);

	WebDriverWait d=new WebDriverWait(driver,20);
	d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
	//d.until(ExpectedConditions.))

	driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();

	}

	}


