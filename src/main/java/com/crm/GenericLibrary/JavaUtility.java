package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * This class will have all the generic methods related to java
 * @author romeo
 *
 */

public class JavaUtility {
/**
 * This method will generate a random number and returns it to the caller
 * @return
 */
public int getRandomNumber() {
	Random ran=new Random();
	int random = ran.nextInt(10000);
	return random;
}
/**
 * This method will return the current date in String format
 * @return
 */
public String getCurrentDate()
{
Date date=new Date();
String currentdate = date.toString();
return currentdate;

}
/**
 * This method will return the date in specified format
 * @return
 */
public String getFinalDateFormat()
{
	Date date=new Date();
	String d = date.toString();
	String[] dte = d.split(" ");
	String YYYY=dte[5];
	String DD=dte[2];
	String MM=dte[1];
	String today=YYYY+"-"+MM+"-"+DD;
	return today;
	}
/**
 * used to press enter key
 * @throws AWTException
 */
public void pressEnterKey() throws AWTException
{
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);;




}
}
