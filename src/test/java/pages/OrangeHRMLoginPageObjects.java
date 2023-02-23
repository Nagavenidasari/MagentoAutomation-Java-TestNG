package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLoginPageObjects {
	
	
	 WebDriver driver;

	public OrangeHRMLoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By txt_username = By.name("username");
	By txt_password = By.name("password");
	By btn_submit = By.xpath("//button[@type='submit']");
	By drp_profile = By.xpath("//li[@class='oxd-userdropdown']");
	By lnk_logout = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a");
	By txt_error = By.xpath("//div[@class='orangehrm-login-error']/div/div/p");
	
	public void set_username(String username) {
		
		driver.findElement(txt_username).clear();
		driver.findElement(txt_username).sendKeys(username);
		
	}
	
	public void set_password(String password) {
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clk_submit() {
		
		driver.findElement(btn_submit).click();
		
	}
	
	public String get_title() {
		
		return (driver.getTitle());
	}
	
	public void clk_profile() {
		
		driver.findElement(drp_profile).click();
	}
	
	public void clk_logout() {
		
		driver.findElement(lnk_logout).click();
	}
	
	public String invalid_login() {
		
		return (driver.findElement(txt_error).getText());
	}

}
