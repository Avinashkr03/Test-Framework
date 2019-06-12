package basicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GitHub {
@Test
public void repository() {
	System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();	
driver.get("https://www.amazon.com/");
System.out.println("fdj");
}
}
