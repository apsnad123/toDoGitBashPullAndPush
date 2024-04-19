package com.crm.CAH.generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/*
	 * This method is use to read the data from excel sheet 
	 * @author Aparna
	 * @param sheetName, rowNum, columnNum
	 * @return value
	 * @throws EncryptedDocumentException , IOException
	 */

	public String readDataFromExcel(String sheetName,int rowNum,int columnNum) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNum).getCell(columnNum).getStringCellValue();
		wb.close();
		return value;
	}
	
	/*
	 * This method is use to get the total row count from excel sheet 
	 * @author Aparna
	 * @param sheetName
	 * @return rowCount , cellCount
	 * @throws EncryptedDocumentException , IOException
	 */
	
	public HashMap<String, String> getTotalRowCount(String sheetName, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		
		HashMap<String, String> map= new HashMap<String, String>();
		
		for (int i = 0; i < rowCount; i++) {
			  String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
			  String value = sh.getRow(i).getCell(cellNo).getStringCellValue();
			  map.put(key, value);
		}
		return map;
	}
	
	/*
	 * This method is use to write the data to excel sheet 
	 * @author Aparna
	 * @param sheetName, rowNum, columnNum, data
	 * @return void
	 * @throws EncryptedDocumentException , IOException
	 */
	
	public void writeDataToExcel(String sheetName,int rowNum,int columnNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.createSheet(sheetName);
		sh.createRow(rowNum).createCell(columnNum).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fout);
		wb.close();
		
	}
}
