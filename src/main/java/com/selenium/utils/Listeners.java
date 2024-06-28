package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
ExtentReports extentReports;
ExtentTest extentTest;
ExtentTest extentStep;
WebDriver driver;
private String testCasName;
@Override
public void onStart(ITestContext context) {
	System.out.println("Project Tests started executing");
	extentReports = ExtentReportr.generateReport();
}

@Override
public void onTestStart(ITestResult result) {
	String testCasName = result.getName();
	// System.out.println(testCasName+ " - started executing");
	extentStep = extentReports.createTest(testCasName);
	extentStep.log(Status.INFO, testCasName + " - started executing");
}

@Override
public void onTestSuccess(ITestResult result) {
	String testcase = result.getName();
	extentStep = extentReports.createTest(testcase);
	extentStep.log(Status.PASS, testcase + " - Successfully executed");
}
@Override
public void onTestFailure(ITestResult result) {
	String testcase = result.getName();
	extentStep = extentReports.createTest(testcase);
	extentStep.log(Status.FAIL, testcase + " - Test case failed");
	
}

@Override
public void onFinish(ITestContext context) {
	extentStep.log(Status.INFO, "All the test cases execution completed!!!");
	extentReports.flush();
}

}
