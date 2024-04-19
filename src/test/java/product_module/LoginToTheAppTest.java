package product_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginToTheAppTest {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException {

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
	}

}
