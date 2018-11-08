package com.prjName.base;

import org.testng.annotations.BeforeSuite;

import com.prjName.reports.ExtentReport;
import com.prjName.utils.PropertyFileReader;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	public static ExtentReports extent;
	 PropertyFileReader prop;
@BeforeSuite
public void beforeSuite(){
	       ExtentReport.getInstance();
	        prop = new PropertyFileReader();
}

}
