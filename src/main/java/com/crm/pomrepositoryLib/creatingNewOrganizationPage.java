package com.crm.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLibrary.webDriverUtility;

public class creatingNewOrganizationPage extends webDriverUtility{

	WebDriver driver;
	public creatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameTbx;

	@FindBy(name="industry")
	private WebElement industryDd;

	@FindBy(name="accounttype")
	private WebElement typeDd;

	@FindBy(name="button")
	private WebElement saveBtn;
	
	
	

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgNameTbx() {
		return orgNameTbx;
	}
	public WebElement getIndustryDd() {
		return industryDd;
	}
	public WebElement getTypeDd() {
		return typeDd;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * This method is used to create new organization
	 * @param orgName
	 */
	public void createOrganization(String orgName)
	{
		orgNameTbx.sendKeys(orgName);
		saveBtn.click();

	}
	/**
	 * This method is used to select option from industry dropdown and save
	 * @param value
	 * @param element
	 */
	public void select(String orgName,String value)
	{
		
		orgNameTbx.sendKeys(orgName);
		Select s=new Select(industryDd);
		s.selectByValue(value);
		saveBtn.click();
	}
	

	/**
	 * This method is used to select option from type dropdown
	 * @param value
	 * @param element
	 */
	public void typeDropDown(String value,WebElement element)
	
	{
		select(value, element);	

	}
}





