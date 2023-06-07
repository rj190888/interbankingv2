package com.interbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig  {
	Properties pro; //create object of properties class//
	
	// create a constructor//
	public ReadConfig()
	{
		File src= new File("./configuration/config.properties"); // send this path in src (file object)//
		try
		{
			FileInputStream fis=new FileInputStream(src); //  we are reading the data from config.properties so that we have to import
			//thisfile  by using fileinputstream. we have to open the file in read mode then we use fileinputstream//
			pro = new Properties(); // initiated pro object of properties class//
			pro.load(fis); // load is a method which will load the complete file at the run time//
			
		}
		catch(Exception e)
		
		{
			System.out.println(e);
		}
		
	}
	// get properties from config file//
	
	public String getApplicaionURL()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	

}
