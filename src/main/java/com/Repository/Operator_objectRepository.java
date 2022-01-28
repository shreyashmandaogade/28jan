package com.Repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Operator_objectRepository {


	@FindBy(xpath="//tr")
	public List<WebElement> lists;
		
}
