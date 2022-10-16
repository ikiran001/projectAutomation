package com.INB.constants;

import com.INB.utils.ReadPropertyFile;

import enums.ConfigProperties;

public final class FrameworkConstants {                          // final= not to extend

	private FrameworkConstants() {                               //not to create a object 

	}

	private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH=FrameworkConstants.getResourcepath()+"/config/config.properties";
	private static final String CHROMEDRIVERPATH=FrameworkConstants.getResourcepath()+"/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH=FrameworkConstants.getResourcepath()+"/executables/geckodriver.exe";
	private static final String MICROSOFTEDGEDRIVERPATH=FrameworkConstants.getResourcepath()+"/executables/msedgedriver.exe";
	private static final int    EXPLICITLYWAITTIME=10;
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static       String extentReportFilePath="";
	private static final String EXCELFILEPATH=RESOURCEPATH+"/excel/testdata.xlsx";
	private static final String RUNMNAGERSHEET="RUNMANAGER";
	private static final String ITERATIONDATASHEET="DATA";


	public static String getMicrsoftEdgeDriverPath() {
		return MICROSOFTEDGEDRIVERPATH;
	}
	public static String getFireFoxDriverPath() {
		return FIREFOXDRIVERPATH;
	}
	
	
	public static String getIterationDataSheet() {
		return ITERATIONDATASHEET;
	}
	
	public static String getRunManagerSheet() {
		return RUNMNAGERSHEET;
	}

	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if(ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equals("no")) {
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
	}


	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitlywaittime() {
		return EXPLICITLYWAITTIME;
	}

	public static String getResourcepath() {
		return RESOURCEPATH;
	}


	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;

	}
}
