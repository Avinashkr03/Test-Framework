package basicTests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//links count - "tagname of links 'a'"
//limit scope and open each link in that scope in a new tab
//get title of each tab
public class Limiting_webdriverScope {
	WebDriver driver;
	@Test
	public void webdriver() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");
		//Limiting Scope of webdriver
		WebElement coloumndriver=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int i = coloumndriver.findElements(By.tagName("a")).size();
		//Keys,chord used to send keys sequence
		String keyS = Keys.chord(Keys.CONTROL,Keys.ENTER);
		for (int j=1;j<i-1;j++)
		{
			//reeduced scope of driver to coloumndriver
			coloumndriver.findElements(By.tagName("a")).get(j).sendKeys(keyS);
		}
		//Printing wimdow titles
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> id = handles.iterator();
		while (id.hasNext())
		{
			driver.switchTo().window(id.next());
			System.out.println(driver.getTitle());
		}
	}
}
