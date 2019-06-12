package basicTests;
//frames can be recognized by tag names 
//"iframe", "frames"

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Handling_frames {
	WebDriver driver;
	@Test
	public void frame_handler() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int j = driver.findElements(By.tagName("frame")).size(); //finding the total num of frames
		System.out.println(j);
		//driver.switchTo().frame(0); //switching to frame using index
		//Alternately you can also switch using frame id or name or webelement
		driver.switchTo().frame("frame-top");
		WebElement middle_frame = driver.findElement(By.xpath("//*[@name='frame-middle']"));
		//switching frames using webelement(xpath)
		driver.switchTo().frame(middle_frame);
		String s = driver.findElement(By.id("content")).getText();
		System.out.println(s);
		
	}
}
