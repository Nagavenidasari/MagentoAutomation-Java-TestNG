package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testbase.TestBase;
import pages.MagentoSortItems_PricePageObjects;
import pages.MagentoStoreMenuNavPageObjects;

public class MagentoSortItems_Price extends TestBase {
	
	List<String> price_list;
	@Test(groups= {"regression"})
	@Parameters({"item1","item2","item3","exp_title"})
	public void MagentoSortbyPriceTest(String item1,@Optional String item2, @Optional String item3,String exp_title) throws Exception {
		
		
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoStoreMenuNavPageObjects navigate = new MagentoStoreMenuNavPageObjects(driver);
		MagentoSortItems_PricePageObjects byPrice = new MagentoSortItems_PricePageObjects(driver);	
		String act_title = navigate.PerformNavigation(item1,item2,item3);
		log("ExptectedTitle : "+exp_title);
		log("ActualTitle : "+act_title);
		Assert.assertEquals(act_title, exp_title);
		byPrice.drpdwn_price();
		price_list = byPrice.items_byPrice();
		log("Total Items Present: "+price_list.size()); // logging total number of items present.		
		// checking whether the price list is sorted
		is_Sorted(price_list);
		
		
	}
	
	public void is_Sorted(List<String> items) {
		
		ArrayList<Double> price_doublelist = new ArrayList<Double>();
		Double temp;
		for(int i=0;i<items.size();i++) {
			
			temp = Double.parseDouble(items.get(i).substring(1));   // converting the string in to double and removing 1 '$'
			price_doublelist.add(temp);
					
		}
		
		
		for ( Double dbl: price_doublelist) {
			log(dbl.toString());
		}
		ArrayList<Double> temp_pricelist = new ArrayList<Double>(price_doublelist);
		Collections.sort(temp_pricelist);
		log("sorted the pricelist");
		for ( Double dbl:temp_pricelist) {
			log(dbl.toString());
		}
			
		Assert.assertEquals(price_doublelist,temp_pricelist);
			
	}
	
	
	

}
