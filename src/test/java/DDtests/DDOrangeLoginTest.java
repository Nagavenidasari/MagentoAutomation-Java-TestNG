package DDtests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.OrangeHRMLoginPageObjects;
import testbase.TestBase;
import utils.ExcelUtils;

public class DDOrangeLoginTest extends TestBase{
	
	
	@Parameters("browserName")
	@Test(dataProvider = "InvalidLogintestdata")
	public void InvalidLogintest(String username1,String password1) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		OrangeHRMLoginPageObjects hrm= new OrangeHRMLoginPageObjects(driver);
		//launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		log("Launched ORANGEHRM website");
		Thread.sleep(2000);
		
		log("Set username: "+username1);
		hrm.set_username(username1);
		log("Set password: "+password1);
		hrm.set_password(password1);
		log("click login");
		hrm.clk_submit();
		String exp_error = "Invalid credentials";
		String act_error = hrm.invalid_login();
		log("Actual Error: "+act_error);
		log("Expected Error: "+exp_error);
		Assert.assertEquals(act_error, exp_error);
		
		
		//System.out.println(username1+ " | "+ password1);
		
	}
	
	//get the data in to an object array.
	// storing the value in object array.Why object array is as data can be in any type(string,int,float etc)
	@DataProvider(name = "InvalidLogintestdata")
	public Object[][] getData() {
		
		String excelPath= "C:\\Users\\nagav\\eclipse-workspace\\AutomationStepByStep\\MagentoSelenium\\excel\\data.xlsx";
		Object[][] data = testData(excelPath,"Sheet1");
		return data;
		
	}
	//public static void main
	
	public Object[][] testData(String excelPath,String sheetName) //object for ExcelUtils class.
	{
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName); // open the file
		int rowCount=excel.getRowCount(); // get row count
		int colCount=excel.getColCount(); // get colcount
		
		// storing the value in object array.Why object array is as data can be in any type(string,int,float etc)
		Object data[][] = new Object[rowCount-1][colCount]; 
		
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
