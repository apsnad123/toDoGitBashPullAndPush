package com.crm.CAH.generic_Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListerImplimentationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log("execution Starts from here",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName+"-----> executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		try {
			String screenShot = WebdriverUtility.webPageScreenShot(BaseClass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName+"-- failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screenShot);
			Reporter.log(MethodName+"-----> Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-----> Skipped");
		test.log(Status.SKIP, result.getThrowable());		
		Reporter.log(MethodName+"-----> Skipped");	
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlReport.config().setDocumentTitle("VTIGER");
		htmlReport.config().setReportName("SDET-55");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Platform", "windows 11");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver:8888/");
		report.setSystemInfo("ReporterName", "Aparna");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
