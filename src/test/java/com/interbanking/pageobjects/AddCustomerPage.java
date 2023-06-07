package com.interbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage  {
WebDriver driver; //local driver
	
public AddCustomerPage(WebDriver d)

{
	this.driver=d;
	
	//ldriver=rdriver;
	PageFactory.initElements(d, this);
}
	//identify the elements//
	
	@FindBy(how= How.XPATH, using="//a[normalize-space()='New Customer']")
	@CacheLookup
	
		 WebElement lnkAddNewCustomer;
	
	@FindBy(how= How.NAME, using= "name")
	@CacheLookup
	
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME, using= "rad1")
	@CacheLookup
	
	WebElement rGender;
	
	@FindBy(how= How.ID_OR_NAME, using= "dob")
	@CacheLookup
	
	WebElement txtdob;
	
	@FindBy(how= How.NAME, using= "addr")
	@CacheLookup
	
	WebElement txtaddress;
	
	@FindBy(how= How.NAME, using= "city")
	@CacheLookup
	
	WebElement txtcity;
	
	@FindBy(how= How.NAME, using= "state")
	@CacheLookup
	
	WebElement txtstate;
	
	@FindBy(how= How.NAME, using= "pinno")
	@CacheLookup
	
	WebElement txtpin;
	
	@FindBy(how= How.NAME, using= "telephoneno")
	@CacheLookup
	
	WebElement txtmob;
	
	@FindBy(how= How.NAME, using= "emailid")
	@CacheLookup
	
	WebElement txtemail;
	
	@FindBy(how= How.NAME, using= "password")
	@CacheLookup
	
	WebElement txtpassword;
	
	@FindBy(how= How.NAME, using= "sub")
	@CacheLookup
	
	WebElement btnsubmit;
	
	

	//action methods for every element//
	
	public void ClickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void CustName(String cname)
	{
	txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String Cgender)
	{
		rGender.click();
	}
	
	public void custDob(String mm,String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void Custadd(String caddress)
	{
	txtaddress.sendKeys(caddress);
	}
	
	public void Custcity(String ccity)
	{
	txtcity.sendKeys(ccity);
	}
	
	public void Custstate(String cstate)
	{
	txtstate.sendKeys(cstate);
	}
	public void Custpin(String cpinno)
	{
	txtpin.sendKeys(String.valueOf(cpinno)); //covert string to integer no//
	}
	
	public void Custtelephone(String ctelno)
	{
	txtmob.sendKeys(ctelno);
	}
	
	public void Custemail(String cemail)
	{
	txtemail.sendKeys(cemail);
	}
	
	public void Custpass(String cpass)
	{
	txtpassword.sendKeys(cpass);
	}
	
	public void Custclick()
	{
	btnsubmit.click();
	}
}
