package com.crm.CAH.Object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorList_page {

	
//Declaration
	@FindBy(id="search_txt")
	private WebElement vendorSearchTextbox;
	@FindBy(name="search")
	private WebElement searchBar;

	
//Initialization
	public  VendorList_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//Utilization
	public WebElement getVendorSearchTextbox() {
		return vendorSearchTextbox;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}


	
	//Business Libraries
	public void vendorWindow(String Search_Name , WebDriver driver) {
		vendorSearchTextbox.sendKeys(Search_Name);
		searchBar.click();
      driver.findElement(By.xpath("//tr/td/a[.='"+Search_Name+"']")).click();


	}
	
	
	




}
