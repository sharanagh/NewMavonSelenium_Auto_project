package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	WebDriver driver;
	public Properties readingDataFromProp() throws IOException {
		String path = "D:\\Practice3\\MavenTestProject\\src\\main\\java\\com\\selenium\\propfile\\config.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browserName"));
		return prop;
	}

public WebDriver selectBrowser(String browserName, String url ) {
	
	if(browserName.equals("chrome")) {
		 driver = new ChromeDriver();
	}
	else if(browserName.equals("edge")) {
		 driver = new EdgeDriver();
	}
	else {
		System.out.println("No browsers found");
	}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	return driver;
}

public Object[][] readTestDataFromexcel(String sheetname) throws IOException {
	String path = "D:\\Practice\\PracticeMaven\\src\\main\\java\\com\\selenium\\mavenTestData\\ExcelTestData.xlsx";
	FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet(sheetname);
	int rowLength = sheet.getLastRowNum();
	int colLength = sheet.getRow(1).getLastCellNum();
	Object data[][] = new Object[rowLength][colLength];
	for(int i=0;i<rowLength;i++) {
		XSSFRow row = sheet.getRow(i+1);
		for(int j=0;j<colLength;j++) {
			XSSFCell cell = row.getCell(j);
			switch(cell.getCellType()) {
			case STRING:
				data[i][j]= cell.getStringCellValue();
				System.out.print(data[i][j]);
				break;
			case NUMERIC:
				data[i][j]= cell.getNumericCellValue();
				System.out.print(data[i][j]);
			}
			System.out.print("|");
		}
		System.out.println();
	}
return data;
}
}