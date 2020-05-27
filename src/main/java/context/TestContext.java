package context;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;
import dataProviders.TestDataProvider;
import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	
	WebDriver driver;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	DriverManager driverManager;
	TestDataProvider testDataProvider;
	
	protected HashMap<String, HashMap<String, String>> testCaseData;
    private String executingTestCaseFileName = null;


	public TestContext() {
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader = new ConfigFileReader();
		testDataProvider = new TestDataProvider();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setExecutingTestCaseFileName (String executingTestCaseFileName) {
		this.executingTestCaseFileName = executingTestCaseFileName;
		setTestCaseData();
	}
	
	public void setTestCaseData() {
        testCaseData = testDataProvider.getTestData(executingTestCaseFileName);
	}
	
	public HashMap<String, HashMap<String, String>> getTestCaseData() {
		return testCaseData;
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
