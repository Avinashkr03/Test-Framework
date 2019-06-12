package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	By signin = By.cssSelector("a[href*='sign_in']");
	By title =By.xpath("//*[@id='content']/div/div");
	By Navbar = By.xpath("//*[@id=\'homepage\']/header/div[2]/div/nav");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement login() {
	return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
		}
	
	public WebElement getNavbar() {
		return driver.findElement(Navbar);
		} 
	

	
}
