package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used to read data from excel file
	 * @param Sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getDataFromExcel(String Sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sheet = wb.getSheet(Sheetname);
	 Row row = sheet.getRow(rowNum);
	 Cell cell = row.getCell(cellNum);
	 String data = cell.toString();
	 wb.close();
	 return data;
}
	/**
	 * This method will return last row number in specified sheet
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
		
	}
	/**
	 * This method is used to write data in excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataInExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
		
	}

}
