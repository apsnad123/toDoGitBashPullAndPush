package product_module;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.CAH.Object_Repository.Login_page;

public class practice {
	@Test(dataProviderClass = dataProveiderTest.class, dataProvider = "vtigerlog",enabled = false)
	public void login(String username,String pwd) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		Login_page login = new Login_page(driver);
		login.loginToApp(username, pwd);
	}
	
	@Test(dataProviderClass = dataProveiderTest.class,dataProvider = "readDataFromExcel1")
	public void getCampaignDataFromTest(String key,String path,String data) {
		System.out.println(key+"--->"+path+"--->"+data);
		
	}
	
	@Test(dataProviderClass = dataProveiderTest.class,dataProvider = "readDataFromExcel2")
	public void getCampaignDataFromTest1(String key,String path,String data) {
		System.out.println(key+"--->"+path+"--->"+data);
		
	}
	
	@Test(dataProviderClass = dataProveiderTest.class,dataProvider = "takingDataFromExcelbyphsical")
	public void getCampaignDataFromTest2(String key,String path,String data) {
		System.out.println(key+"--->"+path+"--->"+data);
		
	}

}
