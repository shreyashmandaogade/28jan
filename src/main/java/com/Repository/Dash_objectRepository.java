package com.Repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BaseClass;

public class Dash_objectRepository extends BaseClass{

	@FindBy(xpath="//h3")
	public List<WebElement> courseOffered;
	
	@FindBy(xpath="//li[contains(text(),'MAIN NAVIGATION')]//following::span")
	public List<WebElement> content;
	
	@FindBy(partialLinkText="info")
	public WebElement windowHandle;
	
	@FindBy(xpath="//span[text()='Users']")
	public  WebElement users;
}
