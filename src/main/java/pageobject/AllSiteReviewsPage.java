package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AllSiteReviewsPage {
	
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement btn_Search;
	
	@FindBy(id="selected_reviews_")
	WebElement checkbox_Review;
	
	@FindBy(xpath="//input[@value='Accept']")
	WebElement btn_Accept;

	@FindBy(xpath="//input[@value='Delete']")
	WebElement btn_Delete;
	
	@FindBy(xpath="//input[@value='Decline']")
	WebElement btn_Decline;
	
	@FindBy(id="is_deleted")
	WebElement dropdown_Status;
	
	@FindBy(xpath="//a[contains(.,'Guest Reviews ')]")
	WebElement mainmenu_GuestReviews;
	
	@FindBy(xpath="//a[contains(.,'All Site Reviews')]")
	WebElement submenu_AllSiteReviews;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	WebElement msg_Success;
	
	
	public AllSiteReviewsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public void clickOnMainMenuGuestReviews() throws Exception {
		try {
			mainmenu_GuestReviews.click();
			System.out.println("Main menu Guest Reviews clicked");
		}

		catch (Exception e) {
			System.out.println("Main menu Guest Reviews not clicked");
			throw (e);
		}
	}



	public void clickOnSubmenuAllSiteReviews() throws Exception {
		try {
			submenu_AllSiteReviews.click();
			System.out.println("Submenu All Site Reviews clicked");
		}

		catch (Exception e) {
			System.out.println("Submenu All Site Reviews not clicked");
			throw (e);
		}
	}



	public String getSuccessMessageText() throws Exception {
		String text = null;
		try {
			text = msg_Success.getAttribute("innerText");
		} catch (Exception e) {
			System.out.println("Could not get Success message text");
			throw (e);
		}
		return text;
	}
	

	public Select drpdown_status() throws Exception {

		Select select = null;
		try {
			select = new Select(dropdown_Status);
			System.out.println("Status drop down Found");
		}

		catch (Exception e) {
			System.out.println("Status drop down not found");
		}
		return select;
	}



	
	public void clickReviewCheckbox() throws Exception {
		try {
			checkbox_Review.click();
			System.out.println("Review checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Review checkbox not clicked");
			throw(e);
		}
		
	}


	
	public void clickAcceptButton() throws Exception {
		try {
			btn_Accept.click();
			System.out.println("Accept button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Accept button not clicked");
			throw(e);
		}
	}



	public void clickDeleteButton() throws Exception {
		try {
			btn_Delete.click();
			System.out.println("Delete button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Delete button not clicked");
			throw(e);
		}
	}

	public void clickDeclineButton() throws Exception {
		try {
			btn_Decline.click();
			System.out.println("Decline button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Decline button not clicked");
			throw(e);
		}
	}


}
