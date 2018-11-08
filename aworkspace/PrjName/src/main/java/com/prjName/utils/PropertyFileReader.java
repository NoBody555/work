package com.prjName.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {
  FileInputStream fis;
   static Properties prop;
  public PropertyFileReader(){
		  try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+""));
			prop.load(fis);
			fis = new FileInputStream(new File(System.getProperty("user.dir")+""));
			prop.load(fis);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  
     }
  
  
  public  String getPropertyKey(String key){
	  return prop.getProperty(key);
  }
}
