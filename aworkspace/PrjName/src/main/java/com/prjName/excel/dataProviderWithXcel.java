package com.prjName.excel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataProviderWithXcel {

	@Test(dataProvider="getData")
	public static void readData(Map mapdata) {
		System.out.println(mapdata.get("userName"));
		System.out.println(mapdata.get("password"));
		//System.out.println(mapdata.get("ross"));
	}
   @DataProvider(name="getData")
   public Object[][] returningData() throws IOException{
	   
	    
	    File file = new File("");
	   FileInputStream fis = new FileInputStream(file);
	   XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet =    wb.getSheetAt(0);
	     int rowcount =sheet.getLastRowNum();
	     System.out.println(rowcount);
	     int colCount = sheet.getRow(0).getLastCellNum();
	     System.out.println("col: "+colCount);
	    		 
	   Object[][] obj = new Object[rowcount][1];
	   for(int i=0;i<rowcount; i++) {
		   Map<Object,Object> map = new HashMap<Object,Object>();
		   for(int j=0; j<colCount; j++) {
			   map.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
			   System.out.println(sheet.getRow(0).getCell(j).toString()+", "+ sheet.getRow(i+1).getCell(j).toString());
		   }
		   
		   obj[i][0]=map;
		  // System.out.println("I: "+i);
	   }
	   
	      return obj ;
	   
   }
}
