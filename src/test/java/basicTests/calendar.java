package basicTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//css - new style 
//

public class calendar {
	WebDriver driver;
	@Test
	public void select_date() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		String month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
		//changing to previous month until month is November
		while(!(month.contains("November")))
		{
			//new css style - traversing from parent class to child class
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='prev']")).click();
			month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
		}
		
		
		
		//All the dates have same class = "day"
		int i = driver.findElements(By.className("day")).size();
		System.out.println(i);
		//Iterating through elements with class = "day"
		for(int j=0;j<i;j++) {
			//Storing the text(contains date) in string day
			String day = driver.findElements(By.className("day")).get(j).getText();
			//compairing day with our desired date
			if(day.equals("3")) {
				//click on the desired date
				driver.findElements(By.className("day")).get(j).click();
				System.out.println(day);
				//break req as the date section will close after click and throw unable to find elements
				//error if further iterated
				break;
			}
			
		}
		
	}
	

}
