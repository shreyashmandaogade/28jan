package com.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.utility.ExcelUtility;


public class OperatorPage {

	public static FileInputStream fis;
	public static Workbook wb;
	public static Sheet sh;
	public static Cell c;
	public static Row r;
	public static FileOutputStream fos;		
	public static  WebDriver driver;

	
	  @BeforeSuite public void Setup() {
	  
	  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe"); 
	  driver = new ChromeDriver();
	  driver.get( "file:///F:/CORE_JAVA/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/operators.html");
	  
	  }
	 

	@Test
	public void verifyData() throws Exception {

		String path = "C:\\Users\\Shreyash\\new_WorkSpace\\com.initialframework\\TestData.xlsx";
		
		ExcelUtility xl = new ExcelUtility(path);

		xl.setCellData("optrData", 0, 0, "ID");
		xl.setCellData("optrData", 0, 1, "Person");
		xl.setCellData("optrData", 0, 2, "ForHelp");
		xl.setCellData("optrData", 0, 3, "Prefered Way to Connect");
		xl.setCellData("optrData", 0, 4, "Contact");
		xl.setCellData("optrData", 0, 5, "Timings");

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']/tbody"));

		int rows = table.findElements(By.xpath("tr")).size();

		for(int r = 2 ; r<=rows ; r++) {

			String index = table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String personName = table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String Enquiry = table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String wayToConnect = table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String mobileNum = table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			String time = table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();

			System.out.println(index+personName+Enquiry+ wayToConnect+mobileNum+time);

			xl.setCellData("optrData", r, 0, index);
			xl.setCellData("optrData", r, 1, personName);
			xl.setCellData("optrData", r, 2, Enquiry);
			xl.setCellData("optrData", r, 3, wayToConnect);
			xl.setCellData("optrData", r, 4, mobileNum);
			xl.setCellData("optrData", r, 5, time);

		}		
	}
}




















