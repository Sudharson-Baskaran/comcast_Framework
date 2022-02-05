package com.crm.pomrepositoryLib;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.graphbuilder.math.func.LgFunction;

public class LoginPage {
	WebDriver driver;
	
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);

}
	
@FindBy(name="user_name")
WebElement userNametbx;

@FindBy(name="user_password")
WebElement passwordtbx;

@FindBy(id="submitButton")
WebElement loginbtn;

@FindBy(xpath="//a[.='Read License']" )
WebElement licenseLink;

@FindBy(xpath="//a[.='Privacy Policy']")
WebElement privacyPloicyLink;

public WebDriver getDriver() {
	return driver;
}



public WebElement getUserNametbx() {
	return userNametbx;
}



public WebElement getPasswordtbx() {
	return passwordtbx;
}



public WebElement getLoginbtn() {
	return loginbtn;
}



public WebElement getLicenseLink() {
	return licenseLink;
}



public WebElement getPrivacyPloicyLink() {
	return privacyPloicyLink;
}



/**
 * This buisness method is used to login to application
 * @param username
 * @param password
 */
public void loginToApp(String username,String password)
{
	
	userNametbx.sendKeys(username);
	passwordtbx.sendKeys(password);
	loginbtn.click();

}
}
