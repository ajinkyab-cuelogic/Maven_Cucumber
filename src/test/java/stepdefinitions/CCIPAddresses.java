package stepdefinitions;

import java.util.HashMap;

import org.junit.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;
import pageobject.cc_ip_addresses.AllIPAddressesPage;
import pageobject.cc_ip_addresses.IPAddress;

public class CCIPAddresses {
	
	
	LoginPage login;
	HashMap<String, String> ipTestData;
	private TestContext context;
	private IPAddress ipaddress;
	private AllIPAddressesPage allipaddress;
	
	public CCIPAddresses(TestContext context) {
		this.context = context;
		context.setExecutingTestCaseFileName(this.getClass().getSimpleName());
	}

	@Given("^I am logged in as admin user and click on CC IP Addresses menu$")
	public void navigateToCCIPAddressMenu() throws Exception {
		try {
			ipTestData = context.getTestCaseData().get("IPAddressData");
			login = context.getPageObjectManager().getLogingPage();
			login.doValidLogin(context.getConfigFileReader().getValidEmail(), 
					context.getConfigFileReader().getValidPassword());
			ipaddress = context.getPageObjectManager().getIPAddressPage();
			ipaddress.clickOnMainMenuCCIPAddresses();
		} 
		
		catch (Exception e) {
			System.out.println("Could not navigate to CC IP Addresses menu");
			throw e;
		}
	}

	@When("^I click on Add IP Address link$")
	public void clickAddIPAddress() throws Exception {
		try {
			ipaddress.clickOnSubMenuAddIPAddress();
		}
		
		catch (Exception e) {
			System.out.println("Could not click Add IP Address submenu");
			throw e;
		}
	}

	@When("^I enter IP Address details$")
	public void enterIPAddressDetails() throws Exception {
		try {
			ipaddress.enterIpAdddressDetails(ipTestData.get("ipadd"), ipTestData.get("lable"));
			System.out.println("Ip Address Details entered successfully");
		} 
		
		catch (Exception e) {
			System.out.println("Could not enter IP address details");
			throw e;
		}
	}

	@When("^I click on create button on Add CC IP Address$")
	public void clickCreateButton() throws Exception {
		try {
			ipaddress.clickSubmitButton();
		}
		
		catch (Exception e) {
			System.out.println("Could not click Create button");
			throw e;
		}

	}

	@Then("^I should see page with message CC IP Address is successfully created$")
	public void verifyCreateCCIPAddressSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Create CC Ip Address success message text not matched", "CC IP Address is successfully created.",
					ipaddress.getSuccessMessageText());
			System.out.println("test to add CC IP Address passed");
		} 
		
		catch (Exception e) {
			System.out.println("Test to Add CC IP Address failed");
			throw e;
		}

	}
	
	@When("^I click All IP Addresses link$")
	public void clickAllIPAddress() throws Exception {
		try {
			ipaddress.clickOnSubMenuAllIPAddresses();
		}
		
		catch (Exception e) {
			System.out.println("Could not click All IP Addresses submenu");
			throw e;
		}

	}


	@When("^I update CC IP Address details and click on Update button")
	public void updateCCIPAddressDetails() throws Exception {
		try {
			ipaddress.enterIPAddress(ipTestData.get("newipadd"));
			ipaddress.enterLabel(ipTestData.get("newlabel"));
			ipaddress.clickSubmitButton();
			System.out.println("CC IP Address details updated");
		}
		
		catch (Exception e) {
			System.out.println("Could not update CC IP Address details");
			throw e;
		}

	}

	@Then("^I should see page with message CC IP Address is successfully updated$")
	public void verifyUpdateCCIPAddressSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Update CC Ip Address success message text not matched", "CC IP Address is successfully updated.",
					ipaddress.getSuccessMessageText());
			System.out.println("test to update CC IP Address passed");
		}
		
		catch (Exception e) {
			System.out.println("test to update CC IP Address failed");
			throw e;
		}

	}
	
	
	@When("^I search CC IP address and I click edit icon$")
	public void searchCCIPAddressAndClickOnEditICon() throws Exception {
		try {
			allipaddress = context.getPageObjectManager().getAllIPAddressesPage();
			allipaddress.searchCCIPAddress(ipTestData.get("ipadd"), ipTestData.get("label"));
			allipaddress.clickEditIPAddressIcon();
		}
		
		catch (Exception e) {
			System.out.println("Could not search CC IP Address");
			throw(e);
		}

	}

	@When("^I search CC IP address and I click on Delete IP Address icon$")
	public void searchCCIPAddressAndClickOnDeleteIcon() throws Exception {
		try {
			allipaddress.searchCCIPAddress(ipTestData.get("newipadd"), ipTestData.get("newlabel"));
			allipaddress.clickDeleteIPAddressIcon();
		}
		
		catch (Exception e) {
			System.out.println("Could not delete CC IP Address");
			throw(e);
		}

	}
	
	@When("^I accept the Delete IP Address confirmation popup$")
	public void acceptDeleteIPAddressConfirmation() throws Exception {
		try {
			ipaddress.acceptConfirmationPopup();
		}
		
		catch (Exception e) {
			System.out.println("Could not Accept  CC IP Addres Delete Confirmation popup");
			throw(e);
		}

	}
	
	@Then("^I should see page with message CC IP Address is successfully removed$")
	public void verifyDeleteCCIPAddressSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Update CC Ip Address success message text not matched", "CC IP Address is successfully removed.",
					ipaddress.getSuccessMessageText());
			System.out.println("test to Delete CC IP Address passed");
		} 
		
		catch (Exception e) {
			System.out.println("test to Delete CC IP Address failed");
			throw e;
		}

	}

}
