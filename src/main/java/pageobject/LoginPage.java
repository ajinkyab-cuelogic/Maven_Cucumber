package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement password;

	@FindBy(name="commit")
	WebElement submit;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmail(String strEmail) {
		try {
				email.sendKeys(strEmail);
				System.out.println("Entered Email");
		}catch (Exception e) {
			System.out.println("Email not entered");
		}
	}
	
	public void enterPassword(String strPassword) {
		try {
				password.sendKeys(strPassword);
				System.out.println("Entered Password");
		}catch (Exception e) {
			System.out.println("Password not entered");
		}
	}
	
	public void clickSubmit() {
		try {
				submit.click();
				System.out.println("Submit button clicked");
		}catch (Exception e) {
			System.out.println("Submit button not clicked");
		}
	}
	
	public void enterEmailandPassword(String email, String pasword) {
		enterEmail(email);
		enterPassword(pasword);
		System.out.println("In enterEmailandPassword method");
	}

}
