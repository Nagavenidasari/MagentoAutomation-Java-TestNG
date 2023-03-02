package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectingSizefromShoppingOptionsPageObjects {
	
WebDriver driver;
	
	public SelectingSizefromShoppingOptionsPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}

	By select_size = By.xpath("//*[@id='narrow-by-list']/div[2]/div[1]");
	By btn_xsmall = By.xpath("//*[@id='narrow-by-list']/div[2]/div[2]/div/div/a[1]/div");
	By btn_small = By.xpath("//*[@id='narrow-by-list']/div[2]/div[2]/div/div/a[2]/div");
	By btn_medium = By.xpath("//*[@id='narrow-by-list']/div[2]/div[2]/div/div/a[3]/div");
	By btn_large = By.xpath("//*[@id='narrow-by-list']/div[2]/div[2]/div/div/a[4]/div");
	By btn_xlarge = By.xpath("//*[@id='narrow-by-list']/div[2]/div[2]/div/div/a[5]/div");
	By chkbox_sizeselected = By.xpath("//div[@class='swatch-option text selected']");
	
	
	public void clkSizeOptions() {
		driver.findElement(select_size).click();
	}
	
	public boolean isSelectedSize(String size) throws Exception {
		
		List<WebElement> myList ;
		if(size.equalsIgnoreCase("xsmall")) {
			driver.findElement(btn_xsmall).click();
			Thread.sleep(2000);
			myList = driver.findElements(chkbox_sizeselected);
			for(int i=0; i< myList.size(); i++){
				//System.out.println(myList.get(i).getText());
				if(myList.get(i).getText().equalsIgnoreCase("XS")== false) {
					System.out.println("Returing false");
					return false;
				}
			}
			
		}else if(size.equalsIgnoreCase("small")) {
			
			driver.findElement(btn_small).click();
			Thread.sleep(2000);
			myList = driver.findElements(chkbox_sizeselected);
			for(int i=0; i< myList.size(); i++){
				if(myList.get(i).getText().equalsIgnoreCase("S")== false) {
					System.out.println("Returing false");
					return false;
				}
			}
			
		}else if(size.equalsIgnoreCase("medium")) {
			
			driver.findElement(btn_medium).click();
			Thread.sleep(2000);
			myList = driver.findElements(chkbox_sizeselected);
			for(int i=0; i< myList.size(); i++){
				if(myList.get(i).getText().equalsIgnoreCase("M")== false) {
					System.out.println("Returing false");
					return false;
				}
			}
			
		}else if(size.equalsIgnoreCase("large")) {
			
			driver.findElement(btn_large).click();
			Thread.sleep(2000);
			myList = driver.findElements(chkbox_sizeselected);
			for(int i=0; i< myList.size(); i++){
				if(myList.get(i).getText().equalsIgnoreCase("L")== false) {
					System.out.println("Returing false");
					return false;
				}
			}
		}else if(size.equalsIgnoreCase("xlarge")) {
			driver.findElement(btn_xlarge).click();
			Thread.sleep(2000);
			myList = driver.findElements(chkbox_sizeselected);
			for(int i=0; i< myList.size(); i++){
				if(myList.get(i).getText().equalsIgnoreCase("XL")== false) {
					System.out.println("Returing false");
					return false;
				}
			}
		}else {
			System.out.println("No such size present");
			return false; 
		}
		return true;
	}

}
