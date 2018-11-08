package com.prjName.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;


public class TestUtil {
 
	public static void takeScreenShot(WebDriver driver) throws IOException{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String time= sFormat.format(cal.getTime());
		 Files.copy(src, new File(System.getProperty("user.dir")+"//screenshots"+time+".png"));
		
	}
	public static void takeScreenShotwithName(WebDriver driver,String name) throws IOException{
		if(name==null)
			name="blank";
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(src, new File(System.getProperty("user.dir")+"//screenshots"+name+".png"));
		
	}
}