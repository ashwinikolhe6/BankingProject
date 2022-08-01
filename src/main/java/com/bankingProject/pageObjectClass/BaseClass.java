package com.bankingProject.pageObjectClass;



import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingProject.utilities.ReadConfig;

public class BaseClass
{
	public static WebDriver driver;
	
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
    public static ExtentTest test;
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	
	@BeforeSuite
	public void setReport()
	{
		Random random = new Random();
		int x = random.nextInt(100);
	    sparkreporter = new ExtentSparkReporter("C:/Users/Admin/eclipse-workspace/BankingProject/reports/htmlreport"+ x +".html");
		extent = new ExtentReports();
		
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Operating System", "Windows");
		extent.setSystemInfo("Environment", "QA");
		sparkreporter.config().setReportName("Integration Test Execution");
		sparkreporter.config().setDocumentTitle("QA Automation Testing Report");
		sparkreporter.config().setTheme(Theme.DARK);
	}
	
	@Parameters("browser")                // added for browser testing
	@BeforeMethod
	public void setup(String str)
	{
		    
	   if (str.equals("chrome")) {
	    System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver.exe");
	    driver = new ChromeDriver();
	   } 
	   else if (str.equals("firefox")) {
		   System.setProperty("webdriver.gecko.driver","C:/Users/Admin/Downloads/geckodriver.exe");
		    driver = new FirefoxDriver();
	   }
	   else if (str.equals("internetexplorer")) {
		   System.setProperty("webdriver.ie.driver","C:/Users/Admin/Downloads/IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
	   }
	 
	}
	
	public static String captureScreen() throws IOException
	{
		Random random = new Random();
		int x = random.nextInt(100);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = "C:/Users/Admin/eclipse-workspace/BankingProject/screenshot/"+ x +".png";
		
		FileUtils.copyFile(source, new File(dest));
		
		return dest;
	}
	
	@AfterMethod
	public void closebrowser()
	{
	driver.quit();
	}
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();                           // To close report
	}


}
