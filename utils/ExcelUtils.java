package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static XSSFWorkbook workbook=null;
	static String path = System.getProperty("user.dir");
	static XSSFSheet sheet=null;
	
	// this is a constructor.Is a special method with out any return type and name same as class name.
	//It is called every time a class object is created using the new() keyword
	public ExcelUtils(String excelPath,String sheetName)  {
		
		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		getCellDataString(0,0);
		getCellDataNumber(1,1);

	}
	
	public static int getRowCount() {
		int rows = 0;
		try {
		
			rows = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows:"+rows);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rows;
		
	}
	public static int getColCount() {
		
		int cols=0;
		try {
			cols = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Columns:"+cols);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cols;
		
	}
	
	public static String getCellDataString(int rowNum,int colNum) {
		String cellData=null;
		try {
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
		
	
	}
	
	public static void getCellDataNumber(int rowNum,int colNum) {
		
		double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellData);
		
	}

	

}
