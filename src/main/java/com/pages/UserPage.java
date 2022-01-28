package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Repository.User_objectRepository;

public class UserPage extends User_objectRepository{
	
	WebDriver driver;

	public UserPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyAddUser() {
		
		addUser.click();
		uname.sendKeys("shreyash");
		mobnum.sendKeys("9897100000");
		cname.sendKeys("Java");
		radiobtn.click();
		
		Select st = new Select(selectCls);
		st.selectByValue("Maharashtra");
		
		upass.sendKeys("123qaz");
		frndmoblie.sendKeys("1020304050");
		
		userbtn.click();
				
		WebDriverWait  wait = new WebDriverWait(driver,10);

		try {
			wait.until(ExpectedConditions.alertIsPresent());
			 driver.switchTo().alert().accept();	
			 
			System.out.println("alert is present");			
			return true;
			
		}catch(Exception e)	{
			e.printStackTrace();
			System.out.println("alert is not present");
			return false;	
			
		}
	}
}
