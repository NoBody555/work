package com.prjName.winium;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.google.common.io.Files;

public class WiniumExample {
	static WiniumDriver driver;
     public static void main(String[] args) throws MalformedURLException {
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("E:\\aworkspace\\PrjName\\crap.txt");
		driver = new WiniumDriver(new URL("http:\\localhost:9999"),options);
	     WebElement ele = findAnElementByType("id","15");
	
		
	 
		try {
			waitForAnElementToAppearandClick(ele);
		}
		catch (Exception e) {
			
		 e.printStackTrace();
		}
		 ele.clear();
	      ele.sendKeys("wrong string");
		
	}
     public static void waitForAnElementToAppearandClick(WebElement ele) throws InterruptedException{
    	 for(int i=0; i<10; i++){
    		 try{
    			if(ele.isDisplayed())
    				break;
    		 }catch(Exception e){
    			 Thread.sleep(1000);
    		 }
    	 }
    	 for(int i=0; i<10; i++){
    		 try{
    			if(ele.isEnabled()){
    				ele.click();
    				break;
    			}
    		 }catch(Exception e){
    			 Thread.sleep(1000);
    		 }
    	 }
     }
     public static WebElement findAnElementByType(String locatorType,String locatorValue){
    	 
    	  if(locatorType.equalsIgnoreCase("id"))
    		  
			 return driver.findElement(By.id(locatorValue));
    	  
    	 else
    		 if(locatorType.equalsIgnoreCase("name"))
        		 return driver.findElement(By.name(locatorValue));
    		 else
        		 if(locatorType.equalsIgnoreCase("xpath"))
        			 return driver.findElement(By.xpath(locatorValue));
				 else
		    		 if(locatorType.equalsIgnoreCase("classname"))
		    			 return driver.findElement(By.className(locatorValue));
				    else
			    		 if(locatorType.equalsIgnoreCase("tagName"))
			    			 return driver.findElement(By.tagName(locatorValue));
			    	 else
		    	    	 if(locatorType.startsWith("link"))
		    	    		 return driver.findElement(By.linkText(locatorValue));
	    	    	 else
	        	    	 if(locatorType.contains(("link")))
		                    	  return driver.findElement(By.partialLinkText(locatorValue));
   
            	      else
            	    	  if(locatorType.contains("css"))
    			               return driver.findElement(By.cssSelector(locatorValue));
        	    			 else
        	    				 return null;
                   
     }
     public static void takeScreenShot(String name) throws IOException{
    	 
    	 File src =driver.getScreenshotAs(OutputType.FILE);
	      if(name==null || name== ""){
	 		Calendar cal = Calendar.getInstance();
	 		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	 		String time= sFormat.format(cal.getTime());
	 		 Files.copy(src, new File(System.getProperty("user.dir")+"//screenshots//winium"+time+".png"));
	      }
    	   else
    		  Files.copy(src, new File(System.getProperty("user.dir")+"//screenshots//winium"+name+".png"));
     }
   
    
}
