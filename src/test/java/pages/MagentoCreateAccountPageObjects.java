package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MagentoCreateAccountPageObjects {
	
	WebDriver driver ;
	
	By lnk_txt = By.xpath("//a[contains(@href ,'create')]");
	By txt_fname=By.id("firstname");
	By txt_lname=By.id("lastname");
	By txt_email=By.id("email_address");
	By txt_password = By.id("password");
	By txt_confirmpwd=By.id("password-confirmation");
	By btn_createacct=By.xpath("//*[@id='form-validate']/div/div[1]/button");
	By alrt_msg = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div");
	By grtn_msg = By.xpath("//span[@class='logged-in']");
	
	public  MagentoCreateAccountPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clkCreateAccount() {
		driver.findElement(lnk_txt).click();
	}
	
	public void setFname(String fname) {
		
		driver.findElement(txt_fname).sendKeys(fname);
	}
	
	public void setLname(String lname) {
		
		driver.findElement(txt_lname).sendKeys(lname);
	}
	
	public void setEmail(String email) {
		
		driver.findElement(txt_email).sendKeys(email);
	}
	
	public void setPassword(String password) {
		
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(txt_confirmpwd).sendKeys(password);
		
	}
	
	public void clkSubmit()
	{
		driver.findElement(btn_createacct).click();
	}
	public boolean verifyAlertmsg() {
		
		if(driver.findElement(grtn_msg).isDisplayed()) {
			
			return true;
		}else return false;
			
	}
	
	
	
	
	

}
