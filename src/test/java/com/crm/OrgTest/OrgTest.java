package com.crm.OrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.Baseclass;
import com.crm.pomrepositoryLib.HomePage;
import com.crm.pomrepositoryLib.OrganizationInformationPage;
import com.crm.pomrepositoryLib.Organizations;
import com.crm.pomrepositoryLib.creatingNewOrganizationPage;
@Listeners(com.crm.GenericLibrary.ListImp.class)
public class OrgTest extends Baseclass {
	
	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException
	{
		//Read data from excel file
		int randomNumber = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("organization",1,1)+randomNumber;
		
		//navigate to org link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();

		//create new org
		Organizations org=new Organizations(driver);
		org.getCreateorgImg().click();

		creatingNewOrganizationPage cn=new creatingNewOrganizationPage(driver);
		cn.createOrganization(orgName);

		OrganizationInformationPage ip=new OrganizationInformationPage(driver);
		String succMess = ip.getSuccessfulMsg().getText();

	Assert.assertTrue(succMess.contains(orgName), "Test case failed");
	System.out.println("Test case passed");
		
	}
	@Test(groups = "regressionTest")
	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException
	{

		//Read data from excel file
		int randomNumber = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("organization",1,1)+randomNumber;
		String value = eLib.getDataFromExcel("organization",4,1);
		
		//navigate to org link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();

		//create new org
		Organizations org=new Organizations(driver);
		org.getCreateorgImg().click();

		//create org with industry dropdown
		creatingNewOrganizationPage cn=new creatingNewOrganizationPage(driver);
		cn.select(value, orgName);
		
		
		//verification step
		OrganizationInformationPage ip=new OrganizationInformationPage(driver);
		String succMess = ip.getSuccessfulMsg().getText();
		Assert.assertTrue(succMess.contains(orgName),"Test script passed");
		System.out.println("Test Script failed");
		}

}
