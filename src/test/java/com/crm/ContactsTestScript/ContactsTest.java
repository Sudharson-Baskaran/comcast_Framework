package com.crm.ContactsTestScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.Baseclass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.webDriverUtility;
import com.crm.pomrepositoryLib.ContactInformationPage;
import com.crm.pomrepositoryLib.CreatingNewContact;
import com.crm.pomrepositoryLib.HomePage;
import com.crm.pomrepositoryLib.LoginPage;
import com.crm.pomrepositoryLib.OrganizationInformationPage;
import com.crm.pomrepositoryLib.Organizations;
import com.crm.pomrepositoryLib.creatingNewOrganizationPage;
@Listeners(com.crm.GenericLibrary.ListImp.class)
public class ContactsTest extends Baseclass {
	
	@Test(groups = "smokeTest")
	public void createContactsTest() throws IOException {

		//Read data from excel file
		int randomNumber = jLib.getRandomNumber();
		String LastName= eLib.getDataFromExcel("contact",1,2)+jLib.getRandomNumber();

		//navigate to contacts link
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();

		//create new contact
		CreatingNewContact cn=new CreatingNewContact(driver);
		cn.createContact(LastName);

		//capture header in contact information page
		ContactInformationPage cp=new ContactInformationPage(driver);
		String succMess = cp.getSuccessMss().getText();

		//compare success with last name

		Assert.assertTrue(succMess.contains(LastName), "Testscript failed");
		System.out.println("Testscript passed");


	}
	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws IOException{

		//Read data from excel file
		int randomNumber = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("contact",4,3)+randomNumber;
		String LastName = eLib.getDataFromExcel("contact",4,2)+randomNumber;

		//navigate to org link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();

		//create new org
		Organizations org=new Organizations(driver);
		org.getCreateorgImg().click();
		creatingNewOrganizationPage cnorg=new creatingNewOrganizationPage(driver);
		cnorg.createOrganization(orgName);

		//Navigate to contact link
		OrganizationInformationPage ip=new OrganizationInformationPage(driver);
		wLib.visibilityOfElement(driver,ip.getSuccessfulMsg());
		hp.getContactsLink().click();

		//create new contact
		CreatingNewContact cn=new CreatingNewContact(driver);
		cn.getSelectOrgimg().click();


		//creating contact with org name
		cn.createContact(orgName, LastName);
		ContactInformationPage cip=new ContactInformationPage(driver);
		String succMess = cip.getOrgNameTbx().getText();
		String succMesscontact = cip.getSuccessMss().getText();

		//comparing succMess with orgName
		Assert.assertTrue(succMess.trim().equals(orgName.trim()), "Testscipt failed");
		System.out.println(orgName+"is created successfully Testscript passed");

		//comparing succMess on contactsinfopage
		Assert.assertTrue(succMesscontact.contains(LastName),"Testscript Failed");
		System.out.println(LastName+" is created succesfully and Testscirpt passed");


	}

}
