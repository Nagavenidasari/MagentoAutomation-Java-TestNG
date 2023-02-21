package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MagentoLoginPageObjects;
import testbase.TestBase;

public class MagentoLoginTest extends TestBase{
	
	
	@Test
	public void MagentoLogintest() throws Exception {
		
		//logger = extent.createTest("Login Test");
		launchBrowser("chrome");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoLoginPageObjects loginpage = new MagentoLoginPageObjects(driver);
		loginpage.clkSigninlnk();
		loginpage.setUsetname("roni_cost@example.com");
		log("Entered Username");
		loginpage.setPassword("roni_cost3@example.com");
		log("Entered Password");
		Thread.sleep(2000);
		loginpage.clkbtnSignin();
		Thread.sleep(2000);
		String act_msg = loginpage.alertMessage();
		String exp_msg = "Incorrect CAPTCHA";
		Assert.assertEquals(act_msg, exp_msg);
		Thread.sleep(3000);
		
		
	}
	
	

}
