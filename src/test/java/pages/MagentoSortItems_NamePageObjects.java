package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class MagentoSortItems_NamePageObjects {
	
	WebDriver driver ;
	

	public MagentoSortItems_NamePageObjects(WebDriver driver) {
		this.driver = driver;
		
		
		
	}
	
	By drpdown_sortby = By.id("sorter");
	By txt_name = By.xpath("//strong[@class='product name product-item-name']/a");
	By pages = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[4]/div[2]/ul/li/a/span[2]");
	By sibling_page = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[4]/div[2]/ul/li[2]/a");
			
	
	public void drpdwn_name() throws Exception {
		
		Select se = new Select(driver.findElement(drpdown_sortby));
		se.selectByValue("name");
		Thread.sleep(2000);
	}
	

	public List<String> items_byName() throws Exception{
		
		//MagentoSearchPageObjects search = new MagentoSearchPageObjects(driver);
		int total_pages = pages();
		ArrayList<String> items_Pricelist = new ArrayList<String>();
		List<WebElement> myList ;
		
		if(total_pages == 0) {
		
			myList = driver.findElements(txt_name);
			for(int i=0; i< myList.size(); i++){
	
		        //loading text of each element in to array all_elements_text
				items_Pricelist.add(myList.get(i).getText());
		       
			}return items_Pricelist;
		}
		else {
			
			myList = driver.findElements(txt_name);
			for(int i=0; i< myList.size(); i++){
				//loading text of each element in to array all_elements_text
				items_Pricelist.add(myList.get(i).getText());   
				}
		
			for(int j=1 ;j<=total_pages-1;j++) {
				JavascriptExecutor Js1 = (JavascriptExecutor) driver;
				Js1.executeScript("window.scrollBy(0,2500)");  
				Thread.sleep(2000);
				driver.findElement(sibling_page).click();
				Thread.sleep(2000);
				myList=driver.findElements(txt_name);
				for(int i=0; i< myList.size(); i++){
				        //loading text of each element in to array all_elements_text
					items_Pricelist.add(myList.get(i).getText());
	
					//}				
				}
			}
				
		}return items_Pricelist;
		
	}
	
	public int pages() {
		
		List<WebElement> myList1 = driver.findElements(pages); // get all the pagenumber counts
		int pages_count = myList1.size();
		System.out.println("Pages Count: "+pages_count);
		ArrayList<String> all_elements_text1= new ArrayList<String>();
		
		for(int i=0; i< myList1.size(); i++){
	        //loading text of each element in to array all_elements_text
	        all_elements_text1.add(myList1.get(i).getText());
	        System.out.println("Page numbers : "+all_elements_text1.get(i));

		}
		return pages_count;
	}

}
