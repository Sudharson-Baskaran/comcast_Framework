package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.Baseclass;

@Listeners(com.crm.GenericLibrary.ListImp.class)
public class TakeScreensot extends Baseclass {
@Test
	
public void DemoClass()
{
	System.out.println("========Test Start=======");
	Assert.assertEquals(false,true);
	System.out.println("===Test End=======");

}
}
