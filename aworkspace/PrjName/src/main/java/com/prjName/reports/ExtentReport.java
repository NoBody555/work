package com.prjName.reports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReport {
  private static ExtentReports extent;
  public static ExtentReports getInstance(){
	  if(extent != null)
		  return extent;
	  return createInstance("pathofXtent.html");
  }
public static ExtentReports createInstance(String path) {
	
	 ExtentHtmlReporter rptr = new ExtentHtmlReporter(path);
	 rptr.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	 rptr.config().setChartVisibilityOnOpen(true);
	 rptr.config().setDocumentTitle(path);
	 rptr.config().setReportName("nameofRprt");
	 rptr.config().setEncoding("utf-8");
	 rptr.config().setTheme(Theme.STANDARD);
	 extent = new ExtentReports();
	 extent.attachReporter(rptr);
	      
	return null;
}
  
}
