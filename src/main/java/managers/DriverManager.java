package managers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends ConfigFileReader {
	
	
	 private WebDriver driver;
	 private String driverType ;
	 private String environmentType;
	 
	 public DriverManager() {
		 driverType = getBrowser();
		 environmentType = getEnvironment();
	 }
	 
	 public WebDriver getDriver() {
		 if(driver == null) {
			 driver = createDriver();
		 }
		 return driver;
	 }
	 
	 private WebDriver createDriver() {
	    switch (environmentType) {     
	         case "local" : 	driver = createLocalDriver();
	          					break;
	         case "remote" :	driver = createRemoteDriver();
	         					break;
	    }
	    return driver;
	 }
	 
	 private WebDriver createRemoteDriver() {
	 throw new RuntimeException("RemoteWebDriver is not yet implemented");
	 }
	 
	 private WebDriver createLocalDriver() {
		 switch (driverType) {  
		 	case "firefox" : 	WebDriverManager.firefoxdriver().setup();
		 						driver = new FirefoxDriver();
		 						break;
		 						
	        case "chrome" : 	WebDriverManager.chromedriver().setup();
	        					if(getBrowserMode().equalsIgnoreCase("true")) {
									ChromeOptions options = new ChromeOptions();
									options.addArguments("--headless");
									options.addArguments("window-size=13660x768");
									options.addArguments("true");
									driver = new ChromeDriver(options);	
	        					} else {
	        						driver = new ChromeDriver();
	        					}
	         					
	         					break;
	         					
	        case "edge" : 		WebDriverManager.edgedriver().setup();
	        					driver = new EdgeDriver();
	        					break;
	        }
	 
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
	        return driver;
	 } 
	 
	 public void closeDriver() {
		 driver.close();
		 driver.quit();
	 }
 }

