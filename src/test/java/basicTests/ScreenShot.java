package basicTests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import this for using screenshot class
//import org.apache.commons.io.FileUtils;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/?safe=active&ssui=on");
		//to delete all cookies
		driver.manage().deleteAllCookies();
		//to delete a specific cookie
		driver.manage().deleteCookieNamed("asdf");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("D:\\screenshot.png"));
	}

}
