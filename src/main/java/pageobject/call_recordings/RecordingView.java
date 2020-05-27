package pageobject.call_recordings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseActions;

public class RecordingView extends BaseActions {

	By textbox_Title = By.id("recording_view_title");
	By multiselectbox_Organization =  By.id("recording_view_organization_ids");
	By multiselectbox_DNIS = By.id("recording_view_dnis");
	By mainmenu_CallRecordings = By.xpath("//a[contains(.,'Call Recordings ')]");
	By submenu_AddRecordingView = By.xpath("//a[contains(.,'Add Recording View')]");
	By button_Submit = By.xpath("//input[@type='submit']");
	
	public RecordingView(WebDriver driver) {
		super(driver);
	}

	public void clickOnMenuCallRecordings() throws Exception {
		try {
			clickElement(mainmenu_CallRecordings);
			System.out.println("Clicked on Menu Call Recording");
		} catch (Exception e) {
			System.out.println("Could not click on Menu Call Recordings");
			throw(e);
		}
	}
	
	public void clickOnSubmenuAddRecordingView() throws Exception {
		try {
			clickElement(submenu_AddRecordingView);
			System.out.println("Successfully clicked on Submenu Add Call Recording ");
		} catch (Exception e) {
			System.out.println("Colud not click on Add Recording view submenu");
			throw (e);
		}
	}


	public void enterTextInTitleField(String text) throws Exception {
		try {
			setElementText(textbox_Title, text);
			System.out.println("Text entered Successfully");
		} 
		
		catch (Exception e) {
			System.out.println("Could not enter text in title field");
			throw (e);
		}
	}


	public void selectOrganization(String orgname) throws Exception {
		try {
			setDropDownOptionByText(multiselectbox_Organization, orgname);
			System.out.println("Orgnization selected successfully");
		} 
		
		catch (Exception e) {
			System.out.println("Could not select the orgnization");
			throw (e);
		}
	}

	public void selectDNIS() throws Exception {
		try {
			setDropDownOptionByIndex(multiselectbox_DNIS, 1);
			setDropDownOptionByIndex(multiselectbox_DNIS, 2);
			setDropDownOptionByIndex(multiselectbox_DNIS, 3);
			setDropDownOptionByIndex(multiselectbox_DNIS, 4);
			System.out.println("DNIS selected Successfully");
		}
		
		catch (Exception e) {
			System.out.println("Could not select DNIS");
			throw (e);
		}
	}

	public void deselectFirstDnis() throws Exception {
		try {
			unsetDropDownOptionByIndex(multiselectbox_DNIS, 0);
			System.out.println("Successfully deselected first DNIS");
		}
		
		catch (Exception e) {
			System.out.println("Could not deselect first DNIS");
			throw (e);
		}
	}

	public void clickOnSubmitButton() throws Exception {
		try {
			clickElement(button_Submit);
			System.out.println("submit button clicked");
		} catch (Exception e) {
			System.out.println("submit button not clicked");
		}
	}
	

}
