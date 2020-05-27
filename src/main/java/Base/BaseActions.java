package Base;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseActions {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BaseActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	 public WebElement findAnyElement(By locator){
	        WebElement element = driver.findElement(locator);
	        return element;
	    }

	public int getSizeListOfWebElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		int numbers = elements.size();
		return numbers;
	}

	public WebElement spanContainsText(String text) {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(), '" + text + "')]"));
		return element;
	}

	public void clickElementByText(String text, By locator) {
		WebElement element = driver.findElement(locator);
		if (element.getText().contains(text)) {
			element.click();
		}
	}
	
	public void setElementText(By locator,String text) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public void setElementText(WebElement element,String text) {
		element.sendKeys(text);	
	}
	
	public String getElementText(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).getAttribute("innerText");
	}
	
	public void clickUnselectedCheckbox(By locator) {
		WebElement checkboox = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if(!checkboox.isSelected()) {
			performClick(checkboox);
		}
	}

	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		ajaxClick(element);
	}

	public void clickElement(By by) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
	}
	
	public void acceptConfirmationPopup() {
		driver.switchTo().alert().accept();
	}
	
	public void rejectConfirmationPopup() {
		driver.switchTo().alert().dismiss();
	}

	// Different varieties of Ajax click
	public void ajaxClear(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element);
	}

	public void ajaxClear(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", driver.findElement(locator));

	}
	
	public void sendKeysWithAjax(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		ajaxFocus(element);
		setElementText(locator, text);
		
	}

	public void ajaxFocus(WebElement element) {
		((JavascriptExecutor) driver).executeScript("focus()", element);
	}

	public void ajaxClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void ajaxClick(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		ajaxClick(driver.findElement(by));
	}

	public void ajaxClick(By by, int index) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		ajaxClick(driver.findElements(by).get(index));
	}

	public void performClick(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click().build().perform();
	}

	public void performClick(By locator, int index) {
		WebElement element = driver.findElements(locator).get(index);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click().build().perform();
	}

	public void performClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click().build().perform();
	}

	public void performSendKeys(WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.sendKeys(text).build().perform();
	}

	public void performSendKeys(By locator, String text) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(locator)).perform();
		actions.sendKeys(text).build().perform();
	}

//	public void clickUnselectedCheckbox(By checkbox) {
//		WebElement currentCheckbox = driver.findElement(checkbox);
//		if (!currentCheckbox.isSelected()) {
//			ajaxClick(currentCheckbox);
//		}
//	}

	public void clickUnselectedCheckbox(WebElement currentCheckbox) {
		if (!currentCheckbox.isSelected()) {
			ajaxClick(currentCheckbox);
		}
	}

	public void clickUnselectedCheckbox(By checkbox, int index) {
		WebElement currentCheckbox = driver.findElements(checkbox).get(index);
		if (!currentCheckbox.isSelected()) {
			ajaxClick(currentCheckbox);
		}
	}

	// Scrolls
	public void scrollToBottomOfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void ajaxScroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void ajaxScroll(By locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public void ajaxScroll(By by, int index) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		ajaxScroll(driver.findElements(by).get(index));
	}

	public void ajaxScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
	}

	public static String generateNewNumber(String name, int length) {
		return name + RandomStringUtils.random(length, "172984757");
	}

	public static String generateEmail(String domain, int length) {
		return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + "@" + domain;
	}

	public static String generateNewWord(int length) {
		return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
	}

	public static String generateNewWord(String word, int length) {
		return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + word;
	}

	public void getDropDownListByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void setDropDownOptionByIndex(By locator, int index) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void unsetDropDownOptionByIndex(By locator, int index) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select select = new Select(element);
		select.deselectByIndex(index);
	}


	public void getDropDownListByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void setDropDownOptionByText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void getDropDownListByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void getDropDownListByValue(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}

	public void ajaxSendKeys(WebElement element, String text) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
	}

	public void ajaxSendKeys(By locator, String text) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + text + "')",
				driver.findElement(locator));
	}

	public static String generateRandomString() {
		return new BigInteger(120, new SecureRandom()).toString(32);
	}

	// Method for random choice from dropdown list
	public void selectItemDropDownRandomOption(By locator, String dropDownName) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Select select = new Select(driver.findElement(locator));
			select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
			System.out.println(dropDownName + ": " + select.getFirstSelectedOption().getText());
		} catch (NoSuchElementException e) {

		}
	}

	public void checkLinksOnWebPage(String typeElement, String attribute) {

		List<WebElement> links = driver.findElements(By.xpath(typeElement));

		System.out.println("I start taking  attributes on page");
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute(attribute);
			verifyLinkActive(url);
		}
		System.out.println("Total links are " + links.size());
	}

	// Method for link verification

	public void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			} else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ httpURLConnect.getResponseMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getSizeDropDownList(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Select select = new Select(driver.findElement(locator));
			return select.getOptions().size();

		} catch (NoSuchElementException e) {
			System.out.println("getSizedropDownList error");

		}
		return 0;

	}

	public void clickValueOfLists(By locator, String text) {
		List<WebElement> elements = driver.findElements(locator);
		for (int i = 0; i < elements.size(); i++) {
			WebElement elementOfList = elements.get(i);
			String value = elementOfList.getText();
			if (value.contains(text)) {
				wait.until(ExpectedConditions.elementToBeClickable(elementOfList));
				elementOfList.click();
			}
		}
	}

}
