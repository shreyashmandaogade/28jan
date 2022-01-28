package com.Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_objectRepository {
	
	@FindBy(xpath="//button[text()='Add User']")
	public WebElement addUser;
	
	@FindBy(id="username")
	public WebElement uname;
	
	@FindBy(id="mobile")
	public WebElement mobnum;
	
	@FindBy(id="email")
	public WebElement eaddress;
	
	@FindBy(id="course")
	public WebElement cname;
	
	@FindBy(id="Male")
	public WebElement radiobtn;
	
	@FindBy(xpath="//select")
	public WebElement selectCls;
	
	@FindBy(id="password")
	public WebElement upass;
	
	@FindBy(xpath="//input[@placeholder='FriendMobile']")
	public WebElement frndmoblie;
	
	@FindBy(id="//button")
	public WebElement userbtn;
	
		
}
