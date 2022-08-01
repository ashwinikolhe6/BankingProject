package com.bankingProject.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig()
	{
		  //object of file class
		File src = new File("C:/Users/Admin/eclipse-workspace/BankingProject/configuration/config.properties");      
	
	    FileInputStream file;           //object created
	    try {
	    	   file = new FileInputStream(src); 
	           pro = new Properties();              //object created
	           pro.load(file);
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        }
	}
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String usern = pro.getProperty("username");
		return usern;
	}
	public String getPassword()
	{
		String pass = pro.getProperty("password");
		return pass;
	}
}
