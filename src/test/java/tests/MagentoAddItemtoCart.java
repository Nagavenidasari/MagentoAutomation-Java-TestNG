package tests;

import testbase.TestBase;
import pages.MagentoSearchPageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MagentoAdditemstoCartPageObjects;

public class MagentoAddItemtoCart extends TestBase{
	
	
	@Test(groups= {"regression"})
	public void MagentoAddItemsTest() throws Exception {
		
		//launchBrowser("chrome");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(2000);
		MagentoSearchPageObjects searchitem = new MagentoSearchPageObjects(driver);
		MagentoAdditemstoCartPageObjects additem = new MagentoAdditemstoCartPageObjects(driver);
		
		searchitem.search("Bag");
		Thread.sleep(2000);
		searchitem.clk_submit();
		Thread.sleep(2000);
		additem.add_firstitem();
		Thread.sleep(1000);
		additem.add_tocart();
		log("Bag added in the cart");
		
		Thread.sleep(2000);
		searchitem.search("Pant");
		Thread.sleep(1000);
		searchitem.clk_submit();
		additem.add_firstitem();
		Thread.sleep(1000);
		additem.set_size32();
		Thread.sleep(1000);
		additem.set_colorblack();
		Thread.sleep(1000);
		additem.add_tocart();
		log("Pant added in the cart");

		Thread.sleep(2000);
		searchitem.search("Shorts");
		Thread.sleep(1000);
		searchitem.clk_submit();
		additem.add_seconditem();
		additem.set_size30();
		additem.set_colorred();
		Thread.sleep(1000);
		additem.add_tocart();
		log("Shorts added in the cart");
				
		Thread.sleep(2000);
		int cart_counter = additem.show_carrt();
		
		Thread.sleep(2000);
		int checkcart_counter = additem.check_cart();
		log("Items displayed near the cart image: "+cart_counter+" and Items in the cart page: "+checkcart_counter);
		Assert.assertEquals(cart_counter,checkcart_counter);
		
	}

}
