package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.LoginPage;
import com.utility.PropertiesUtility;

public class BaseClass {

	public static WebDriver driver;	
	public static Logger Log = Logger.getLogger(BaseClass.class);
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	public void initialization() {

		Log.info("reading Browser name from properties file");		
		String browsers = PropertiesUtility.readProperty("browser");

		Log.info("reading URL from properties file");	
		String url = PropertiesUtility.readProperty("url");

		if(browsers.equalsIgnoreCase("chrome")) {
			Log.info("Chrome browser is Launching");
			System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
			driver =new ChromeDriver();
		}

		if(browsers.equalsIgnoreCase("firefox")) {
			Log.info("firefox browser is Launching");
			System.setProperty("webdriver.gecko.driver","F:\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		Log.info("Maximazing browser window");
		driver.manage().window().maximize();
		Log.info("applying waits on driver instance");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Log.info("launching an application");
		driver.get(url);		
	}

	public static String getScreenshot(String name) {

		String path = System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		TakesScreenshot ts = (TakesScreenshot)driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);

		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public void reportInit() {

		Log.info("initializing extent report");
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
		Log.info("extent report will be available in target folder after execution");
	}

	public LoginPage loadLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
} 