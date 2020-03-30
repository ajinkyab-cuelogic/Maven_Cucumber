package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class Hook extends BaseUtil{
	
	
	private BaseUtil base;
	
	public Hook(BaseUtil base) {
		System.out.println("In Apptest class constructor");
		this.base = base;
		System.out.println("Base object " + base);
	}

/*	public static void setup(){

		System.out.println("In beforeclass Setup method");
		WebDriverManager.chromedriver().setup();
	}
*/	

	
	@Before
    public void openBrowser() {
//		ChromeOptions options = new ChromeOptions();
//	    options.addArguments("headless");
//	    options.addArguments("start-maximized");
//		setup();
		WebDriverManager.chromedriver().setup();
		System.out.println("In Open browser method of apptest class");
		System.out.println("base driver objct value  " + base.driver);
    	base.driver = new ChromeDriver();
    	System.out.println("in openbrowser" + base.driver);
    	base.driver.manage().window().maximize();
    	base.driver.get("https://adm.stg.travelpass.com");
   
    }
	
	
	@After
	public void cleanUp() {
		base.driver.close();
	}
	

	
}
