package basicTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Genericfunction_Frames {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int frameNo = frame(driver,By.xpath("//*[text()='Automation Tools Tutorial']"));
		driver.switchTo().frame(frameNo);
		String s = driver.findElement(By.xpath("//*[text()='Automation Tools Tutorial']")).getText();
		System.out.println(s);

	}
//generic function for finding desired frame by passing an obj and getting its frame number
	public static int frame(WebDriver driver, By by) {
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		int i = 0;
		for (i = 0; i < size-1; i++) {
			driver.switchTo().frame(i);
			int j = driver.findElements(By.xpath("//*[text()='Automation Tools Tutorial']")).size();
			if(j>0) {
				break;
				}
		}
		System.out.println(i);
		//switch back to main webpage since we need to choose frames present in main webpage
		driver.switchTo().defaultContent();
		

		return i;

	}

}
