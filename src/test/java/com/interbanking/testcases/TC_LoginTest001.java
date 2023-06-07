 package com.interbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.interbanking.pageobjects.LoginPage;

public class TC_LoginTest001 extends BaseClass

{
	@Test
	public void loginTest() throws IOException
	{
		
		Logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setusername(username);
		Logger.info("Entered Username");
		
		lp.setpassword(password);
		Logger.info("Entered Password");
		lp.clicksubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Logger.info("Login Test Failed");
			
		}
		
	}

}
