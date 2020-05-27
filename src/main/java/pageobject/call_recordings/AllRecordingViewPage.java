package pageobject.call_recordings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseActions;

public class AllRecordingViewPage extends BaseActions {

	By icon_ShowRecordingView = By.xpath("//i[@title='Show Recording View']");
	By icon_EditRecordingView = By.xpath("//i[@title='Edit Recording View']");
	By icon_DeleteRecordingView = By.xpath("//i[@title='Delete Recording View']");
	By textbox_Seach = By.xpath("//input[@type='search']");
	By submenu_AllRecordingViews = By.xpath("//a[contains(.,'All Recording Views')]");
	By button_Submit = By.xpath("//input[@type='submit']");
	
	public AllRecordingViewPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnSubmenuAllRecordingView() throws Exception {
		try {
			clickElement(submenu_AllRecordingViews);
			System.out.println("Successfully cliked on All Recording View Submenu");
		} catch (Exception e) {
			System.out.println("Could not click on All Recording View Submenu");
			throw (e);
		}
	}


	public void clickOnShowRecordingViewIcon() throws Exception {
		try {
			clickElement(icon_ShowRecordingView);
			System.out.println("Successfully clicked on Show Recording View Icon ");
		}
		
		catch (Exception e) {
			System.out.println("Could not click on Show Recording View Icon ");
			throw (e);
		}
	}


	public void clickOnEditRecordingViewIcon() throws Exception {
		try {
			clickElement(icon_EditRecordingView);
			System.out.println("Successfully clicked on Edit Recording View icon");
		} 
		
		catch (Exception e) {
			System.out.println("Could not click on Edit Recording View icon");
			throw (e);
		}
	}


	public void clickOnDeleteRecordingViewIcon() throws Exception {
		try {
			clickElement(icon_DeleteRecordingView);
			System.out.println("Successfully clicked on Delete Recording View icon");
		}
		
		catch (Exception e) {
			System.out.println("Could not click on Delete Recording View icon");
			throw (e);
		}

	}


	public void enterTextInSearchTextbox(String text) throws Exception {
		try {
			setElementText(textbox_Seach, text);
			System.out.println("Successfully Entered Search text");
		}
		
		catch (Exception e) {
			System.out.println("Could not enter search text");
			throw (e);
		}

	}
	

	
	

}
