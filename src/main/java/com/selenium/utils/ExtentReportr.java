package com.selenium.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportr {

	public static ExtentReports generateReport() {
		
		ExtentReports extentReport = new ExtentReports();
		File path = new File("D:\\Practice3\\MavenTestProject\\test-output\\ExtentReport\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Selenium Automation Project Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application URL","https://tutorialsninja.com/demo/");
		extentReport.setSystemInfo("BrowerName", "Chrome");
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return extentReport;
	}
	
}
