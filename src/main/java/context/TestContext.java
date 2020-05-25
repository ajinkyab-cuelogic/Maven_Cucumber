package context;

import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;
import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	
	WebDriver driver;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	DriverManager driverManager;

	public TestContext() {
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader = new ConfigFileReader();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		return configFileReader;
	}
	
	public DriverManager getDriverManager() {
		return driverManager;
	}

	public String getPageTitle() {
		return getDriver().getTitle();
	}
	
	
	public void enterURL() {
		driver.get(configFileReader.getApplicationUrl());
	}
}
