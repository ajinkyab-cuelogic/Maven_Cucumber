package stepdefinitions;

import org.junit.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AllSiteReviewsPage;
import pageobject.LoginPage;


public class AllSiteReviews {

	private TestContext context;
	
	public AllSiteReviews(TestContext context) {
		this.context = context;
	}
	
	AllSiteReviewsPage allsiterev;
	LoginPage login;
	
	@Given("^I am logged in as admin user and click on Guest Reviews menu$")
	public void navigateToGuestReviews() throws Exception {
		try {
			login = context.getPageObjectManager().getLogingPage();
			login.doValidLogin(context.getConfigFileReader().getValidEmail(), 
					context.getConfigFileReader().getValidPassword());
			allsiterev = context.getPageObjectManager().getAllSiteReviewPage();
			allsiterev.clickOnMainMenuGuestReviews();
		}

		catch (Exception e) {
			System.out.println("Could not navigate to Guest Reviews");
			throw e;
		}

	}

	@When("^I click on All Site Reviews link$")
	public void clickAllSiteReviewsLink() throws Exception {
		try {
			allsiterev.clickOnSubmenuAllSiteReviews();
		} 
		
		catch (Exception e) {
			System.out.println("Failed to click All Site Reviews link");
			throw e;
		}

	}


	@When("^I select Review$")
	public void selectReview() throws Exception {
		try {
			allsiterev.clickReviewCheckbox();
		}
		
		catch (Exception e) {
			System.out.println("Failed to check Review checkbox");
			throw e;
		}

	}
	
	@When("^I click on Accept button$")
	public void clickAcceptButton() throws Exception {
		try {
			allsiterev.clickAcceptButton();
		} catch (Exception e) {
			System.out.println("Failed to click accept button");
			throw e;
		}

	}
	
	

	@Then("^I should see page with message Selected review accepted successfully$")
	public void verifyAcceptReviewSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Accept Review success message text not matched", "Selected review(s) accepted successfully.",
					allsiterev.getSuccessMessageText());
			System.out.println("test to Accept Review passed");
		} 
		
		catch (Exception e) {
			System.out.println("test to Accept Review failed");
			throw e;
		}

	}

	@When("^I click on Delete button$")
	public void clickDeleteButton() throws Exception {
		try {
			allsiterev.clickDeleteButton();
		} catch (Exception e) {
			System.out.println("Failed to click delete button");
			throw e;
		}
	}

	@Then("^I should see page with message Selected review deleted successfully$")
	public void verifyDeleteReviewSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Delete Review success message text not matched", "Selected review(s) deleted successfully.",
					allsiterev.getSuccessMessageText());
			System.out.println("test to Delete Review passed");
		} 
		
		catch (Exception e) {
			System.out.println("test to Delete Review failed");
			throw e;
		}
	}

	@When("^I click on Decline button$")
	public void clickDeclineButton() throws Exception {
		try {
			allsiterev.clickDeclineButton();
		} catch (Exception e) {
			System.out.println("Failed to click decline button");
			throw e;
		}
	}


	@Then("^I should see page with message Selected review declined successfully$")
	public void verifyDeclineReviewSuccessMessage() throws Exception {
		try {
			Assert.assertEquals("Delete Review success message text not matched", "Selected review(s) declined successfully.",
					allsiterev.getSuccessMessageText());
			System.out.println("test to Decline Review passed");
		} 
		
		catch (Exception e) {
			System.out.println("test to Decline Review failed");
			throw e;
		}
	}

}
