package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.Repository.Login_objectRepository;

public class LoginPage extends Login_objectRepository{

	WebDriver driver;

	public LoginPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public boolean verifyHeading() {

		String actHeading = Heading.getText();
		String expHeading ="Java By Kiran";

		if(actHeading.equals(expHeading)) {
			System.out.println("heading is correct");
			return true;
		}else {
			System.out.println("heading is incorrect");
			return false;
		}
	}

	public boolean verifyCourse() {

		String actCourse = course.getText();		
		String expCourse ="JAVA | SELENIUM | PYTHON";

		if(actCourse.equals(expCourse)) {
			System.out.println("courses are available");
			return true;
		}else {
			System.out.println("courses are Not available");
			return false;
		}				
	}

	public void loginApplication(String username,String password) {

		uname.sendKeys(username); 
		pass.sendKeys(password); 
		loginButton.click(); 
	}
}




