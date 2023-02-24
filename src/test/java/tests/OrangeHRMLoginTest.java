package tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.OrangeHRMLoginPageObjects;
import testbase.TestBase;



public class OrangeHRMLoginTest extends TestBase{
	
	@Test(groups= {"smoke","regression"})
	public void LoginTest() throws Exception {
		
		OrangeHRMLoginPageObjects hrm= new OrangeHRMLoginPageObjects(driver);
		//launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log("Launched ORANGEHRM website");
		log("Set username: Admin");
		hrm.set_username("Admin");
		log("Set password: admin123");
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
	
	@Test(groups= {"smoke","regression"})
	@Parameters({"username","password"})
	public void InvalidLoginTest(String username,String password) throws Exception {
		
		OrangeHRMLoginPageObjects hrm= new OrangeHRMLoginPageObjects(driver);
		//launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log("Launched ORANGEHRM website");
		Thread.sleep(2000);
		
		log("Set username: "+username);
		hrm.set_username(username);
		log("Set username: "+password);
		hrm.set_password(password);
		log("click login");
		hrm.clk_submit();
		String exp_error = "Invalid credentials";
		String act_error = hrm.invalid_login();
		log("Actual Error: "+act_error);
		log("Expected Error: "+exp_error);
		Assert.assertEquals(act_error, exp_error);
		
		
		
	}
	
	
	
	
	

}
