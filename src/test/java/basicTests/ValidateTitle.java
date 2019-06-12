package basicTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pageobject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	@Test
	public void basePageTitle() throws IOException{
		
		driver = initializedriver();
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		System.out.println(l.getTitle().getText());

}
	@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
}
