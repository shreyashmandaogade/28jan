package com.utility;

import java.io.FileInputStream;
import java.util.Properties;
import com.base.BaseClass;


public class PropertiesUtility extends BaseClass {

	public static FileInputStream  fis;
	public static Properties prop;

	public static String readProperty(String key) {
		
		Log.info("reading Property file");
		
		prop = new Properties();

		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);

		} catch (Exception e) {
			Log.error("Property file is not Present in given path");
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
