package com.bankingProject.testClass;


import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bankingProject.pageObjectClass.BaseClass;
import com.bankingProject.pageObjectClass.LoginPage;

public class TC_001_loginTest extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
	try {
    	LoginPage login = new LoginPage(driver);
	
	    test = extent.createTest("Verify application login");
	
	    driver.get(baseURL);
	
	    test.log(Status.PASS, "URL entered successfully");
	    
	    login.setUserName(username);
	    test.log(Status.PASS, "Username entered successfully");
	    
	    login.setPassword(password);
	    test.log(Status.PASS, "Password entered successfully");
	   
	    login.loginButn();
	    test.log(Status.PASS, "Login button clicked successfully");
	
	
	String pageTitle = "GTPL Bank Manager HomePage";
	
	if (driver.getTitle().equals(pageTitle))
	{
		test.log(Status.PASS, "Title verified and user logged in successfully");
		
	} else {
		      test.log(Status.FAIL, "login failed");
		      String screenshotpath = BaseClass.captureScreen();
			  test.addScreenCaptureFromPath(screenshotpath);
	       }
	}catch (Exception e)
	{
		test.log(Status.FAIL, "Login failed");
		String screenshotpath = BaseClass.captureScreen();
		test.addScreenCaptureFromPath(screenshotpath);
	}
	
	}

}
