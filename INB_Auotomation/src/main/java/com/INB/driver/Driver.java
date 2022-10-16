package com.INB.driver;

import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.INB.constants.FrameworkConstants;
import com.INB.utils.ReadPropertyFile;

import enums.ConfigProperties;

public final class Driver {

	private Driver() {


	}
	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFireFoxDriverPath());
				DriverManager.setDriver(new FirefoxDriver());
			}
			else if(browser.equalsIgnoreCase("microsoft")) {
				System.setProperty("webdriver.edge.driver", FrameworkConstants.getMicrsoftEdgeDriverPath());
				DriverManager.setDriver(new EdgeDriver());
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));

		}}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
