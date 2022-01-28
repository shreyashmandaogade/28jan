package com.Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BaseClass;

public class Login_objectRepository extends BaseClass{

	@FindBy(id="email")
	public  WebElement uname;

	@FindBy(id="password")
	public WebElement pass;

	@FindBy(xpath="//*[text()='Sign In']")
	public WebElement loginButton;	
	
	@FindBy(xpath="//b[text()='Java By Kiran']")
	public WebElement Heading;
	
	@FindBy(xpath="//h4['JAVA | SELENIUM | PYTHON']")
	public WebElement course;
		
}
