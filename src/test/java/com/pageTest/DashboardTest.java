package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.DashboardPage;

public class DashboardTest extends BaseClass{

	DashboardPage dp;

	@BeforeMethod
	public void setUp() {

		reportInit();
		
	}

	@Test
	public void validCourse() {
		Assert.assertTrue(dp. verifyAllCourses());
	}

	@Test
	public void validContent() {
		Assert.assertTrue(dp.verifyAllContent());

	}
}
	










