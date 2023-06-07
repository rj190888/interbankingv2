package com.interbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.interbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	
	public String baseUrl=rc.getApplicaionURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br)
	
	{
		
		Logger = org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("LOg4j.Properties");
		if(br.equals("chrome"))
		{
		System.setProperty("webDriver.chrome.driver",rc.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webDriver.gecko.driver",rc.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseUrl);
	}
	@AfterClass
		public void teardown()
	{
		driver.quit();
	}

public void captureScreen(WebDriver driver ,String tname ) throws IOException

{
TakesScreenshot ts=(TakesScreenshot) driver;
File source=ts.getScreenshotAs(OutputType.FILE);
File target=new File(System.getProperty("user.dir") + "/screenshots/" +tname+ ".png");
FileUtils.copyFile(source, target);
System.out.println("Screenshot taken");

}
}