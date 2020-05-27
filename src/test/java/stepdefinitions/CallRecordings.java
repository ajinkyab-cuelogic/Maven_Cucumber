package stepdefinitions;

import java.util.HashMap;
import org.junit.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;
import pageobject.call_recordings.AllRecordingViewPage;
import pageobject.call_recordings.RecordingView;

public class CallRecordings {

	AllRecordingViewPage allRecordingViewPage;
	HashMap<String, String> recodingdata = null;
	private TestContext context;
	private LoginPage login;
	private RecordingView callrecord;
	
	public CallRecordings(TestContext context) {
		this.context = context;
		context.setExecutingTestCaseFileName(this.getClass().getSimpleName());
	}

	@Given("^I am logged in as admin user and click on Call Recordings menu$")
	public void navigateToCallRecordingsMenu() throws Exception {
		try {
			login = context.getPageObjectManager().getLogingPage();
			login.doValidLogin(context.getConfigFileReader().getValidEmail(), 
					context.getConfigFileReader().getValidPassword());
			callrecord = context.getPageObjectManager().getRecordingViewPage();
			callrecord.clickOnMenuCallRecordings();
			recodingdata = context.getTestCaseData().get("callrecording");
		}
		
		catch (Exception e) {
			System.out.println("Could not Click on Call Recordings menu");
			throw (e);
		}

	}

	@When("^I click on Add Recording View link$")
	public void addRecordingView() throws Exception {
		try {
			callrecord.clickOnSubmenuAddRecordingView();
		}
		
		catch (Exception e) {
			System.out.println("Could not redirect to Add Recording view Page");
			throw (e);
		}

	}

	@When("^I enter recording details and click on create button$")
	public void enterRecordingViewDetails() throws Exception {
		try {
			callrecord.enterTextInTitleField(recodingdata.get("Title"));
			callrecord.selectOrganization(recodingdata.get("Organization"));
			callrecord.selectDNIS();
			callrecord.clickOnSubmitButton();
		} 
		
		catch (Exception e) {
			System.out.println("Could not enter recording view details");
			throw e;
		}

	}

	@Then("^I should see page with message Recording view was successfully created$")
	public void verifyCreateRecordingViewSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Expected message not found", "Recording view was successfully created.",
					context.getPageObjectManager().getCommonPageElements().getSuccessMessageText());
			System.out.println("Create recording view Passed");
		}
		
		catch (Exception e) {
			System.out.println("Create recording view Failed");
			throw e;
		}

	}

	@When("^I click on All Recording View link$")
	public void clickOnAllRecordingViewLink() throws Exception {
		try {
			allRecordingViewPage = context.getPageObjectManager().getAllRecordingViewPage();
			allRecordingViewPage.clickOnSubmenuAllRecordingView();
		}
		
		catch (Exception e) {
			System.out.println("Could not redirect to All Recording View Page");
			throw e;
		}

	}

	@When("^I click on view icon from recording view list$")
	public void clickOnViewIcon() throws Exception {
		try {
			allRecordingViewPage.clickOnShowRecordingViewIcon();
		} 
		
		catch (Exception e) {
			System.out.println("Could not click on View Icon");
			throw e;
		}

	}

	@Then("^I should see recording view page$")
	public void verifyRecordingViewPage() throws Exception {
		try {
			Assert.assertTrue("Expected Recording View Page not found",
					context.getPageObjectManager().getCommonPageElements().getBreadcrumbText().contains("Recording Views"));
			System.out.println("Show Recording View Passed");
		} 
		
		catch (Exception e) {
			System.out.println("Show Recording View Failed");
			throw e;
		}

	}

	@When("^I click edit icon from the recording list$")
	public void clickOnEditRecordingViewIcon() throws Exception {
		try {
			allRecordingViewPage.enterTextInSearchTextbox(recodingdata.get("Title"));
			allRecordingViewPage.clickOnEditRecordingViewIcon();
		}
		
		catch (Exception e) {
			System.out.println("Could not redirect to Edit Recording View page");
			throw e;
		}

	}

	@When("^I update the recording view details and click on Update button$")
	public void updateRecordingViewDetails() throws Exception {
		try {
			callrecord.deselectFirstDnis();
			context.getPageObjectManager().getCommonPageElements().clickSubmitButton();
		} 
		
		catch (Exception e) {
			System.out.println("failed to update recording view details");
			throw e;
		}

	}

	@Then("^I should see page with message Recording view was successfully updated$")
	public void verifyUpdateRecordingViewSuccessMessage() throws Exception {
		try {
			Assert.assertTrue("Expected recording is not updated",
					context.getPageObjectManager().getCommonPageElements().getSuccessMessageText().contains("Recording view was successfully updated."));
			System.out.println("Update Recording view Passed");
		} 
		
		catch (Exception e) {
			System.out.println("Update Recording view failed");
			throw e;
		} 

	}

	@When("^I click on delete icon from the recording view list$")
	public void clickOnDeleteIcon() throws Exception {
		try {
			allRecordingViewPage.enterTextInSearchTextbox(recodingdata.get("Title"));
			allRecordingViewPage.clickOnDeleteRecordingViewIcon();
			allRecordingViewPage.acceptConfirmationPopup();
		} 
		
		catch (Exception e) {
			System.out.println("Could not delete the Recording View");
			throw e;
		}

	}

	@Then("^I should see page with message Recording view was successfully deleted$")
	public void verifyDeleteRecordingViewSuccessMessage() throws Exception {
		try {
			Assert.assertTrue("Expected Success message not shown",
					context.getPageObjectManager().getCommonPageElements().getSuccessMessageText().contains("Recording view was successfully deleted."));
			System.out.println("Delete Recording View Passed");
		}
		
		catch (Exception e) {
			System.out.println("Delete Recording View failed");
			throw e;
		}
	}

}
