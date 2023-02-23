package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MagentoAdditemstoCartPageObjects {
	
WebDriver driver ;
	
	public MagentoAdditemstoCartPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By lnk_firstitem = By.xpath("//strong[@class='product name product-item-name']/a");
	By btn_addtocart = By.id("product-addtocart-button");
	By txt_search = By.id("search");
	//By btn_size32 = By.id("option-label-size-143-175");
	By btn_size32 = By.xpath("//div[@option-id='175']");
	By btn_colorblk = By.id("option-label-color-93-item-49");
	By lnk_seconditem = By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/div/strong/a");
	//By btn_size30 = By.id("option-label-size-143-173");
	By btn_size30 = By.xpath("//div[@option-id='173']");
	By btn_colorred = By.id("option-label-color-93-item-58");
	By lnk_cart = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By lnk_cart_count = By.xpath("//span[@class='counter-number']");
	By btn_checkout = By.xpath("//*[@id='top-cart-btn-checkout']");
	By txt_items = By.xpath("//*[@id='opc-sidebar']/div[1]/div/div[1]/strong/span[1]");
	
	//a[@class='product-item-link']
	
	
	public void add_firstitem() {
		
		driver.findElement(lnk_firstitem).click();
		
	}
	public void add_tocart() {
		
		driver.findElement(btn_addtocart).click();
	}
	
	public void add_seconditem() {
		
		driver.findElement(lnk_seconditem).click();
		
		
	}
	
	public void set_size30() {
		
		driver.findElement(btn_size30).click();
		
	}
	
	public void set_size32() {
		
		driver.findElement(btn_size32).click();
		
		
	}
	
	public void set_colorblack() {
		
		driver.findElement(btn_colorblk).click();
	}
	
	public void set_colorred() {
		
		driver.findElement(btn_colorred).click();
	}
	public int show_carrt() {
		
		String cart_count = driver.findElement(lnk_cart_count).getText();
		int cart_counter = Integer.parseInt(cart_count);
		//driver.findElement(lnk_cart).click();
		return cart_counter;
	}
	
	public int check_cart() throws Exception {
		
		driver.findElement(lnk_cart).click();
		
		Thread.sleep(2000);
		driver.findElement(btn_checkout).click();
		Thread.sleep(2000);
		String count = driver.findElement(txt_items).getText();
		int total = Integer.parseInt(count);
		return total;
	}

}
