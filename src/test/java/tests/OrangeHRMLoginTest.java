package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.OrangeHRMLoginPageObjects;
import testbase.TestBase;



public class OrangeHRMLoginTest extends TestBase{
	
	@Test
	public void LoginTest() throws Exception {
		
		
		launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log("Launched ORANGEHRM website");
		Thread.sleep(2000);
		OrangeHRMLoginPageObjects hrm= new OrangeHRMLoginPageObjects(driver);
		log("Set username: Admin");
		hrm.set_username("Admin");
		log("Set username: admin123");
		hrm.set_password("admin123");
		log("click login");
		hrm.clk_submit();
		String exp_title = "OrangeHRM";
		String act_title = hrm.get_title();
		log("Actual Title: "+act_title);
		log("Expected Title: "+exp_title);
		Assert.assertEquals(act_title, exp_title);
		log("Click on profile");
		hrm.clk_profile();
		log("Click Logout");
		hrm.clk_logout();
		String exp_title1 = "OrangeHRM";
		String act_title1 = hrm.get_title();
		log("Actual Title: "+act_title1);
		log("Expected Title: "+exp_title1);
		Assert.assertEquals(act_title1, exp_title1);
		
		
		
	}
	
	
	
	

}
