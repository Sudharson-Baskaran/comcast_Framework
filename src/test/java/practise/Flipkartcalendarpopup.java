package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Flipkartcalendarpopup {
@Test
public void calendarTest() 
{
	
ChromeOptions option = new ChromeOptions();
option.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(option);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
driver.findElement(By.xpath(" //div[text()='Travel']")).click();
driver.findElement(By.xpath(" //input[@class='_1w3ZZo _2gKfhi _2mFmU7']")).click();
try {
driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='PgmDJX']/descendant::button[text()='10']")).click();
}
catch (Exception e) {
	
}




}

}
