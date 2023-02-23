package tests;

import testbase.TestBase;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MagentoSearchPageObjects;

public class MagentoSearch extends TestBase{
	
	String item_search = null;
	List<String> items;
	
	
	@Test(groups= {"sanity","regression"})
	@Parameters({"item_search"})
	public void MagentoSearchTest(String item_search) throws Exception {
		
		//item_search = "Bag";
		//launchBrowser("chrome");
		driver.get("https://magento.softwaretestingboard.com/");
		log("Launched the website");
		Thread.sleep(3000);
		MagentoSearchPageObjects search = new MagentoSearchPageObjects(driver);
		search.search(item_search);
		log("Entered the item to be Searched: "+item_search);
		Thread.sleep(3000);
		search.clk_submit();
		Thread.sleep(3000);
		//String total_count = search.total_itemcount();
		//int total_items = Integer.parseInt(total_count);
		//System.out.println("Total items: "+total_items);
		items = search.searched_items();
		
		System.out.println("Total Items: "+items.size());
		log("Total Items: "+items.size());
		
		for(int i =0;i <items.size();i++) {
			System.out.println(items.get(i));
		}
		
		int itemsseen_count = countItems(item_search);
		log("Items that contain searched item:  "+item_search+" "+itemsseen_count);
		Assert.assertEquals(itemsseen_count, items.size());
		
		
	}
	
	public boolean FindString(String item) throws Exception
	{
		
		boolean seen = false;
		
		for(String str : items) {
			
			if (str.contains(item)) {
				seen = true;
			}
			else 
				seen = false;			
		}
		return seen;
	}
	
	public int countItems(String item1)
	{
		int count = 0;
		for(String str : items)
		{
			if(str.contains(item1)) {
				
				count = count+1;
			}
		}
		return count;
		
	}

}
