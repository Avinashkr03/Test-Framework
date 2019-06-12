package basicTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class multipleTests extends Base{
	@BeforeTest
	public void open_practiceSection() throws IOException {
		driver = initializedriver();
		driver.findElement(By.xpath("//*[@class='nav navbar-nav navbar-right']/li[5]/a")).click();
		String s= driver.findElement(By.xpath("/html/body/h1")).getText();
		Assert.assertEquals("Practice Page", s);
		
	}
	//@Test
	public void automate_radioButton() throws IOException {
		driver.findElement(By.cssSelector("[value='radio2']")).click();
		driver.findElement(By.cssSelector("[value='radio1']")).click();
		driver.findElements(By.cssSelector("[class='radioButton']")).get(2).click();//get()-used to choose from a list of webelements using index value
		int size = driver.findElements(By.cssSelector("[class='radioButton']")).size();
		Assert.assertTrue(size==3, "Check the count of radio buttons");
		
	}
	
	//@Test
	public void autoSuggestiveDropdown() throws InterruptedException {
		WebElement item= driver.findElement(By.cssSelector("[placeholder='Select Countries']"));
		item.sendKeys("Ind");
		Thread.sleep(1000);
		item.sendKeys(Keys.ARROW_DOWN);
		item.sendKeys(Keys.ENTER);
	}
	
	//@Test                    //Static dropdowns can be recognized by select tag 
	public void staticDropdown() {
		WebElement item = driver.findElement(By.cssSelector("[id='dropdown-class-example']"));
		Select s = new Select(item); // using Select Class
		Assert.assertFalse(s.isMultiple());
		s.selectByIndex(2);
		s.selectByValue("option1");
	}
	
	//@AfterTest //Dropdowns where elements become visible after some interaction are dynamic dropdowns
	public void dynamicDropdown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='CCU'])[1]")).click(); //[1] means 1st occurence of the given xpath,
		//since there are more than one occurence of the same xpath (Kolkata station name present in both soucre and destination)
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //[2] means 2nd occurence of the given xpath
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		// xpath of parent space and then the xpath of child - alternate method 
		System.out.println("PASSED: dynamicDropdown");
	}  
	@Test
	public void automate_checkboxes() {
	int i = driver.findElements(By.cssSelector("[type='checkbox']")).size();
	while(i>0)
	{
		driver.findElements(By.cssSelector("[type='checkbox']")).get(i-1).click();
		i--;
		driver.close();
	}
	}
	
	
	

	
	
	

}
