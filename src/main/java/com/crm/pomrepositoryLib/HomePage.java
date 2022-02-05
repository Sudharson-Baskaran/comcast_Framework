package com.crm.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.webDriverUtility;

public class HomePage extends webDriverUtility {
	WebDriver driver;
	
public HomePage(WebDriver driver)
{
	
	PageFactory.initElements(driver,this);

}

@FindBy(linkText = "Organizations")
private WebElement organizationsLink;

@FindBy(linkText = "Contacts")
private WebElement  contactsLink;

@FindBy(linkText = "Opportunities")
private WebElement opportunitiesLink;

@FindBy(linkText = "Products")
private WebElement productsLink;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement administratotImg;

@FindBy(linkText ="Sign Out")
private WebElement signoutLink;



public WebElement getOrganizationsLink() {
	return organizationsLink;
}

public WebElement getContactsLink() {
	return contactsLink;
}

public WebElement getOpportunitiesLink() {
	return opportunitiesLink;
}

public WebElement getProductsLink() {
	return productsLink;
}

public WebElement getAdministratotImg() {
	return administratotImg;
}

public WebElement getSignoutLink() {
	return signoutLink;
}

public void logout(WebDriver driver) {
	mouseover(driver, administratotImg);
	signoutLink.click();
}


}
