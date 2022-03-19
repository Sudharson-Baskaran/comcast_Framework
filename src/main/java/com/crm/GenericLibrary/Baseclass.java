package com.crm.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.pomrepositoryLib.HomePage;
import com.crm.pomrepositoryLib.LoginPage;


public class Baseclass {
	//creating object of generic library classes
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public webDriverUtility wLib=new webDriverUtility();
	public static WebDriver driver=null;
   
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("DB connection===");
	}
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC()throws IOException {
		System.out.println("----Launch The Browser----");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
        //String browser = System.getProperty("BROWSER");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();	
		}
		else {
			System.out.println("Invalid browser");
		}

	}

	//login to app

	@BeforeMethod(groups = {"smokeTest","regressionTest"})

	public void configBM() throws IOException {
		String URL = fLib.readDataFromPropertyFile("url");
		//String url = System.getProperty("URL");
		wLib.maximiseWindow(driver);
		wLib.waitUntilPageLoad(driver);
		driver.get(URL);
		System.out.println("---Login into App------------");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
	    //String userName = System.getProperty("USERNAME");
	    //String password = System.getProperty("PASSWORD");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
	}
	//logout from app

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("---Logout-----");	
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}

	//close the browser
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("-------Close The Browser------");
		driver.quit();
	}

	// close DB connection

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS()
	{
		
		System.out.println("-------Close DB Connection----------");	
	}
}