package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MagentoLoginPageObjects {
	
	
	WebDriver driver ;
	By link_SignIn = By.xpath("//a[contains(@href ,'login')]");
	By txt_username = By.name("login[username]");
	By txt_password = By.name("login[password]");
	By btn_signin = By.name("send");
	By alrt_msg = By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div");
	
	public MagentoLoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clkSigninlnk() {
		
		driver.findElement(link_SignIn).click();
	}
	public void setUsetname(String text)
	{
		driver.findElement(txt_username).sendKeys(text);
	}
	
	public void setPassword(String text) {
		driver.findElement(txt_password).sendKeys(text);
	}
	
	public void clkbtnSignin() {
		driver.findElement(btn_signin).click();
		
	}
	
	public String alertMessage() {
		
		String msg = driver.findElement(alrt_msg).getText();
		
		return msg;
	}
	
	
	

}
