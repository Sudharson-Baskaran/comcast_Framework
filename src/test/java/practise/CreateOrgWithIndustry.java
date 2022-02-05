package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.Baseclass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.webDriverUtility;
import com.crm.pomrepositoryLib.HomePage;
import com.crm.pomrepositoryLib.Organizations;
import com.crm.pomrepositoryLib.creatingNewOrganizationPage;



public class CreateOrgWithIndustry {
	String orgName;
	String value;
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public webDriverUtility wLib=new webDriverUtility();
	
@Test(groups = "smokeTest",dataProvider = "dataProviderCreateOrg")

public void createOrg(String orgName,String value) {
	
	
	//openbrowser
	WebDriver driver=new ChromeDriver();
	//enter url
	driver.get("http://localhost:8888/");
	//login to app
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	WebElement listbox = driver.findElement(By.name("industry"));
	Select s=new Select(listbox);
	s.selectByValue(value);

	
	
}
	@DataProvider
	public Object[][] dataProviderCreateOrg() throws EncryptedDocumentException, IOException {
		
	Object[][] obj=new Object[4][2];
	int rowCount=eLib.getRowCount("dataprovider");
	System.out.println(rowCount);
	for (int i = 0; i <rowCount; i++) {
		obj[i][0]=eLib.getDataFromExcel("dataprovider",i, 0);
		String orgName=(String) obj[i][0];
		System.out.println(orgName);
		obj[i][1]=eLib.getDataFromExcel("dataprovider",i,1);
		String value=(String) obj[i][1];
		System.out.println(value);
	}
		return obj;
	}
	

}
