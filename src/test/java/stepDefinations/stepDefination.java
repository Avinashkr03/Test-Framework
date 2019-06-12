package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Pageobject.LandingPage;
import Pageobject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

public class stepDefination extends Base {

	@Given("^launch browser and open application$")
	public void launch_browser_and_open_application() throws Throwable {

		driver = initializedriver();
		// driver.close();

	}

	@Then("^Verify home page title$")
	public void verify_home_page_title() {
		// Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		System.out.println(l.getTitle().getText());
		// driver.close();

	}

	@When("Enter username and Enter password")
	public void enter_username_and_Enter_password() {
		// Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		l.login().click();

		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys("xyz@sgg.com");
		lp.getpwd().sendKeys("abc");

		System.out.println("success login");

	}

	@And("click on login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		LoginPage lp = new LoginPage(driver);
		lp.getlogin().click();
		System.out.println("success login button step");
		driver.close();

	}

	@When("I Open Practice section")
	public void i_Open_Practice_section() {
		driver.findElement(By.xpath("//*[@class='nav navbar-nav navbar-right']/li[5]/a")).click();

	}

	@Then("Verify practice page Title")
	public void verify_practice_page_Title() throws IOException {
		String s = driver.findElement(By.xpath("/html/body/h1")).getText();
		Assert.assertEquals("Practice Page", s);
	}

}
