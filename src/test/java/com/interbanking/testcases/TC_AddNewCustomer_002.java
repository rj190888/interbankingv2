package com.interbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.interbanking.pageobjects.AddCustomerPage;
import com.interbanking.pageobjects.LoginPage;

public class TC_AddNewCustomer_002 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		Logger.info("user name is provided");
		lp.setpassword(password);
		Logger.info("password is provided");
		lp.clicksubmit();
		
		
		Thread.sleep(3000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		Logger.info("providing customer details....");
		addcust.CustName("rahul");
		addcust.custGender("male");
		addcust.custDob("8","19","1988");
		Thread.sleep(3000);
		
		addcust.Custadd("udaipur");
		addcust.Custcity("udr");
		addcust.Custstate("raj");
		addcust.Custpin("1300");
		addcust.Custtelephone("123456");
		
		String email=randomestring1() + "@gmail.com";
		addcust.Custemail(email);
		addcust.Custpass("rhuhu");
		addcust.Custclick();
		  Thread.sleep(3000);
		  Logger.info("Validation start");
		Boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case is passed");
		}
		
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			Logger.info("test case is failed");
		}
	}
	//generate random email..//
		public String randomestring1()
		{
			String Randomemail =RandomStringUtils.randomAlphabetic(8);
			return(Randomemail);
			
		}
		
		public String randomenum1()
		{
			String Randnum =RandomStringUtils.randomAlphanumeric(4);
			return(Randnum);
			
		}
		
		
	
	
	}
	


