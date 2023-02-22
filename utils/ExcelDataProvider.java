package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Propertiesfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	static WebDriver driver = null;
	
	
	
	@BeforeTest
	public void setUpTest() throws IOException {
		System.out.print("Test Started");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
						
	}
	@Test(dataProvider = "test1data")
	public void test1(String username1,String password1) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username1);
		driver.findElement(By.name("password")).sendKeys(password1);
		Thread.sleep(3000);

		//System.out.println(username1+ " | "+ password1);
		
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		
		String excelPath= "C:\\Users\\nagav\\eclipse-workspace\\AutomationStepByStep\\SeleniumWebDriverManager\\excel\\data.xlsx";
		Object[][] data = testData(excelPath,"Sheet1");
		return data;
		
	}
	//public static void main
	
	public Object[][] testData(String excelPath,String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount]; // storing the value in object array.Why object array is as data can be in any type(string,int,float etc)
		
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
