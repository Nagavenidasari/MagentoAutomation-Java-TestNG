package tests;


import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.MagentoStoreMenuNavPageObjects;
import testbase.TestBase;

public class MagentoStoreNavigationTest extends TestBase{
	
	@Test(groups={"regression"})
	@Parameters({"item1","item2","item3","exp_title"})
	public void NavigationTest(String item1,@Optional String item2, @Optional String item3,String exp_title) throws Exception {
		
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoStoreMenuNavPageObjects navigate = new MagentoStoreMenuNavPageObjects(driver);
		String act_title = navigate.PerformNavigation(item1,item2,item3);
		log("ExptectedTitle : "+exp_title);
		log("ActualTitle : "+act_title);
		Assert.assertEquals(act_title, exp_title);
		
		
		
	}

}
