package com.prjName.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Loggers {
  private static boolean root = false;
   public static Logger getLoggers(Class cls){
	    if(root)
	    	return Logger.getLogger(cls);
	    PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//main//resources//log4j.properties ");
	    root =true;
	    return Logger.getLogger(cls);
   }	
   public static void main(String[] args) {
	 Logger log = Loggers.getLoggers(Loggers.class);
	 log.info("dljfdjld");
	 log.info("dljfdjld");
	 log.info("dljfdjld");
	 log.info("dljfdjld");
}
}
