package com.prjName.excel;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Fetching the data by passing the key
 */
public class XcelHashMap {
	 static FileInputStream fis;
	   static XSSFWorkbook wb;
	    static XSSFSheet sheet;
	    static XSSFRow row;
	public static void main(String[] args) throws Exception {
	
	    System.out.println(getValue("James"));
           System.out.println(getValue("karen"));
           System.out.println(getValue("Smith"));
           System.out.println(getValue("ronnie"));
       
	}
	
	public static void loadExcelFile() throws IOException {
		
	   File file = new File("");
         fis = new FileInputStream(file);
	    wb = new XSSFWorkbook(fis);
	     sheet=    wb.getSheet("Login");
	    fis.close();
	}
  public static Map<String, Map<String,String>> dataMap() throws Exception{
	  
	  if(sheet==null)
		  loadExcelFile();
	  
	   Map<String,Map<String,String>> superMap = new HashMap<String, Map<String,String>>();
            Map<String,String> map = new HashMap<String,String>();
          int rows = sheet.getLastRowNum()+1;
	       for(int i=1; i<sheet.getLastRowNum()+1; i++) {
	    	  row = sheet.getRow(i);
	    	 int cells =  row.getLastCellNum();
	    	 String key=   row.getCell(0).getStringCellValue();
	    	 
			
			String cellValue=null;
			for(int j=1; j<cells; j++) {
				
				 cellValue = row.getCell(1).getStringCellValue();
			      map.put(key, cellValue);
	       }
	       superMap.put("MasterData", map);
	     } 
              return superMap;	  
	  
  }
  public static String getValue(String key)throws Exception {
	  Map<String,String> myVal= dataMap().get("MasterData");
	           return myVal.get(key);
	           
	           
  }
}