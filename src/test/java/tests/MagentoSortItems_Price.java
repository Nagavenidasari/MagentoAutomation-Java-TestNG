package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;
import pages.MagentoSortItems_PricePageObjects;

public class MagentoSortItems_Price extends TestBase {
	
	List<String> price_list;
	@Test(groups= {"regression"})
	public void MagentoSortbyPriceTest() throws Exception {
		
		//launchBrowser("chrome");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoSortItems_PricePageObjects byPrice = new MagentoSortItems_PricePageObjects(driver);
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
		byPrice.drpdwn_price();
		price_list = byPrice.items_byPrice();
		log("Total Items Present: "+price_list.size()); // logging total number of items present.
		/*for(int i =0;i < price_list.size();i++) {
			System.out.println(Double.parseDouble(price_list.get(i).substring(1)));
		}*/
		
		// checking whether the price list is sorted
		is_Sorted(price_list);
		
		
	}
	
	public void is_Sorted(List<String> items) {
		
		ArrayList<Double> price_doublelist = new ArrayList<Double>();
		//List<Double> temp_pricelist = new ArrayList<Double>(price_doublelist);
		//Double[] price_doublelist ;
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
