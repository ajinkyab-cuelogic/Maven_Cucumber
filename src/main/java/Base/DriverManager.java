/*package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager extends BaseUtil {
	
	private BaseUtil base;
	
	public DriverManager(BaseUtil base) {
		this.base = base;
	}
	
    public WebDriver getDriver(String browser) throws MalformedURLException {
        //Set Browser Type
        DesiredCapabilities caps = null;
        if (browser == "chrome") {
            caps = DesiredCapabilities.chrome();
        } else if (browser == "firefox") {
            caps = DesiredCapabilities.firefox();
        }
        caps.setPlatform(Platform.WIN10);
 
        return driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }
}

*/