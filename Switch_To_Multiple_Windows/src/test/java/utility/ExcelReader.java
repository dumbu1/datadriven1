package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelReader {

	private static FileInputStream excelPath;
	private static XSSFWorkbook obj_XSSFWorkbook;
	private static XSSFSheet sheet;

	
	public ExcelReader(String fileName,String sheetName) {
		try {
			excelPath= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/excelSheets/"+fileName+".xlsx");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.println(System.getProperty("user.dir"));
		try {
			obj_XSSFWorkbook=new XSSFWorkbook(excelPath);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		sheet=obj_XSSFWorkbook.getSheet(sheetName);
		
	}
	
	public ExcelReader(String fileName,int sheetId) {
		try {
			excelPath= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/"+fileName+".xlsx");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		try {
			obj_XSSFWorkbook=new XSSFWorkbook(excelPath);
		} catch (IOException e) {
			System.out.println(e);
		}
		sheet=obj_XSSFWorkbook.getSheetAt(sheetId);
	}
	
	
	//get total number of columns
	
		public static int getColumnCount() {
			
			
			return sheet.getRow(0).getLastCellNum();
		}
	
		
		//get total number of rows
		
		public static int getRowCount() {
			return sheet.getLastRowNum();
		}
		
	
	
		//get single row data
		
		public HashMap<String,String> getRowData(int rowNumber){
			
						
			HashMap<String,String> rowData=new HashMap<String,String>();
			
			for(int i=0;i<getColumnCount();i++) {
				rowData.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNumber).getCell(i).toString());
			}
			
			return rowData;
		}
		
		
		
		//get all data
		
		public List<HashMap<String, String>> getExcelData(){
		
		List<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
		
		for(int i=1;i<=getRowCount();i++) {
			data.add(getRowData(i));
		}
		return data;
		
		}
	
	
	
	
	
	
	
	
	
	
	//get key data
	public ArrayList<String> getHashKeys() {
		ArrayList<String> keys = new ArrayList<String>();
		for(int i=0; i < getColumnCount(); i++) {
			keys.add(sheet.getRow(0).getCell(i).toString());
		}
		return keys;
	}
	
	
	
	
	

}
