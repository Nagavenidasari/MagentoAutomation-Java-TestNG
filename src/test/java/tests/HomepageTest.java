package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;

public class HomepageTest extends TestBase {
	
	
	@Test
	public void Homepagetest() throws Exception {
			
		log("Launching Magento Website");
		launchBrowser("CHROME");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		String acttitle=driver.getTitle();
		System.out.println(acttitle);
		String expectitle="Home Page - Magento eCommerce";
		Assert.assertEquals(acttitle, expectitle);
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void verifyLogo() throws Exception {
		
		launchBrowser("CHROME");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		boolean img = driver.findElement(By.xpath("//a[@class='logo']")).isDisplayed();
		System.out.println(img);
		if(img == true) {
			log("Logo is displayed");
			logger.createNode("Logo is Present");
			Assert.assertTrue(img);
		}else{
			log("Logo is not displayed");
			logger.createNode("Logo is not Present");
			Assert.assertFalse(img);		}
		
		Thread.sleep(3000);
		
	}

}
