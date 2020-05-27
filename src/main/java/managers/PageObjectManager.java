package managers;

import org.openqa.selenium.WebDriver;
import pageobject.AllSiteReviewsPage;
import pageobject.CommonPageElements;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.call_recordings.AllRecordingViewPage;
import pageobject.call_recordings.RecordingView;
import pageobject.cc_ip_addresses.AllIPAddressesPage;
import pageobject.cc_ip_addresses.IPAddress;

public class PageObjectManager {
	
	private AllSiteReviewsPage allsiterevpage;
	private HomePage homepage;
	private LoginPage loginpage;
	private WebDriver driver;
	private IPAddress ipaddress;
	private AllIPAddressesPage allipaddress;
	private RecordingView recordingView;
	private AllRecordingViewPage allRecordingViewPage;
	private CommonPageElements commonPageElement;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public AllSiteReviewsPage getAllSiteReviewPage() {
		return (allsiterevpage == null) ? allsiterevpage = new AllSiteReviewsPage(driver) : allsiterevpage;
	}
	
	public HomePage getHomePage() {
		return (homepage == null) ? homepage = new HomePage(driver) : homepage;
	}
	
	public LoginPage getLogingPage() {
		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;		
	}
	
	public IPAddress getIPAddressPage () {
		return (ipaddress == null) ? ipaddress = new IPAddress(driver) : ipaddress;
	}
	
	public AllIPAddressesPage getAllIPAddressesPage() {
		return (allipaddress == null) ? allipaddress = new AllIPAddressesPage(driver) : allipaddress;
	}
	
	public RecordingView getRecordingViewPage() {
		return (recordingView == null) ? recordingView = new RecordingView(driver) : recordingView;
	}
	
	public AllRecordingViewPage getAllRecordingViewPage() {
		return (allRecordingViewPage == null) ? allRecordingViewPage = new AllRecordingViewPage(driver) : allRecordingViewPage;
	}
	
	public CommonPageElements getCommonPageElements() {
		return (commonPageElement == null) ? commonPageElement =  new CommonPageElements(driver) : commonPageElement;
	}

}
