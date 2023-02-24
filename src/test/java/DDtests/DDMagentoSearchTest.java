package DDtests;

import testbase.TestBase;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MagentoSearchPageObjects;

public class DDMagentoSearchTest extends TestBase{
	
	String item_search = null;
	List<String> items;
	
	
	@Test(groups= {"sanity","regression"},dataProvider = "Searchtestdata")
	@Parameters("browserName")
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
		if(items == null) {
			
			log("No items are available & alert message is displayed");
			Assert.assertEquals(null, items);
		}
		else {
		
		System.out.println("Total Items: "+items.size());
		log("Total Items: "+items.size());
		
		for(int i =0;i <items.size();i++) {
			log(items.get(i));
		}
		
		int itemsseen_count = countItems(item_search);
		log("Items that contain searched item:  "+item_search+" "+itemsseen_count);
		Assert.assertEquals(itemsseen_count, items.size());
		}
			
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
	
	@DataProvider(name = "Searchtestdata")
	public Object[][] getData() {
		
		String excelPath= "C:\\Users\\nagav\\eclipse-workspace\\AutomationStepByStep\\MagentoSelenium\\excel\\data.xlsx";
		Object[][] data = testData(excelPath,"Sheet2");
		return data;
		
	}
	//public static void main
	
	public Object[][] testData(String excelPath,String sheetName) //object for ExcelUtils class.
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName); // open the file
		int rowCount=excel.getRowCount(); // get row count
		int colCount=excel.getColCount(); // get colcount
		
		// storing the value in object array.Why object array is as data can be in any type(string,int,float etc)
		Object data[][] = new Object[rowCount-1][colCount]; 
		
		for(int i=1;i< rowCount;i++) //we have to start from index 1 as index 0 has headers in the excel table.
		{
			for(int j=0;j<colCount;j++) 
			{
				String cellData = excel.getCellDataString(i,j);
				//System.out.print(cellData+" | ");
				data[i-1][j]=cellData;
			}
			//System.out.println();
			
		}
		return data;
	}



}
