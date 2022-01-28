package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.UserPage;

public class UserTest extends BaseClass{
	
	UserPage up;
	
	@BeforeMethod
	public void setUp() {
		
		reportInit();
		up = new UserPage(driver);
			
	}
	@Test
	public void Validate() {
		
		Assert.assertTrue(up.verifyAddUser());	
	}
}
