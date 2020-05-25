package pageobject.cc_ip_addresses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BaseActions;

public class AllIPAddressesPage extends BaseActions {
	
	By search_textbox_ip_address = By.id("address");
	By search_textbox_label = By.id("label");
	By seach_checkbox_allow_login = By.id("allow_login");
	By search_checkbox_call_center_ip = By.id("call_center");
	By button_search = By.xpath("//input[@type='submit']");
	By icon_edit_ip_address = By.xpath("//i[@title='Edit IP Address']");
	By icon_delete_ip_address = By.xpath("//i[@title='Delete IP Address']");
	By message_success = By.xpath("//div[contains(@class,'alert-success')]");

	public AllIPAddressesPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void searchIPAddress(String ipaddress) throws Exception {
		try {
			setElementText(search_textbox_ip_address, ipaddress);
			System.out.println("IP address entered");
		}
		
		catch (Exception e) {
			System.out.println("IP address not entered");
			throw(e);
		}
	}
	
	public void searchLabel(String label) throws Exception {
		try {
			setElementText(search_textbox_label, label);
			System.out.println("Label entered");
		}
		
		catch (Exception e) {
			System.out.println("Label not entered");
			throw(e);
		}
	}
	
	
	public void searchAllowLoginCheckbox() throws Exception {
		try {
			clickUnselectedCheckbox(seach_checkbox_allow_login);
			System.out.println("Allow Login checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Allow Login checkbox not clicked");
			throw(e);
		}
	}
	
	
	public void searchCallCenterIpCheckbox() throws Exception {
		try {
			clickUnselectedCheckbox(search_checkbox_call_center_ip);
			System.out.println("Call Center Ip checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Call Center Ip checkbox not clicked");
			throw(e);
		}
	}
	
	
	public void clickSearchButton() throws Exception {
		try {
			clickElement(button_search);
			System.out.println("Search button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Search button not clicked");
			throw(e);
		}
	}

	
	public void clickEditIPAddressIcon() throws Exception {
		try {
			clickElement(icon_edit_ip_address);
			System.out.println("Edit IP address icon clicked");
		}
		
		catch (Exception e) {
			System.out.println("Edit IP address icon not clicked");
			throw(e);
		}
	}

	
	public void clickDeleteIPAddressIcon() throws Exception {
		try {
			clickElement(icon_delete_ip_address);
			System.out.println("Delete IP address icon clicked");
		}
		
		catch (Exception e) {
			System.out.println("Delete IP address icon not clicked");
			throw(e);
		}
	}
	

	public String getSuccessMessageText() throws Exception {
		String text = null;
		try {
			text = getElementText(message_success);
		} catch (Exception e) {
			System.out.println("Could not get Success message text");
			throw (e);
		}
		return text;
	}
	
	public void searchCCIPAddress(String ipaddress, String label) throws Exception {
		try {
			searchIPAddress(ipaddress);
			searchLabel(label);
			clickSearchButton();
		}
		
		catch (Exception e) {
			System.out.println("Could not search CC IP Address");
			throw(e);
		}
	}
}
