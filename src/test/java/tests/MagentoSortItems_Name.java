package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MagentoSortItems_NamePageObjects;
import pages.MagentoSortItems_PricePageObjects;
import testbase.TestBase;

public class MagentoSortItems_Name extends TestBase{
	
	List<String> name_list;
	
	
	@Test(groups= {"regression"})
	public void MagentoSortbyPriceTest() throws Exception {
		
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoSortItems_PricePageObjects byPrice = new MagentoSortItems_PricePageObjects(driver);
		MagentoSortItems_NamePageObjects byName = new MagentoSortItems_NamePageObjects(driver);
		byPrice.navigatetowomen();
		log("Navigating to Women");
		Thread.sleep(2000);
		byPrice.navigatetoTops();
		log("Navigating to Tops");
		Thread.sleep(2000);
		//byPrice.navigatetoJackets();
		byPrice.navigatetoBrastees();
		log("Navigating to Bras and Tees and clicking");
		Thread.sleep(2000);
		
		byName.drpdwn_name();
		name_list = byName.items_byName();
		log("Total Items Present: "+name_list.size()); // logging total number of items present.
		
		// checking whether the price list is sorted
		is_sorted(name_list);
		
		
	}
	
	public void is_sorted(List<String> items) {
		
		List<String> temp_namelist = new ArrayList<String>();
		
		for(int i=0 ; i< items.size();i++) {
			
			temp_namelist.add(items.get(i));
		}
		for(String str:items) {
			log(str);
		}
		
		Collections.sort(temp_namelist);
		
		log("SORTED NAMELIST");
		for ( String str1:temp_namelist) {
			log(str1);
		}
		
		Assert.assertEquals(items,temp_namelist);
		
	}
}
	
		


