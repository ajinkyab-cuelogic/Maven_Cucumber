package pageobject.cc_ip_addresses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseActions;

public class IPAddress extends BaseActions {
	
	

	By textbox_ip_address = By.id("ipv4");
	By textbox_label = By.id("phx_ip_address_label");
	By checkbox_allow_login = By.xpath("//input[@type='checkbox' and  @id='phx_ip_address_allow_login']");
	By checkbox_call_center_ip = By.xpath("//input[@type='checkbox' and  @id='phx_ip_address_call_center']");
	By mainmenu_cc_ip_address =  By.xpath("//a[contains(.,'CC IP Addresses')]");
	By submenu_add_ip_address =  By.xpath("//a[contains(.,'Add IP Address')]");
	By button_submit = By.xpath("//input[@type='submit']");
	By message_success = By.xpath("//div[contains(@class,'alert-success')]");
	By submenu_all_ip_address = By.xpath("//a[contains(.,'All IP Address')]");
	
	public IPAddress(WebDriver driver) {
		super(driver);
	}

	public void clickOnMainMenuCCIPAddresses() throws Exception {
		try {
			clickElement(mainmenu_cc_ip_address);
			System.out.println("Main menu CC IP Address clicked");
		} catch (Exception e) {
			System.out.println("Main menu CC IP Address not clicked");
			throw(e);
			
		}
	}
	
	public void clickOnSubMenuAddIPAddress() throws Exception {
		try {
			clickElement(submenu_add_ip_address);
			System.out.println("Sub menu Add IP Address clicked");
		} catch (Exception e) {
			System.out.println("Sub menu Add IP Address not clicked");
			throw(e);
			
		}
	}
	
	public void clickOnSubMenuAllIPAddresses() throws Exception {
		try {
			clickElement(submenu_all_ip_address);
			System.out.println("Sub menu All IP Address clicked");
		} catch (Exception e) {
			System.out.println("Sub menu All IP Address not clicked");
			throw(e);
		}
		
	}
	
	public void enterIPAddress(String ipaddress) throws Exception {
		try {
			setElementText(textbox_ip_address, ipaddress);
			System.out.println("IP address entered");
		}
		
		catch (Exception e) {
			System.out.println("IP address not entered");
			throw(e);
		}
	}

	
	public void enterLabel(String label) throws Exception {
		try {
			setElementText(textbox_label, label);
			System.out.println("Label entered");
		}
		
		catch (Exception e) {
			System.out.println("Label not entered");
			throw(e);
		}
	}
	
	
	public void clickAllowLoginCheckbox() throws Exception {
		try {
			clickUnselectedCheckbox(checkbox_allow_login);
			System.out.println("Allow Login checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Allow Login checkbox not clicked");
			throw(e);
		}
	}
	
	
	public void clickCallCenterIpCheckbox() throws Exception {
		try {
			clickUnselectedCheckbox(checkbox_call_center_ip);
			System.out.println("Call Center Ip checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Call Center Ip checkbox not clicked");
			throw(e);
		}
	}
	
	public void enterIpAdddressDetails(String ipaddress, String label) throws Exception {
		try {
			enterIPAddress(ipaddress);
			enterLabel(label);
			clickAllowLoginCheckbox();
			clickCallCenterIpCheckbox();
			System.out.println("Ip address details entered");
		}
		
		catch (Exception e) {
			System.out.println("Ip address details not entered");
			throw(e);
		}
	}
	
	public void clickSubmitButton() throws Exception {
		try {
			clickElement(button_submit);
			System.out.println("Create button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Create button not clicked");
			throw(e);
		}
	}

	
	public String getSuccessMessageText() throws Exception {
		return getElementText(message_success);
	}

}
