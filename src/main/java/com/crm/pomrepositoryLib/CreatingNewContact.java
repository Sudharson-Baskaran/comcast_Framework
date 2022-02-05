package com.crm.pomrepositoryLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.webDriverUtility;

public class CreatingNewContact extends webDriverUtility {
	WebDriver driver;
	public CreatingNewContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement LastNametbx;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement SelectOrgimg;
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/../img")
	private WebElement OrgNameSelectImg;

	public WebElement getOrgNameSelectImg() {
		return OrgNameSelectImg;
	}

	public WebElement getLastNametbx() {
		return LastNametbx;
	}

	public WebElement getSelectOrgimg() {
		return SelectOrgimg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void createContact(String LastName)
	{
		
		SelectOrgimg.click();
		LastNametbx.sendKeys(LastName);
		SaveBtn.click();
	}

	/**
	 * This method is used to create contact with org
	 * @param orgName
	 * @param LastName
	 * @throws InterruptedException 
	 */
	
	public void createContact(String orgName,String LastName)
	{
		LastNametbx.sendKeys(LastName);
		OrgNameSelectImg.click();
	    switchToWindow(driver,"Accounts&action");
		Organizations op=new Organizations(driver);
		op.getSearchBoxorg().sendKeys(orgName);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		SaveBtn.click();
	}
}
