
	
	
package product_module_Generic;

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
//import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.CAH.Object_Repository.CreateProduct_page;
import com.crm.CAH.Object_Repository.Home_Page;
import com.crm.CAH.Object_Repository.Login_page;
import com.crm.CAH.Object_Repository.ProductDetailView_page;
import com.crm.CAH.Object_Repository.ProductList_page;
import com.crm.CAH.Object_Repository.VendorList_page;
import com.crm.CAH.generic_Utility.BaseClass;
import com.crm.CAH.generic_Utility.Databaseutility;
import com.crm.CAH.generic_Utility.ExcelUtility;
import com.crm.CAH.generic_Utility.Fileutility;
import com.crm.CAH.generic_Utility.JavaUtility;
import com.crm.CAH.generic_Utility.WebdriverUtility;

//@Listeners(com.crm.CAH.generic_Utility.ListerImplimentationClass.class)
public class DeletingProduct_GenericUtilsTest extends BaseClass {

	
	@Test
	public void deletingProduct() throws IOException, InterruptedException {
		
		
	
	//navigating to the product page
		Home_Page  homePage = new Home_Page(driver);
		 homePage.clickOnProduct();
 
   //navigating to the create product page
 		ProductList_page productPage = new ProductList_page(driver);
       productPage.productLogo(); 
   	
   //connecting to the Excel and importing data
   
	
   String Product_Name = eUtil.readDataFromExcel("productInfo", 1, 1);
   String Product_Category = eUtil.readDataFromExcel("productInfo", 2, 1);
   String Vendor_Name = eUtil.readDataFromExcel("productInfo", 3, 1);
   String Vendor_Part_No = eUtil.readDataFromExcel("productInfo", 4, 1);
   String Product_Sheet = eUtil.readDataFromExcel("productInfo", 5, 1);
   String GL_Account = eUtil.readDataFromExcel("productInfo", 6, 1);
   String Part_Number = eUtil.readDataFromExcel("productInfo", 7, 1);
   String manufacturer = eUtil.readDataFromExcel("productInfo", 8, 1);
   String Website = eUtil.readDataFromExcel("productInfo", 9, 1);
   String Mfr_Part_No = eUtil.readDataFromExcel("productInfo", 10, 1);
   String Serial_No = eUtil.readDataFromExcel("productInfo", 11, 1);
   String Unit_Price = eUtil.readDataFromExcel("productInfo", 12, 1);
   String Commission_Rate = eUtil.readDataFromExcel("productInfo", 13, 1);
   String Usage_Unit = eUtil.readDataFromExcel("productInfo", 14, 1);
   String Qty_in_Stock = eUtil.readDataFromExcel("productInfo", 15, 1);
   String Handler = eUtil.readDataFromExcel("productInfo", 16, 1);
   String Qty_Unit = eUtil.readDataFromExcel("productInfo", 17, 1);
   String Reorder_Level = eUtil.readDataFromExcel("productInfo", 18, 1);
   String Qty_in_Demand =eUtil.readDataFromExcel("productInfo", 19, 1);
   String Description  = eUtil.readDataFromExcel("productInfo", 20, 1);
   String Search_Name  = eUtil.readDataFromExcel("productInfo", 21, 1);
   String In  = eUtil.readDataFromExcel("productInfo", 22, 1);

   
   //random number
   int ran = jUtil.getRandomNo();
    String random_product_name = Product_Name+ran;
   
   
  //entering all the textField

    CreateProduct_page createProductPage = new CreateProduct_page(driver);
     createProductPage.fillingProductMandotoryField(random_product_name, wUtil, Product_Category, driver, "Vendors&action"); 
     
  //switching window  
   VendorList_page vendorListPg = new VendorList_page(driver);
   vendorListPg.vendorWindow(Search_Name, driver);
   
   //switching back to window 
    wUtil.switchWindow(driver, "Products&action");
    
    createProductPage.fillingProductField(Vendor_Part_No, Product_Sheet, wUtil, GL_Account, Part_Number, ran, Website, Serial_No, Commission_Rate, Usage_Unit, Qty_in_Stock, Qty_Unit, Reorder_Level, Qty_in_Demand, Description);
     	  

                //delete the saved product
                ProductDetailView_page productDetailViewPage = new ProductDetailView_page(driver);
               // Assert.fail();
                productDetailViewPage.deleting();
                wUtil.acceptAlert(driver);
		        
		                                    
	                                }
		
	
	
	}
	
	
	 

	
	
		
	 

	
	
		

