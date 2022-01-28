package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Repository.Down_objectRepository;

public class DownloadPage extends Down_objectRepository{

	WebDriver driver;

	public DownloadPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLogo() {
		return javalogo.isDisplayed();
	}
	
	public boolean verifyDownloadHeading() {

		String actHeading = downloadHeading.getText();
		String expHeading ="Downloads";

		if(actHeading.equals(expHeading)) {
			System.out.println("heading is correct");
			return true;
		}else {
			System.out.println("heading is incorrect");
			return false;
		}
	}
}
