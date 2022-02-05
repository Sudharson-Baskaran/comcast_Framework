package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**\
 * This class contains webdriver generic methods
 * @author romeo
 *
 */

public class webDriverUtility {
	/**
	 * This method is wait for 20secs for page loading
	 * @param driver
	 */
	String title;
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	/**
	 * This method wait 20secs until the element is visible
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClick(WebDriver driver,WebElement element) throws InterruptedException
	{
		int count=0;
		while (count<20) {
			try {
				element.click();
				break;
			} 
			catch (Throwable t) {
				Thread.sleep(1000);
				count++;
			}

		}


	}

	/**
	 * This method is used to handle dropdown by using visible text
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String option) {

		Select s=new Select(element);
		s.selectByVisibleText(option);
	}

	/**
	 * This method is used to handle dropdown by using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to handle dropdown by using value
	 */
	public void select(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);

	}
	/**
	 * This method is used to handle dropdown for deselecting all options
	 */
	public void deselectAll(WebElement element,int index) {
		Select s=new Select(element);
		s.deselectAll();

	}
	/**
	 * This method is used to perform mouseover action
	 * @param driver
	 * @param element
	 */

	public void mouseover(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform double click
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element);
	}
	/**
	 * This method is used to perform right click
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element);
	}
/**
 * This method is used to switch to required window
 * @param driver
 * @param partialWinTitle
 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{

		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();

		while(itr.hasNext())
		{
			String windId = itr.next();	
			String title = driver.switchTo().window(windId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	
	}


	/**
	 * This method is used to accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.accept();
	}

	/**
	 * This method is used to dismiss alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.dismiss();

	}
	/**
	 *  This method used for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebelement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		j.executeScript("window.scroll(0,"+y+")",element);

	}
	/**
	 * This method is used to handle frames by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrames(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to perform actions on frames by using name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrames(WebDriver driver,String nameOrId) {

		driver.switchTo().frame(nameOrId);

	}
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws IOException 
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/screenshotName.png");
		Files.copy(src,dest);

	}
	/**
	 * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	} 
	/**
	 * This method is used to maximize the browser window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void elementIsClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
				
		
	}

}
