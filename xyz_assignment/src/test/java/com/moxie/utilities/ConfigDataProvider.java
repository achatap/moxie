package com.moxie.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() 
	{	
		File src = new File(".//Configuration//config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			} 

		catch (Exception e) 
		{
			System.out.println("Not able to load config file>>"+e.getMessage());

		}
	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}

	public String getURL()
	{
		return pro.getProperty("URL");
	}
	
	public String getType()
	{
		return pro.getProperty("Type");
	}
	
	public String getEmail()
	{
		return pro.getProperty("Email");
	}
	
	public String getPassword()
	{
		return pro.getProperty("Password");
	}
	
	public String getExplicitTime()
	{
		return pro.getProperty("ExplicitTime");
	}
	
	public String getTimeZone()
	{
		return pro.getProperty("Timezone");
	}
	
	

}
