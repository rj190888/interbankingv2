package com.interbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver ldriver; //local driver
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	

	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	
	public void setusername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		btnLogin.click();
	}
	
	}

