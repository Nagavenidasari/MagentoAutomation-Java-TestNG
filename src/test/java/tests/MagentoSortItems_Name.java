package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MagentoSortItems_NamePageObjects;
import pages.MagentoSortItems_PricePageObjects;
import pages.MagentoStoreMenuNavPageObjects;
import testbase.TestBase;

public class MagentoSortItems_Name extends TestBase{
	
	List<String> name_list;
	
	
	@Test(groups= {"regression"})
	@Parameters({"item1","item2","item3","exp_title"})
	public void MagentoSortbyNameTest(String item1,@Optional String item2, @Optional String item3,String exp_title) throws Exception {
		
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoStoreMenuNavPageObjects navigate = new MagentoStoreMenuNavPageObjects(driver);
		MagentoSortItems_NamePageObjects byName = new MagentoSortItems_NamePageObjects(driver);
		String act_title = navigate.PerformNavigation(item1,item2,item3);
		log("ExptectedTitle : "+exp_title);
		log("ActualTitle : "+act_title);
		Assert.assertEquals(act_title, exp_title);
		
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
		
		log("SORTED NAMELIST:");
		for ( String str1:temp_namelist) {
			log(str1);
		}
		
		Assert.assertEquals(items,temp_namelist);
		
	}
}
	
		


