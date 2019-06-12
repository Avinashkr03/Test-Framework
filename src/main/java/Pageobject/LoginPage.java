package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By loginbtn = By.xpath("//*[@value='Log In']");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getemail() {
		return driver.findElement(email);
	}

	public WebElement getpwd() {
		return driver.findElement(pwd);
	}
	
	public WebElement getlogin() {
		return driver.findElement(loginbtn);
	}

}
