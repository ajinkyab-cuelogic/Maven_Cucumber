package stepdefinitions;


import org.junit.Assert;
import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.HomePage;
import pageobject.LoginPage;

public class login extends BaseUtil{
	
	private BaseUtil base;
	LoginPage login;
	HomePage home;
	
	public login(BaseUtil base) {
		System.out.println("In login class constuctor");
		this.base = base;
		System.out.println("base object " + base);
	}
	
	
	@Given("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
		System.out.println(base.driver +"       in given : driver object");
		base.driver.get("https://admin-stg.travelpass.com");
		Assert.assertEquals("Login page not found", base.driver.getTitle(), "Phalanx");
	}

	@When("^I enter email and password$")
	public void i_enter_email_and_password() throws Throwable {
		login = new LoginPage(base.driver);
		login.enterEmail("aj-agent@yopmail.com");
		login.enterPassword("pass#123");
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		login.clickSubmit();
	}

	@Then("^I should see the Home page$")
	public void i_should_see_the_Home_page() throws Throwable {
		home = new HomePage(base.driver);
		System.out.println("Home page object " + home);
		Assert.assertEquals("Home page title does not match",home.getHomePageTitle(),"Home");
	}
	
	@When("^I enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_email_as_and_password_as(String email, String pasword) throws Throwable {
		login = new LoginPage(base.driver);
		login.enterEmailandPassword(email, pasword);
		System.out.println("executed step with params");
	}
	
	@Then("^I should see the Login page with error message$")
	public void verifyIncorrectLogin() throws Throwable {
		Assert.assertEquals("Login page error messafe text does not match",login.getErrorMessageText(),"Invalid email or password.");
	}

}
