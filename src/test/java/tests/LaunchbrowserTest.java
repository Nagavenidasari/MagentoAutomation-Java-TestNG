package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbase.TestBase;

public class LaunchbrowserTest extends TestBase{
	
	
	@Test
	public void browserTest() throws Exception {
		
		
		//logger = extent.createTest("Launching browserTest");
		
		//log("Launching the browser");
		//test.log(Status.INFO,"Launching the browser");
		launchBrowser("chrome");
		//log("Entering the URL (magento)");
		//test.log(Status.INFO,"Entering the URL (magento)");
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		Assert.assertTrue(true);
		//logPass("Test Passed");
		
		
		
	}

}
