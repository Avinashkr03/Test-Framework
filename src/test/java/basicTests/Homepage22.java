package basicTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobject.LandingPage;
import Pageobject.LoginPage;
import resources.Base;

public class Homepage22 extends Base {


@Test(dataProvider="getdata")
public void basePageNavigation(String username,String pwd, String text) throws IOException{
		
	driver = initializedriver();
	
	LandingPage l = new LandingPage(driver);
	l.login().click();
	
	LoginPage lp = new LoginPage(driver);
	lp.getemail().sendKeys(username);
	lp.getpwd().sendKeys(pwd);
	lp.getlogin().click();
	System.out.println(text);
	driver.close();
	}

 @DataProvider
 public Object[][] getdata() {
	 Object[][] data = new Object[2][3];
			 data [0][0]="my@mail.com";
			 data [0][1]="mypassword";
			data [0][2]="successdata1";
			 data [1][0]="my2@mail.com";
			 data [1][1]="my2pwd";
			 data [1][2]="successdata2";	 
			 
			 return data;
			 
 }
 @AfterTest
	public void closebrowser() {
		
		driver.close();
	}
 
	 
 }

