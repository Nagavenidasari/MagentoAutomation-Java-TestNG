package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MagentoSearchPageObjects;
import pages.MagentoSortItems_PricePageObjects;
import pages.MagentoStoreMenuNavPageObjects;
import pages.SelectingSizefromShoppingOptionsPageObjects;
import testbase.TestBase;

public class MagentoSelectSizeShoppingoptionsTest extends TestBase {
	
	String size_search ;
	
	
	@Test
	@Parameters({"size_search","item1","item2","item3","exp_title"})
	public void SelectSizeTest(String size_search,String item1,@Optional String item2, @Optional String item3,String exp_title) throws Exception {
				
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		SelectingSizefromShoppingOptionsPageObjects size= new SelectingSizefromShoppingOptionsPageObjects(driver);
		MagentoStoreMenuNavPageObjects navigate = new MagentoStoreMenuNavPageObjects(driver);
		String act_title = navigate.PerformNavigation(item1,item2,item3);
		log("ExptectedTitle : "+exp_title);
		log("ActualTitle : "+act_title);
		Assert.assertEquals(act_title, exp_title);
		log("Slecting the size options");
		size.clkSizeOptions();
		Thread.sleep(2000);
		log("Slecting the size: "+size_search);
		Thread.sleep(2000);
		boolean is_selected = size.isSelectedSize(size_search);
		Thread.sleep(2000);
		Assert.assertTrue(is_selected);
		
		
	}

}
