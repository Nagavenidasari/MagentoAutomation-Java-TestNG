package utils;

public class excelutilsDemo {

	public static void main(String[] args) {
		
		String projectpath = System.getProperty("user.dir");
		
		
		ExcelUtils excel = new ExcelUtils(projectpath+"/excel/data.xlsx","Sheet1");
		/*excel.getRowCount();
		excel.getColCount();
		excel.getCellDataNumber(1, 1);
		excel.getCellDataString(0, 0);*/

	}

}
