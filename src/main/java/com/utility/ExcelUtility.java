package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static XSSFCellStyle style;

	String path;

	public ExcelUtility(String path){
		this.path = path;
	}

	public int getRowCount(String sheetName) throws Exception{

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetName);

		int rowcount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}

	public int getCellCount(String sheetName,int rownum,int colnum) throws Exception{

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);

		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}
	public String getCellData(String sheetName,int rownum, int colnum) throws Exception {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);		
		cell = row.getCell(colnum);

		DataFormatter df = new DataFormatter();

		String data;
		try {
			data = df.formatCellValue(cell);
		}
		catch(Exception e) {
			data =" ";
		}
		wb.close();
		fis.close();
		return data; 
	}

	public void setCellData(String sheetName,int rownum, int colnum,String data) throws Exception{

		File xlfile = new File(path);
		if(!xlfile.exists()) {
			wb = new XSSFWorkbook(fis);
			fos = new FileOutputStream(path);
			wb.write(fos);
		}
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		if(wb.getSheetIndex(sh)==-1)
			wb.createSheet();
		sh = wb.getSheet(sheetName);

		if(sh.getRow(rownum)==null)
			sh.createRow(rownum);
		row = sh.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}

	public void fillGreenColor(String sheetName,int rownum, int colnum)	throws Exception{

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}
	
	public void fillRedColor(String sheetName,int rownum, int colnum)	throws Exception{

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}
}