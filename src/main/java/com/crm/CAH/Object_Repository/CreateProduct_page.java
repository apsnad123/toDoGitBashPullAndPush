package com.crm.CAH.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CAH.generic_Utility.WebdriverUtility;

public class CreateProduct_page {
	   
	 //Declaration           
	@FindBy(name = "productname")
	private WebElement producName;	
	@FindBy(name = "productcategory")
	private WebElement productCategory;
	@FindBy(xpath  = "//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorNamelogo;
    @FindBy(id="vendor_part_no")
	private WebElement vendorPartNo;
	@FindBy(id="productsheet")
	private WebElement productSheet;
	@FindBy(name ="glacct")
	private WebElement GLAccountPath;
	@FindBy(id="productcode")
	private WebElement productCode;
	@FindBy(name ="manufacturer")
	private WebElement manufacturerDrop;
	@FindBy(name ="website")
	private WebElement website;
	@FindBy(name ="serial_no")
	private WebElement serialNo;
	@FindBy(id="tax1_check")
	private WebElement tax1Check;
	@FindBy(id="tax2_check")
	private WebElement tax2Check;
	@FindBy(id="tax3_check")
	private WebElement tax3Check;
	@FindBy(id="commissionrate")
	private WebElement commissionRate;
	@FindBy(name ="usageunit")
	private WebElement usageUnit;
	@FindBy(id="qtyinstock")
	private WebElement QtyInStock;
	@FindBy(xpath = "//input[@value='U']")
	private WebElement handler;
	@FindBy(id="qty_per_unit")
	private WebElement qtyPerUnit;
	@FindBy(id="reorderlevel")
	private WebElement reorderLevel;
	@FindBy(id="qtyindemand")
	private WebElement qtyInDemand;
	@FindBy(name ="description")
	private WebElement description;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement save;
	
	
	//Initialization
	public  CreateProduct_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getProducName() {
		return producName;
	}


	public WebElement getProductCategory() {
		return productCategory;
	}


	public WebElement getVendorNamelogo() {
		return VendorNamelogo;
	}


	public WebElement getVendorPartNo() {
		return vendorPartNo;
	}


	public WebElement getProductSheet() {
		return productSheet;
	}


	public WebElement getGLAccountPath() {
		return GLAccountPath;
	}


	public WebElement getProductCode() {
		return productCode;
	}


	public WebElement getManufacturerDrop() {
		return manufacturerDrop;
	}


	public WebElement getWebsite() {
		return website;
	}


	public WebElement getSerialNo() {
		return serialNo;
	}


	public WebElement getTax1Check() {
		return tax1Check;
	}


	public WebElement getTax2Check() {
		return tax2Check;
	}


	public WebElement getTax3Check() {
		return tax3Check;
	}


	public WebElement getCommissionRate() {
		return commissionRate;
	}


	public WebElement getUsageUnit() {
		return usageUnit;
	}


	public WebElement getQtyInStock() {
		return QtyInStock;
	}


	public WebElement getHandler() {
		return handler;
	}


	public WebElement getQtyPerUnit() {
		return qtyPerUnit;
	}


	public WebElement getReorderLevel() {
		return reorderLevel;
	}


	public WebElement getQtyInDemand() {
		return qtyInDemand;
	}


	public WebElement getDescription() {
		return description;
	}


	public WebElement getSave() {
		return save;
	}

	//Business Libraries

	public void fillingProductMandotoryField(String random_product_name,WebdriverUtility wUtil ,String Product_Category, WebDriver driver, String newWindow) {
		producName.sendKeys(random_product_name);
		wUtil.handleDropdownbyValue(productCategory, Product_Category);
		VendorNamelogo.click();
		wUtil.switchWindow(driver, newWindow);
	}
	
	
	public void fillingProductField(String Vendor_Part_No,String Product_Sheet,WebdriverUtility wUtil ,String GL_Account, String Part_Number, int no,String Website,String Serial_No,String Commission_Rate,String Usage_Unit,String Qty_in_Stock, String Qty_Unit, String Reorder_Level, String Qty_in_Demand, String Description) {
		vendorPartNo.sendKeys(Vendor_Part_No);
		productSheet.sendKeys(Product_Sheet);
		wUtil.handleDropdownbyValue(GLAccountPath, GL_Account);
		productCode.sendKeys(Part_Number);
		wUtil.handleDropdownbyIndex(manufacturerDrop, 2);
		website.sendKeys(Website);
		serialNo.sendKeys(Serial_No);
		tax1Check.click();
		tax2Check.click();
		tax3Check.click();
		commissionRate.sendKeys(Commission_Rate);
		wUtil.handleDropdownbyValue(usageUnit, Usage_Unit);
		QtyInStock.sendKeys(Qty_in_Stock);
		handler.click();
		qtyPerUnit.sendKeys(Qty_Unit);
		reorderLevel.sendKeys(Reorder_Level);
		qtyInDemand.sendKeys(Qty_in_Demand);
		description.sendKeys(Description);
		save.click();

	}
	
	



}
