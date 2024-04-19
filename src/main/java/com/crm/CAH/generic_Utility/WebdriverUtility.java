package com.crm.CAH.generic_Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 *@author Aparna
 *@param key
 *@return
 *@throws
 */
public class WebdriverUtility {
	
	private static final String JavascriptExecutor = null;
	//maximizing
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	//minimizing
	public void minimizeTheWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	//implicitWait
	public void waitForPageLoad(WebDriver driver,int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	
	//explicitwait
	public WebDriverWait webDriverWaitObj(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	public void waitUntilelementToBeVisible(WebDriver driver, int sec,WebElement element) {
		webDriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilelementToBeClickable(WebDriver driver, int sec,WebElement element) {
		webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilelementTogetTitle(WebDriver driver, int sec,String title) {
		webDriverWaitObj(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	//select
	public Select selectObj(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	public void handleDropdownbyVisibleText(WebElement element,String text) {
		selectObj(element).selectByVisibleText(text);
	}
	public void handleDropdownbyIndex(WebElement element,int index) {
		selectObj(element).selectByIndex(index);
	}
	public void handleDropdownbyValue(WebElement element,String text) {
		selectObj(element).selectByValue(text);
	}
	public void handleDropdownDeselectbyVisibleText(WebElement element,String text) {
		selectObj(element).deselectByVisibleText(text);
	}
	public void handleDropdownDeselectbyIndex(WebElement element,int index) {
		selectObj(element).deselectByIndex(index);
	}
	public void handleDropdownDeselectbyValue(WebElement element,String text) {
		selectObj(element).deselectByValue(text);
	}
	
	//action
	public Actions actionObj(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;
	}
	public void dragAnddrop(WebDriver driver,WebElement src, WebElement des) {
		actionObj(driver).dragAndDrop(src, des).perform();
	}
	public void dragAnddrop(WebDriver driver,WebElement element,int x, int y) {
		actionObj(driver).dragAndDropBy(element, x, y).perform();
	}
	public void sendkeys(WebDriver driver) {
		actionObj(driver).sendKeys(Keys.ENTER).perform();
	}
	public void sendkeys(WebDriver driver,WebElement element) {
		actionObj(driver).sendKeys(element, Keys.ENTER).perform();
	}
	public void sendkeys(WebDriver driver,WebElement element,String text) {
		actionObj(driver).sendKeys(element, text).perform();
	}
	public void doubleClick(WebDriver driver) {
		actionObj(driver).doubleClick().perform();
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		actionObj(driver).doubleClick(element).perform();
	}
	public void click(WebDriver driver) {
		actionObj(driver).click().perform();
	}
	public void Click(WebDriver driver,WebElement element) {
		actionObj(driver).click(element).perform();
	}
	public void clickandHold(WebDriver driver) {
		actionObj(driver).clickAndHold().perform();
	}
	public void ClickandHold(WebDriver driver,WebElement element) {
		actionObj(driver).clickAndHold(element).perform();
	}
	public void contextClick(WebDriver driver) {
		actionObj(driver).contextClick().perform();
	}
	public void contextClick(WebDriver driver,WebElement element) {
		actionObj(driver).contextClick(element).perform();
	}
	public void moveToElement(WebDriver driver,WebElement element) {
		actionObj(driver).moveToElement(element).perform();
	}
	public void moveToElement(WebDriver driver,WebElement element,int x,int y) {
		actionObj(driver).moveToElement(element, x, y).perform();
	}
	public void moveByOffset(WebDriver driver,int x,int y) {
		actionObj(driver).moveByOffset(x, y).perform();
	}
	public void moveToLocation(WebDriver driver,int x,int y) {
		actionObj(driver).moveToLocation(x, y).perform();
	}
	public void scrollToElement(WebDriver driver, WebElement element) {
		actionObj(driver).scrollToElement(element).perform();
	}
	public void scrollByAmount(WebDriver driver, WebElement element,int x,int y) {
		actionObj(driver).scrollByAmount(x, y).perform();
	}
//	public void scrollToElement(WebDriver driver, WebElement element,int x,int y) {
//		actionObj(driver).scrollFromOrigin(null, x, y).perform();
//	}
	public void keyUp(WebDriver driver) {
		actionObj(driver).keyUp(Keys.ENTER).perform();
	}
	public void keyUp(WebDriver driver, WebElement element) {
		actionObj(driver).keyUp(element, Keys.ENTER).perform();
	}
	public void keyDown(WebDriver driver) {
		actionObj(driver).keyDown(Keys.ENTER).perform();
	}
	public void keyDown(WebDriver driver, WebElement element) {
		actionObj(driver).keyDown(element, Keys.ENTER).perform();
	}
	public void release(WebDriver driver) {
		actionObj(driver).release().perform();
	}
	public void relaese(WebDriver driver, WebElement element) {
		actionObj(driver).release(element).perform();
	}
	public void build(WebDriver driver) {
		actionObj(driver).build().perform();
	}
	public void pause(WebDriver driver, int sec) {
		actionObj(driver).pause(Duration.ofSeconds(sec)).perform();
	}
	public void pause( int lsec,WebDriver driver) {
		actionObj(driver).pause(lsec).perform();
	}
	/*
	public void getActiveKeyboard(WebDriver driver) {
		actionObj(driver).getActiveKeyboard();
	}
	public void getActivePointer(WebDriver driver) {
		actionObj(driver).getActiveKeyboard();
	}
	public void getActiveWheel(WebDriver driver) {
		actionObj(driver).getActiveWheel();
	}
	public void tick(WebDriver driver) {
		actionObj(driver).tick(null);
	}*/
	
	//windowHandles
	public void switchWindow(WebDriver driver,String expWind) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String win =  it.next();
			String currentUrl = driver.switchTo().window(win).getCurrentUrl();
			if(currentUrl.contains(expWind)) {
				break;
			}
		}
	}
	
	
	//Robot Class
	
	public Robot robotobj() throws AWTException {
		Robot robot = new Robot();
		return robot;
	}
	public void presskey() throws AWTException {
		robotobj().keyPress(KeyEvent.VK_ENTER);
	}
	public void releasekey() throws AWTException {
		robotobj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	//frame
	public void switchToframebyIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToParentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void switchTodefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void switchToframebyWebElement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToframebynameOrId(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	//PopUp
	
	//JavaScriptPopup
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String prompt(WebDriver driver) {
		String confirmationMsg = driver.switchTo().alert().getText();
		return confirmationMsg;
	}
	
	
	
	//shadowRoot

	
	
	
	//Screenshot
	
	//WebPageScreenShot
	public static String webPageScreenShot(WebDriver driver, String screeshotName) throws IOException {
		JavaUtility jUtils = new JavaUtility();
		TakesScreenshot ts= (TakesScreenshot)driver;
		//String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		//File permfile = new File("./screeshot"+timeStamp+screeshotName+".png");
		File permfile = new File("./screenshot/"+screeshotName+jUtils.getSystemDateInFormat()+".png");

		String scrPath = permfile.getAbsolutePath();
		FileUtils.copyFile(tempfile, permfile);
		return scrPath;
	}
	
	//javaScriptExecutor
	
	//JsDisplayAlert
	
	public JavascriptExecutor jsObject(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		return jse;
		
	}
	public void displayingAlert(WebDriver driver, String statement) {
		jsObject(driver).executeScript("alert('"+statement+"')");
	}
	public void enteringText(WebDriver driver, String text,WebElement element) {
		jsObject(driver).executeScript("arguments[0].value='"+text+"'",element);
	}
	public void clickingOnTheElement(WebDriver driver,WebElement element) {
		jsObject(driver).executeScript("arguments[0].click()",element);
	}
	
	public String retrievingThetext(WebDriver driver,WebElement element) {
    String text=(String)jsObject(driver).executeScript("return arguments[0].value;", element);
    return text;
	}
	
//javaScriptExecutor_scrolling
	
	public void scrollTo(WebDriver driver,int x, int y) {
		jsObject(driver).executeScript("window.scrollTo("+x+","+y+")");
	}
	public void scrollBy(WebDriver driver,int x, int y) {
		jsObject(driver).executeScript("window.scrollBy("+x+","+y+")");
	}
	public void scrollToBottomOfPage(WebDriver driver) {
		jsObject(driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollfromBottomOfPagetoupward(WebDriver driver) {
		jsObject(driver).executeScript("window.scrollTo(0,-document.body.scrollHeight)");

	}
	public void scrollToelementLocation(WebDriver driver,WebElement element) {
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		jsObject(driver).executeScript("window.scrollBy("+x+","+y+")",element);
	}
	public void scrollIntoView(WebDriver driver,WebElement element) {
		jsObject(driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	
	
	
	
	
	
	

}
