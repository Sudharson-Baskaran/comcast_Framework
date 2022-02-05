package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp extends JavaUtility implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String failedTest=result.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(Baseclass.driver);
		File src=eDriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+failedTest+""+getFinalDateFormat()+".png");
		try {
		FileUtils.copyFile(src, dest);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		}
		
	}
	


