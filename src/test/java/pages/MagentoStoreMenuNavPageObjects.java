package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MagentoStoreMenuNavPageObjects {
	WebDriver driver;
	Map<String, String> xpathMap=new HashMap<String, String>();
	
	
	public MagentoStoreMenuNavPageObjects(WebDriver driver) {
		this.driver=driver;
		
		xpathMap.put("whatsnew","ui-id-3");
		xpathMap.put("women","//*[@id='ui-id-4']");
		xpathMap.put("men","//*[@id='ui-id-5']");
		xpathMap.put("gear","//*[@id='ui-id-6']");
		xpathMap.put("training","//*[@id='ui-id-7']");
		xpathMap.put("sale","//*[@id='ui-id-8']");
		xpathMap.put("title","//*[@id='page-title-heading']/span");
		xpathMap.put("wtops","ui-id-9");
		xpathMap.put("wbottoms","ui-id-10");
		xpathMap.put("wjackets","ui-id-11");
		xpathMap.put("whsweats","ui-id-12");
		xpathMap.put("wtees","ui-id-13");
		xpathMap.put("wbrastanks","ui-id-14");
		xpathMap.put("wpants","ui-id-15");
		xpathMap.put("wshorts","ui-id-16");
		xpathMap.put("mtops","ui-id-17");
		xpathMap.put("mbottoms","ui-id-18");
		xpathMap.put("mjackets","ui-id-19");
		xpathMap.put("mhsweats","ui-id-20");
		xpathMap.put("mtees","ui-id-21");
		xpathMap.put("mtanks","ui-id-22");
		xpathMap.put("mpants","ui-id-23");
		xpathMap.put("mshorts","ui-id-24");
		xpathMap.put("gbags","ui-id-25");
		xpathMap.put("gfitness","ui-id-26");
		xpathMap.put("gwatches","ui-id-27");
		xpathMap.put("tvideos","ui-id-28");
		
	}
	
	public String PerformNavigation(String item1, String item2, String item3) throws Exception {
		
		String result = "";
		Actions a = new Actions(driver);
		if(item1 != null && item2 != null && item3 != null) {
			String itema=item1.toLowerCase();
			String itemb=item2.toLowerCase();
			String itemc=item3.toLowerCase();
			WebElement ele1=driver.findElement(By.xpath(xpathMap.get(itema)));
			Thread.sleep(2000);	
			a.moveToElement(ele1).build().perform();
			Thread.sleep(2000);	
			WebElement ele2=driver.findElement(By.id(xpathMap.get(itemb)));
			Thread.sleep(2000);	
			a.moveToElement(ele2).build().perform();
			Thread.sleep(3000);	
			WebElement ele3=driver.findElement(By.id(xpathMap.get(itemc)));
			a.moveToElement(ele3).build().perform();
			ele3.click();
			Thread.sleep(3000);
			WebElement title = driver.findElement(By.xpath(xpathMap.get("title")));
			Thread.sleep(3000);	
			result = title.getText();
			return result;
		}
		else if(item1 != null && item2 != null) {
			String itema=item1.toLowerCase();
			String itemb=item2.toLowerCase();
			WebElement ele1=driver.findElement(By.xpath(xpathMap.get(itema)));
			a.moveToElement(ele1).build().perform();
			Thread.sleep(2000);	
			WebElement ele2=driver.findElement(By.id(xpathMap.get(itemb)));
			a.moveToElement(ele2).build().perform();
			Thread.sleep(2000);
			ele2.click();
			Thread.sleep(3000);	
			WebElement title = driver.findElement(By.xpath(xpathMap.get("title")));
			result = title.getText();
			return result;
		}
		else if(item1 != null) {
			String itema=item1.toLowerCase();
			WebElement ele1=driver.findElement(By.xpath(xpathMap.get(itema)));
			ele1.click();
			Thread.sleep(3000);	
			WebElement title = driver.findElement(By.xpath(xpathMap.get("title")));
			result = title.getText();
			return result;				
		}
		else {
			// Log the error message
			
		}
		
		return result;
	}
	
	

}
