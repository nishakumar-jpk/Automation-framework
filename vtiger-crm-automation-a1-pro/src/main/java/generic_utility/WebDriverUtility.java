package generic_utility;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	
	public void fullscreenWindow() {
		driver.manage().window().fullscreen();
	}
	
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public WebElement waitForElementClickable(WebElement element) {
		 return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitAndClick(WebElement element) {
		waitForElementClickable(element).click();
	}

	public void waitForElementInvisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForTextInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	
	public void waitForTitleContains(String titlePart) {
		wait.until(ExpectedConditions.titleContains(titlePart));
	}

	public void waitForUrlContains(String urlFraction, int timeOutSeconds) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}


	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}


	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}


	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}


	public void clearText(WebElement element) {
		element.clear();
	}

	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void sendKeyboardKey(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	public void navigateBack() {
		driver.navigate().back();
	}


	public void navigateForward() {
		driver.navigate().forward();
	}

	
	public void refreshPage() {
		driver.navigate().refresh();
	}

	
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	
	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}


	public boolean isCheckboxChecked(WebElement checkbox) {
		return checkbox.isSelected();
	}

	
	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	
	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	
	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	
	public void pressEscape(WebElement element) {
		element.sendKeys(Keys.ESCAPE);
	}

	
	public void pressTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	
	public void pressCtrlA(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	
	public void pressCtrlC(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	
	public void pressCtrlV(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}


	
	//public void takeScreenshot(String screenshotName) throws IOException {
		//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File dest = new File("./screenshots/" + screenshotName + ".png");
		//Files.copy(src, dest);
	//}


	public void takeScreenshotWithTimestamp(String baseName) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy");
		LocalDateTime now = LocalDateTime.now();
		String timestamp = dtf.format(now);
		takeScreenshotWithTimestamp(baseName + "_" + timestamp);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}


	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}
	


	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void jsSetValue(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	}

	public String jsGetValue(WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", element);
	}

	public void jsScrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void jsScrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}


	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String i : windowHandles) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
	}


	public void switchToWindowByUrl(String partialURL) {
		Set<String> CIDs = driver.getWindowHandles(); // returns Set<String> of multiple unique session ids

		for (String i : CIDs) {
			driver.switchTo().window(i);
			String curl = driver.getCurrentUrl();
			if (curl.contains(partialURL)) {
				break;
			}
		}
	}
	

	public void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}

	public void closeAllChildWindows(String parentWindowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}
}