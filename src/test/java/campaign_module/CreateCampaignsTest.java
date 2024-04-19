package campaign_module;

	
	
	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Random;
	import java.util.Set;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

import com.crm.CAH.Object_Repository.Home_Page;

	public class CreateCampaignsTest {

		public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {

			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\common.Data");
			Properties pObj = new Properties();
			pObj.load(fis);
			
			//login to the Customer Association Hub 
			String browser = pObj.getProperty("browser");
			if(browser.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			driver.get(pObj.getProperty("url"));
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(pObj.getProperty("username"));
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pObj.getProperty("password"));
			driver.findElement(By.id("submitButton")).submit();
		
		
		//navigating to the more tab
       Home_Page homepage = new Home_Page(driver);	
       homepage.getMoreTab();
	 //navigating to the campaign page
	   homepage.clickOnCampaign();
	 
	   //navigating to the create Lead page
	   driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
		}
	}
//hi n hello

