package com.crm.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	WebDriver driver;
	public Organizations(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgImg;
	
	@FindBy(name = "search_text")
	private WebElement SearchBoxorg;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateorgImg() {
		return createorgImg;
	}

	public WebElement getSearchBoxorg() {
		return SearchBoxorg;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	
	

}
