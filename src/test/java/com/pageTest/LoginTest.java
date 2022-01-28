package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.LoginPage;


public class LoginTest extends BaseClass{

	LoginPage lp;
		
	@BeforeMethod
	public void setUp() {

		initialization();
		reportInit();
		lp = new LoginPage(driver);
			
	}

	@Test
	public void validateHeading() {

		Assert.assertTrue(lp.verifyHeading());		
	}

	@Test
	public void validateCourse() {		
		Assert.assertTrue(lp.verifyCourse());		
	}
	
	  @Test 
	  public void loginValid() {
	  
	  lp.loginApplication("kiran@gmail.com","123456");
	  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard"); 
	  
	  }
}






