package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TechlisticStaticTableDataTest extends TestBase {
	
	@Test
	public void TableData() throws Exception {
		
		driver.get("https://admin-demo.nopcommerce.com/Admin/Customer/List");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")).click();
		System.out.println("Clicked on submenu customers ");
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,1000)");  
		Thread.sleep(2000);
		int row_count = driver.findElements(By.xpath("//*[@id='customers-grid']/tbody/tr")).size();
		
		int col_count = driver.findElements(By.xpath("//*[@id='customers-grid']/tbody/tr[1]/td")).size();
		
		System.out.println(row_count);
		System.out.println(col_count);
		String first_part = "//*[@id='customers-grid']/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		for(int i=1; i<= row_count;i++) {
			
			for(int j=1;j<=4;j++) {
				
				String path =first_part+i+second_part+j+third_part; 
				String data = driver.findElement(By.xpath(path)).getText();
				System.out.println(data);
			}
			
		}
	}
		
		
}
