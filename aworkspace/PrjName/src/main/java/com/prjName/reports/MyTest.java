package com.prjName.reports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MyTest {

	public static void main(String[] args) throws IOException {
		
		{ 
	
		 
		
		/*File file = new File("E:\\aworkspace\\PrjName\\crap.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st; 
		String str="";
		while ((st = br.readLine()) != null) 
		str += st; 
		  System.out.println(str);*/
			
	     System.out.println(readaFile());
		} 
		

 
	}
  public static void FileWriter(String data) throws IOException {
	  FileWriter fw = new FileWriter(new File("E:\\aworkspace\\PrjName\\crap.txt"));
	    fw.write(data);
	    fw.close();
		}
  
  public static String readaFile() throws IOException{
	  File file = new File("E:\\aworkspace\\PrjName\\crap.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;
		String str="";
		while ((st = br.readLine()) != null) 
		    //str += st;
			str = str.concat(st);
		  return str;
		} 
      
  
}
