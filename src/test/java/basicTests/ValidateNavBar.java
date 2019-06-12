 package basicTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pageobject.LandingPage;
import junit.framework.Assert;
import resources.Base;

public class ValidateNavBar extends Base{
	
	@Test
	public void basePageNavBar() throws IOException{
		
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavbar().isDisplayed());
		System.out.println(l.getNavbar().getText());
		
	}
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
	
		}
	
	
	}
