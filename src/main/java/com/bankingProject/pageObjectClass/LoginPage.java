package com.bankingProject.pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;

	@FindBy(name ="uid")           // Finding elements by name
	WebElement userID;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name= "btnLogin")
	WebElement loginButton;
	@FindBy(name = "btnReset")
	WebElement resetButton;
	
	public LoginPage(WebDriver rdriver)                // Constructor
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);           //initialize element
	}
	
	public void setUserName(String name)            // method for username
	{
	userID.sendKeys(name);
	}
	public void setPassword(String pass)
	{
	password.sendKeys(pass);
	}
	public void loginButn()
	{
	loginButton.click();
	}
	public void resetbtn()
	{
		resetButton.click();
	}
	
}
