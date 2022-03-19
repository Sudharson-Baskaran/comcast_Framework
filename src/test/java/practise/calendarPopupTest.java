package practise;

import java.time.LocalDateTime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import com.mysql.cj.result.LocalDateTimeValueFactory;

public class calendarPopupTest {
	@Test
	public void calenderTest()
	{
		String date="10";
		String yearAndMonth="March 2022";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		Actions action = new Actions(driver);
		action.moveByOffset(20,10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		WebElement dateXpath = driver.findElement(By.xpath("//div[text()='"+yearAndMonth+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']"));
		dateXpath.click();



	}

}
