package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class AppTest extends BaseUtil{
	
	
	private BaseUtil base;
	
	public AppTest(BaseUtil base) {
		System.out.println("In Apptest class constructor");
		this.base = base;
		System.out.println("Base object " + base);
	}

	public static void setup(){

		System.out.println("In beforeclass Setup method");
		WebDriverManager.chromedriver().setup();
	}
	

	
	
	@Before
    public void openBrowser() {
//		ChromeOptions options = new ChromeOptions();
//	    options.addArguments("headless");
//	    options.addArguments("start-maximized");
		setup();
		System.out.println("In Open browser method of apptest class");
		System.out.println("base driver objct value  " + base.driver);
    	base.driver = new ChromeDriver();
    	System.out.println("in openbrowser" + base.driver);
    	base.driver.manage().window().maximize();
    	base.driver.get("https://admin-stg.travelpass.com");
   
    }
	
	
	@After
	public void cleanUp() {
		base.driver.close();
	}
	

	
}
