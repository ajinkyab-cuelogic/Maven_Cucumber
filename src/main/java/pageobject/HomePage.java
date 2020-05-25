package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseActions;

public class HomePage extends BaseActions{
	
	
	By homePageTitle = By.xpath("//div[@class='caption']");
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getHomePageTitle() {
		return findAnyElement(homePageTitle).getText();
	}
	
}
