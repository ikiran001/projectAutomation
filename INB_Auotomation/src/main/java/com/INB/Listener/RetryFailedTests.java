package com.INB.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.INB.utils.ReadPropertyFile;

import enums.ConfigProperties;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int retries=1;
	

	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(ReadPropertyFile.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value=count<retries;
			count++;
						}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return value;
	}

}
