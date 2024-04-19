package com.crm.CAH.generic_Utility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v119.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.CAH.Object_Repository.Home_Page;
import com.crm.CAH.Object_Repository.Login_page;

public class BaseClass {
	
	
	
	public Fileutility fUtil= new Fileutility();
	public ExcelUtility eUtil= new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebdriverUtility wUtil= new WebdriverUtility();
	public Databaseutility dUtil = new Databaseutility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
		dUtil.connectToDB();
		Reporter.log("--connect to Database--",true);
	}
	
	//@Parameters("browser")
	
	@BeforeClass(alwaysRun = true)
	//public void lauchTheBrowser(String BROWSER) throws IOException {
	public void lauchTheBrowser() throws IOException {

		String BROWSER = fUtil.readDataFromPropertyFile("browser");
//		String BROWSER = System.getProperty("browser");
//		String URL = System.getProperty("url");

		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("--Launched chrome browser--",true);
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
			Reporter.log("--Launched firefox browser--",true);
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
			Reporter.log("--Launched edge browser--",true);
		}
		else {
			Reporter.log("--Invalid browser--",true);

		}
		
		sdriver=driver;

		wUtil.maximizeTheWindow(driver);
		wUtil.waitForPageLoad(driver, 10);
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException {
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		driver.get(URL);
		
		Login_page loginPage= new Login_page(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		Reporter.log("--logged into application--",true);

	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() {
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnsignOut(driver, wUtil);
		Reporter.log("--logout from application--",true);
		
		
	}
	

		
	
	@AfterClass(alwaysRun = true)
	   public void closeTheBrowser() {
			driver.quit();
			Reporter.log("--closing the browser--",true);

		}
	
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException {
		dUtil.closeDB();
		Reporter.log("--close Database--",true);
	}

}
//Thankyou
//completed
