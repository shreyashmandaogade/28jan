package com.pageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.OperatorPage;

public class OperatorTest extends BaseClass{
	
	OperatorPage Op;
	
	@BeforeMethod
	public void setUp() {

		reportInit();
		//Op = new OperatorPage(driver);
			
	}
	
	@Test
	public void validateExcel() {

	//	Assert.assertTrue(Op.writeDataInExcel());		
	}
}
