package practise;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CurrentDateCalendarPopupTest {
	
@Test
public void calendarTest() {
	
 LocalDateTime sysDate = LocalDateTime.now();
 int date = sysDate.getDayOfMonth();
 System.out.println(date);
 String month = sysDate.getMonth().toString();
 String actMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
 
 int year = sysDate.getYear();
 String finalMonth=actMonth+" "+year;
 
 WebDriver driver = new ChromeDriver();
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 driver.manage().window().maximize();
 driver.get("https://www.makemytrip.com/");
 Actions action = new Actions(driver);
 action.moveByOffset(10, 10).click().perform();
 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
 driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
 WebElement datexpath = driver.findElement(By.xpath("//div[text()='"+finalMonth+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']"));
	       

	
	
	
	
}

}
