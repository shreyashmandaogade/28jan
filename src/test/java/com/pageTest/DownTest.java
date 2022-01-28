package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DownloadPage;


public class DownTest extends BaseClass{

	DownloadPage dp;
	
	@BeforeMethod
	public void setUp() {

		reportInit();
		dp = new DownloadPage(driver);
			
	}
	@Test
	public void verifyLogo() {
		Assert.assertTrue(dp.verifyLogo());
	}
	
	@Test
	public void validateHeading() {		
		Assert.assertTrue(dp.verifyDownloadHeading());		
	}
}
