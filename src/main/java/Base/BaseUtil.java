package Base;

import org.openqa.selenium.WebDriver;

public class BaseUtil {

	public WebDriver driver;

	public String getPageTitle() {
		return driver.getTitle();
	} 
	
	
}
