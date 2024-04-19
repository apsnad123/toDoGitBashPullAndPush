package com.crm.CAH.Object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CAH.generic_Utility.WebdriverUtility;

public class ProductList_page {

	
	//Declaration
	
	@FindBy(xpath = "//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")
	private WebElement createProductLogo;


   @FindBy(name="search_text")
   private WebElement searchTextBox;
 
   @FindBy(id="bas_searchfield")
   private WebElement typeOfProductSearch;

   @FindBy(name="submit")
   private WebElement searchButton;

   @FindBy(xpath = "//td/a[@title='Products']")
   private WebElement productList;
   
   


   //Initialization
   
   public  ProductList_page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

   //Utilization
public WebElement getCreateProductLogo() {
	return createProductLogo;
}

public WebElement getSearchTextBox() {
	return searchTextBox;
}

public WebElement getTypeOfProductSearch() {
	return typeOfProductSearch;
}

public WebElement getSearchButton() {
	return searchButton;
}

public WebElement getProductList() {
	return productList;
}




//Business Libraries

public void productLogo() {
	createProductLogo.click();
}
   
public void validateTheProduct(String random_product_name,WebdriverUtility wUtil,WebDriver driver, String In) {
	searchTextBox.sendKeys(random_product_name);
	wUtil.handleDropdownbyVisibleText(typeOfProductSearch, In);
	searchButton.click();
	
	
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}