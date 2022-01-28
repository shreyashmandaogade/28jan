package com.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.Repository.Dash_objectRepository;

public class DashboardPage extends Dash_objectRepository{

	WebDriver ldriver;

	public DashboardPage(WebDriver rdriver){

		this.ldriver = rdriver;
		PageFactory.initElements(driver,this);
	}

	public boolean verifyAllCourses() {

		ArrayList<String> actCourse = new ArrayList<String>();

		for(WebElement courselist : courseOffered) 
		{		
			String cname = courselist.getText();
			actCourse.add(cname);
		}

		ArrayList<String> expCourse = new ArrayList<String>();

		expCourse.add("Selenium");		
		expCourse.add("Java / J2EE");
		expCourse.add("Python");
		expCourse.add("Php");

		if(actCourse.equals(expCourse))
			return false;
		else
			return true;
	}	

	public boolean verifyAllContent() {

		ArrayList<String> al = new ArrayList<String>();

		for(WebElement webTable : content) 
		{
			String menu = webTable.getText();
			al.add(menu);
		}		

		ArrayList<String> lists = new ArrayList<String>();

		lists.add("Dashboard");
		lists.add("Users");
		lists.add("Operators");
		lists.add("Useful Links");
		lists.add("Downloads");
		lists.add("Logout");

		if(al.equals(lists))
			return false;
		else
			return true;
	}

	public UserPage navigateToUserPage(WebDriver driver) {		
		users.click();
		return new UserPage(driver);		
	}
}















