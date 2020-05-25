package stepdefinitions;


import org.junit.Assert;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.LoginPage;

public class Login {

	private TestContext context;
	private LoginPage loginPage;
	private HomePage homePage;
	
	public Login(TestContext context) {
		this.context = context;
	}

	
	@Given("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
		loginPage = context.getPageObjectManager().getLogingPage();
		Assert.assertEquals("Login page not found", context.getPageTitle(), "Phalanx");
	}

	@When("^I enter email and password$")
	public void i_enter_email_and_password() throws Throwable {
		loginPage.enterEmailandPassword(context.getConfigFileReader().getValidEmail(), context.getConfigFileReader().getValidPassword());
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		loginPage.clickSubmit();
	}

	@Then("^I should see the Home page$")
	public void i_should_see_the_Home_page() throws Throwable {
		homePage = context.getPageObjectManager().getHomePage();
		Assert.assertEquals("Home page title does not match", homePage.getHomePageTitle(), "Home");
	}
	
	@When("^I enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_email_as_and_password_as(String email, String pasword) throws Throwable {
		loginPage.enterEmailandPassword(email, pasword);
		System.out.println("executed step with params");
	}
	
	@Then("^I should see the Login page with error message$")
	public void verifyIncorrectLogin() throws Throwable {
		Assert.assertEquals("Login page error messafe text does not match",loginPage.getErrorMessageText(),"Invalid email or password.");
	}

}
