package com.crm.CAH.Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CAH.generic_Utility.WebdriverUtility;



public class DublicatingProduct_page {
	   
	 //Declaration           	

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement save;
	
	
	//Initialization
	public  DublicatingProduct_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization

	
	public WebElement getSave() {
		return save;
	}

	//Business Libraries

	public void DublicatingProductSave() {
			save.click();

		}
	
	
		
	
	



}
