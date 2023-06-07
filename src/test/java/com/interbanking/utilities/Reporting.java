package com.interbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.HTMLReporter;
// Listener class used to extends reports//
// simple ITestListener adapter that stores all the tests that were run. 
//You can retrieve these results with the following methods: 
//getPassedTests() getFailedTests() getSkippedTests() 

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.DD.HH.MM.SS").format(new Date()); //time stamp
		String repname="Test_Report-"+timestamp+".html";
		//spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname); //specify Location
		try {
			((ExtentSparkReporter) spark).loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} 
		catch (IOException e) {
		
			e.printStackTrace();
	
		}
	 
	    
		extent=new ExtentReports();
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "rahul");
		
		((ExtentSparkReporter) spark).config().setDocumentTitle("InetBanking Test Project"); //Title of report
		((ExtentSparkReporter) spark).config().setReportName("Functional Test Report"); // name of the report
		//((ExtentSparkReporter) spark).config().setTestViewChartLocation(chartlocation.Top); // location of the chart
		((ExtentSparkReporter) spark).config().setTheme(Theme.DARK);
		
		
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report//
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Send the Passed Information
		
	}
public void onTestFailure(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); // create new entry in the report//
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	String screenshotspath=System.getProperty("user.dir")+ "\\screenshots\\"+tr.getName()+".png";
	
	File f =new File(screenshotspath);
	if(f.exists())
	{
		try
		{
			logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotspath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public void onTestSkipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); // create new entry in the report//
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
}
public void onFinish(ITestResult tr)
{
	extent.flush();
}
}