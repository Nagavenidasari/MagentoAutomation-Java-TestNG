package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MagentoSearchPageObjects;
import pages.MagentoSortItems_PricePageObjects;
import pages.SelectingSizefromShoppingOptionsPageObjects;
import testbase.TestBase;

public class MagentoSelectSizeShoppingoptionsTest extends TestBase {
	
	String size_search ;
	
	
	@Test
	@Parameters({"size_search"})
	public void SelectSizeTest(String size_search) throws Exception {
				
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		SelectingSizefromShoppingOptionsPageObjects size= new SelectingSizefromShoppingOptionsPageObjects(driver);
		MagentoSortItems_PricePageObjects navigate = new MagentoSortItems_PricePageObjects(driver);
		navigate.navigatetowomen();
		log("Navigating to Women");
		Thread.sleep(2000);
		navigate.navigatetoTops();
		log("Navigating to Tops");
		Thread.sleep(2000);;
		navigate.navigatetoBrastees();
		log("Navigating to Bras and Tees");
		Thread.sleep(2000);
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
