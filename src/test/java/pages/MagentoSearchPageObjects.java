package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MagentoSearchPageObjects {
	
	WebDriver driver = null;
	
	public MagentoSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By txt_search = By.id("search");
	By btn_search = By.xpath("//button[@type='submit']");
	By list_sortitems = By.xpath("//a[@class ='product-item-link']");
	By total_items = By.xpath("//*[@id='toolbar-amount']/span[3]");
	By page_single = By.xpath("//*[@id='toolbar-amount']/span");
	By page_next = By.xpath("//a[@class='action  next']");
	//By pages = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li");
	By pages = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li/a/span[2]");
	By pages_bar =By.xpath("//ul[@class='items pages-items']");
	By msg_notice = By.xpath("//*[@class='message notice']");
	//By sibling_page = By.xpath("//div/ul/li[@class='item current']//following-sibling::li[1]/a");
	By sibling_page = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li[@class='item current']//following-sibling::li[1]/a");
	
	
	
	
	public void search(String item) {
		
		driver.findElement(txt_search).sendKeys(item);
			
	}
	public void clk_submit() {
		
		driver.findElement(btn_search).sendKeys(Keys.RETURN);
		
	}
	
	public String total_itemcount() {
		
		String total_count = driver.findElement(total_items).getText();
		
		return total_count;
	}
	
	public List<String> searched_items() throws Exception {
		
		ArrayList<String> all_elements_text= new ArrayList<String>();
		int total_pages = pages();
		//int total_items = Integer.parseInt(total_itemcount());
		List<WebElement> myList ;
		//boolean pages_footer = isElementDisplayed();
		//System.out.println(pages_footer);
		
		//only current page is available 
		if(total_pages == 0) {
			
			
			myList = driver.findElements(list_sortitems);
			for(int i=0; i< myList.size(); i++){

	        //loading text of each element in to array all_elements_text
				all_elements_text.add(myList.get(i).getText());
	       
		}return all_elements_text;
			// navigating through multiple pages and collecting the items.
		}else {
			
			myList = driver.findElements(list_sortitems);
			for(int i=0; i< myList.size(); i++){

		        //loading text of each element in to array all_elements_text
					all_elements_text.add(myList.get(i).getText());   
			}
		
			for(int j=1 ;j<=total_pages-1;j++) {
				
				JavascriptExecutor Js1 = (JavascriptExecutor) driver;
				Js1.executeScript("window.scrollBy(0,1500)");  
				Thread.sleep(2000);
				driver.findElement(sibling_page).click(); //click on immediate nextpage.
				Thread.sleep(2000);
				myList=driver.findElements(list_sortitems);
				for(int i=0; i< myList.size(); i++){
	
				        //loading text of each element in to array all_elements_text
				       all_elements_text.add(myList.get(i).getText());
	
					//}				
				}
			}
		}
		return all_elements_text;
		
		
	}
	
	// get the number of pages in the webpage
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
	
	public boolean isElementDisplayed(WebElement element) {
		
		try {
			
			return element.isDisplayed();
		}catch(Exception ignored) {return false;}
	}								
	
}
