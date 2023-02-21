package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MagentoCreateAccountPageObjects;
import testbase.TestBase;

public class MagentoCreateAccountTest extends TestBase{
	
	@Test
	public void MagentocreateAccount() throws Exception {
		
		launchBrowser("chrome");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoCreateAccountPageObjects create = new MagentoCreateAccountPageObjects(driver);
		create.clkCreateAccount();
		String f_name = firstname();
		String l_name = lastname();
		String email = f_name+"."+l_name+"@example.com";
		String password = "Test@1234";
		create.setFname(f_name);
		log("Set firstname");
		create.setLname(l_name);
		log("Set lastname");
		create.setEmail(email);
		log("Set email");
		create.setPassword(password);
		log("Set password");
		Thread.sleep(3000);
		create.clkSubmit();
		boolean msg = create.verifyAlertmsg();
		System.out.println(msg);
		if(msg == true) {
			logger.createNode("User is Created");
			Assert.assertTrue(msg);
		}else if(msg == false){
			logger.createNode("User is not Created");
			Assert.assertFalse(msg);		}
		
		Thread.sleep(3000);

			
	}
	

public String firstname() {
	
	Random random = new Random();
	String[] firstNames = {"John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Robin","Bob","Sarah","Natalie","Krishna"};
	String randomfname = firstNames[random.nextInt(firstNames.length)];
	return randomfname;
}
public String lastname() {
	String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood","Patel","Simson","Dennis"};
	Random random = new Random();
	String randomlname = lastNames[random.nextInt(lastNames.length)];
	return randomlname;
}
	
	

}
