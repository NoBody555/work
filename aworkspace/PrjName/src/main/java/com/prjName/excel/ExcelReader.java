package com.prjName.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelReader {
	static FileInputStream fis;
   static  XSSFWorkbook wb;
   static  XSSFSheet sheet;
       public static Object[][] getExcelData(String path,String sheetName){
    	    Object[][] obj =null;
            
            
    	   
    	    try{
    	    	fis=new FileInputStream(new File(path));
    	           sheet= wb.getSheet(sheetName);
    	           int rowCount = sheet.getLastRowNum();
    	           int colCount = sheet.getRow(0).getLastCellNum();
    	           obj = new Object[rowCount-1][colCount];
    	          /* for(int i=1; i<rowCount; i++){
    	        	   for(int j=0; j<colCount; j++)
    	        		 
    	        	   obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
    	        	   
    	           }*/
    	        Iterator<Row> rowIterator = sheet.iterator();
    	        int i=0;
    	        while(rowIterator.hasNext()){
    	        	if(i==1)
    	        	 continue;
    	        	
    	        	XSSFRow rows = (XSSFRow)rowIterator.next();
    	        	      Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = rows.iterator();
    	        	      int j=0;
        	      while(cellIterator.hasNext()){
        	    	XSSFCell cells = (XSSFCell)  cellIterator.next();
        	       switch(cells.getCellType()){
        	       case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
        	    		 obj[i-1][j++]=cells.getNumericCellValue();
        	    		 break;
        	       case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
        	    	   obj[i-1][j++]=cells.getStringCellValue();
        	    	    break;
        	    	    default:
        	    	    	System.out.println("unknown cell type");
        	           }
        	       
        	           i++;
        	        }
        	      }
    	        	             return obj;
				    	    }catch(Exception e){
				    	    	
				    	    	return null;
				    	    }
    	              }
                   }
