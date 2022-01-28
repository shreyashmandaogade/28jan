package com.Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.BaseClass;

public class Down_objectRepository extends BaseClass{
	
	@FindBy(xpath="//img[@src='../images/jdk.png']")
	public  WebElement javalogo;
	
	@FindBy(xpath="//h1")
	public  WebElement downloadHeading;
}
