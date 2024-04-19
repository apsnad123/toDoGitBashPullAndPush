package product_module;

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

public class EditingProductTest {

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
	
	
	//navigating to the product page
   driver.findElement(By.xpath("//a[.='Products']")).click();
 
   //navigating to the create product page
   driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
	
   //connecting to the Excel and importing data
	FileInputStream excel= new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
   Workbook wb = WorkbookFactory.create(excel);
   Sheet sh = wb.getSheet("productInfo");
   String Product_Name = sh.getRow(1).getCell(1).toString();
   String Product_Category = sh.getRow(2).getCell(1).toString();
   String Vendor_Name = sh.getRow(3).getCell(1).toString();
   String Vendor_Part_No = sh.getRow(4).getCell(1).toString();
   String Product_Sheet = sh.getRow(5).getCell(1).toString();
   String GL_Account = sh.getRow(6).getCell(1).toString();
   String Part_Number = sh.getRow(7).getCell(1).toString();
   String manufacturer = sh.getRow(8).getCell(1).toString();
   String Website = sh.getRow(9).getCell(1).toString();
   String Mfr_Part_No = sh.getRow(10).getCell(1).toString();
   String Serial_No = sh.getRow(11).getCell(1).toString();
   String Unit_Price = sh.getRow(12).getCell(1).toString();
   String Commission_Rate = sh.getRow(13).getCell(1).toString();
   String Usage_Unit = sh.getRow(14).getCell(1).toString();
   String Qty_in_Stock = sh.getRow(15).getCell(1).toString();
   String Handler = sh.getRow(16).getCell(1).toString();
   String Qty_Unit = sh.getRow(17).getCell(1).toString();
   String Reorder_Level = sh.getRow(18).getCell(1).toString();
   String Qty_in_Demand = sh.getRow(19).getCell(1).toString();
   String Description  = sh.getRow(20).getCell(1).toString();
   String Search_Name  = sh.getRow(21).getCell(1).toString();

   
   //random number
   Random r = new Random();
   int random = r.nextInt(500);
    String random_product_name = Product_Name+random;
   
   
   //entering all the textField

   driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(random_product_name);
   //driver.findElement(By.xpath("//img[contains(@id,'jscal_trigger_sales_start')]")).click();
   //driver.findElement(By.xpath("//td[.='March, 2024']/ancestor::tbody/tr/td[.='31']")).click();
   WebElement product_category = driver.findElement(By.xpath("//select[@name='productcategory']"));
   Select select_product_category = new Select(product_category);
   select_product_category.selectByValue(Product_Category);
   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
   
	Set<String> allWind = driver.getWindowHandles();
	for (String eachWind : allWind) {
		String title = driver.switchTo().window(eachWind).getCurrentUrl();
		if(title.contains("Vendors&action")) {
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(Search_Name);
		    driver.findElement(By.xpath("//input[@name='search']")).click();
            driver.findElement(By.xpath("//tr/td/a[.='"+Search_Name+"']")).click();
            driver.close();
		}
            else if(title.contains("Products&action")) {
            	driver.findElement(By.id("vendor_part_no")).sendKeys(Vendor_Part_No);
    		    driver.findElement(By.id("productsheet")).sendKeys(Product_Sheet);
    		    WebElement GL_Account_path = driver.findElement(By.xpath("//select[@name='glacct']"));
    		    Select select_GL_Account = new Select(GL_Account_path);
    		    select_GL_Account.selectByValue(GL_Account);
            	driver.findElement(By.id("productcode")).sendKeys(Part_Number);
            	WebElement manufacturer_drop = driver.findElement(By.xpath("//select[@name='manufacturer']"));
            	manufacturer_drop.click();
                Select select_manufacturer = new Select(manufacturer_drop);
                select_manufacturer.selectByIndex(2);
    		    driver.findElement(By.xpath("//input[@name='website']")).sendKeys(Website);
    		    driver.findElement(By.xpath("//input[@name='serial_no']")).sendKeys(Serial_No);
    		    driver.findElement(By.id("tax1_check")).click();
    		    driver.findElement(By.id("tax2_check")).click();
    		    driver.findElement(By.id("tax3_check")).click();
    		    driver.findElement(By.id("commissionrate")).sendKeys(Commission_Rate);
    		    driver.findElement(By.xpath("//input[@name='website']")).sendKeys(Website);
    		    
    		    WebElement usage_unit_drop = driver.findElement(By.xpath("//select[@name='usageunit']"));
    		    Select select_usage_unit = new Select(usage_unit_drop);
    		    select_usage_unit.selectByValue(Usage_Unit);
    		    driver.findElement(By.id("qtyinstock")).sendKeys(Qty_in_Stock);
    		    driver.findElement(By.xpath("//input[@value='U']")).click();
    		    driver.findElement(By.id("qty_per_unit")).sendKeys(Qty_Unit);
    		    driver.findElement(By.id("reorderlevel")).sendKeys(Reorder_Level);
    		    driver.findElement(By.id("qtyindemand")).sendKeys(Qty_in_Demand);
    		    driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(Description);
                driver.findElement(By.xpath("//input[@type='submit']")).click();
                

                //edit the duplicate product
              driver.findElement(By.xpath("//input[@name='Edit']")).click();
              WebElement ProductName = driver.findElement(By.xpath("//input[@name='productname']"));
              Actions action = new Actions(driver);
              ProductName.clear();
              action.sendKeys(ProductName, Product_Name).perform();
              driver.findElement(By.xpath("//input[@type='submit']")).click();


            }
		    
		                                    
	                                }
		
	
	
	}
	
	
	}  

	
	
		
	 

	
	
		

