package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
	
	private Properties properties;
	private final String CONFIG_FILE_PATH = "configs//Configuration.properties";

	
	public ConfigFileReader(){
		loadAllProperties(CONFIG_FILE_PATH);
	}
	
	 private void loadAllProperties(String configFilePath) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + configFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) {
			return driverPath;
		}
		else {
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		}
					
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("global-page-timeout");
		if(implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		}
		else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
		}
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("applicationURL");
		if(url != null) {
			return "https://" + url;
		}
		else {
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
	}
	

    public String getValidEmail() {
         String email = properties.getProperty("email");
         if(email != null) {
 			return email;
 		}
 		else {
 			throw new RuntimeException("email not specified in the Configuration.properties file.");
 		}
    }

    public String getValidPassword() {
        String password = properties.getProperty("password");
        if(password != null) {
 			return password;
 		}
 		else {
 			throw new RuntimeException("password not specified in the Configuration.properties file.");
 		}
    }
    
    public String getBrowser() {
    	 String browserName = properties.getProperty("browser");
         if(browserName != null) {
  			return browserName;
  		}
  		else {
  			return "chrome";
  		}
    	
    }
    	 
    public String getEnvironment() {
    	 String environmentType = properties.getProperty("environment");
         if(environmentType != null) {
  			return environmentType;
  		}
  		else {
  			return "local";
  		}
    }
    	
    public String getBrowserMode() {
    	String browserMode = properties.getProperty("headless");
    	if(browserMode != null) {
    		return browserMode;
    	}
    	else {
    		return "false";
    	}
    		
    }
    
    public String getTestDataDirectoryPath() {
    	String testDataDirectoryPath = properties.getProperty("test-data-directory");
    	if(testDataDirectoryPath != null) {
    		return testDataDirectoryPath;
    	}
    	else {
    		throw new RuntimeException("testDataDirectoryPath not specified in the Configuration.properties file.");
    	}
    }

}
