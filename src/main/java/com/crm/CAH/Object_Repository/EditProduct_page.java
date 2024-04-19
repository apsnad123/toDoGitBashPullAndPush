package com.crm.CAH.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CAH.generic_Utility.WebdriverUtility;



public class EditProduct_page {
	   
	 //Declaration           
	@FindBy(name = "productname")
	private WebElement producName;	

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement save;
	
	
	//Initialization
	public  EditProduct_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization

	public WebElement getProducName() {
		return producName;
	}

	public WebElement getSave() {
		return save;
	}

	//Business Libraries

	public void editingProductMandotoryField(WebdriverUtility wUtil,WebDriver driver,String random_product_name) {
		producName.clear();
		wUtil.sendkeys(driver, producName, random_product_name);
		save.click();

		}
	
	
		
	
	



}
