package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BaseActions;


public class AllSiteReviewsPage extends BaseActions{
	
	
	By search_button = By.xpath("//input[@value='Search']");	
	By checkbox_revives = By.id("selected_reviews_");
	By button_accept = By.xpath("//input[@value='Accept']");
	By button_delete = By.xpath("//input[@value='Delete']");	
	By button_decline = By.xpath("//input[@value='Decline']");
	By dropdown_status = By.id("is_deleted");
	By mainment_guest_reviews = By.xpath("//a[contains(.,'Guest Reviews ')]");
	By submenu_all_site_reviews = By.xpath("//a[contains(.,'All Site Reviews')]");
	By success_message = By.xpath("//div[contains(@class,'alert-success')]");
	
	
	public AllSiteReviewsPage(WebDriver driver) {
		super(driver);
	}
	

	public void clickOnMainMenuGuestReviews() throws Exception {
		try {
			clickElement(mainment_guest_reviews);
			System.out.println("Main menu Guest Reviews clicked");
		}

		catch (Exception e) {
			System.out.println("Main menu Guest Reviews not clicked");
			throw (e);
		}
	}



	public void clickOnSubmenuAllSiteReviews() throws Exception {
		try {
			clickElement(submenu_all_site_reviews);
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
			text = getElementText(success_message);
		} catch (Exception e) {
			System.out.println("Could not get Success message text");
			throw (e);
		}
		return text;
	}
	
	public void clickReviewCheckbox() throws Exception {
		try {
			clickUnselectedCheckbox(checkbox_revives);
			System.out.println("Review checkbox clicked");
		}
		
		catch (Exception e) {
			System.out.println("Review checkbox not clicked");
			throw(e);
		}
		
	}


	
	public void clickAcceptButton() throws Exception {
		try {
			clickElement(button_accept);
			System.out.println("Accept button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Accept button not clicked");
			throw(e);
		}
	}



	public void clickDeleteButton() throws Exception {
		try {
			clickElement(button_delete);
			System.out.println("Delete button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Delete button not clicked");
			throw(e);
		}
	}

	public void clickDeclineButton() throws Exception {
		try {
			clickElement(button_decline);
			System.out.println("Decline button clicked");
		}
		
		catch (Exception e) {
			System.out.println("Decline button not clicked");
			throw(e);
		}
	}


}
