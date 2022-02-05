package com.crm.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
public ContactInformationPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement SuccessMss;

@FindBy(id = "mouseArea_Organization Name")
private WebElement OrgNameTbx;

public WebElement getOrgNameTbx() {
	return OrgNameTbx;
}

public WebElement getSuccessMss() {
	return SuccessMss;
}
}
