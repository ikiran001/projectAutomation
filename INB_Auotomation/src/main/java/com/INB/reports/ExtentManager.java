package com.INB.reports;

import com.aventstack.extentreports.ExtentTest;


public final class ExtentManager {
	private ExtentManager() {
	}
	
	
	private static ThreadLocal<ExtentTest> extTest=new ThreadLocal<ExtentTest>();

	
	
	 static ExtentTest getExtTest() {
		return extTest.get();
	}

	 static void setExtTest(ExtentTest test) {
		extTest.set(test);
	} 
	
	 static void unload() {
		extTest.remove();
	}
	 
	
	

}
