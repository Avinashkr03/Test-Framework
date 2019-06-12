package basicTests;
//used work on hidden objects in web Application
//Selenium unable to handle hidden elements. 
//To identify if element is hidden - look for values of its attributes soemwhere "hidden" will be present

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	WebDriver driver;
	@Test
	public void JavaScript() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.findElement(By.id("fromPlaceName")).sendKeys("Ben");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String text = " ";
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
			String script = "return document.getElementById(\"fromPlaceName\").value;";
			text=(String) js.executeScript(script);
			System.out.println(text);
		}
		
	}

}
