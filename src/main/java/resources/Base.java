package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver initializedriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\avinashkumar\\SeleniumFW\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.qaclickacademy.com/");

		}

		if (browser == "IE") {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\chromedriver_win32\\chromedriver.exe");
			// driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
