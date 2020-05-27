package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BaseActions;

public class CommonPageElements extends BaseActions {
	
	public CommonPageElements(WebDriver driver) {
		super(driver);
	}

	By error_message = By.xpath("//div[contains(@class,'alert-danger')]");
	By success_message = By.xpath("//div[contains(@class,'alert-success')]");
	By button_submit = By.xpath("//input[@type='submit']");
	By breadcrumb = By.xpath("//div[contains(@class,'breadcrumbs')]");
	
	

	public String getSuccessMessageText() throws Exception {
		String text = null;
		try {
			text = getElementText(success_message);
		} catch (Exception e) {
			System.out.println("Could not get Success message text");
			throw (e);
		}
		return text;
	}
	
	public String getErrorMessageText() throws Exception {
		String text = null;
		try {
			text = getElementText(error_message);
		} catch (Exception e) {
			System.out.println("Could not get Error message text");
			throw (e);
		}
		return text;
	}
	
	public void clickSubmitButton() throws Exception {
		try {
			clickElement(button_submit);
			System.out.println("Search button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Search button not clicked");
			throw(e);
		}
	}
	
	public String getBreadcrumbText() throws Exception {

		return getElementText(breadcrumb);
	}


}
