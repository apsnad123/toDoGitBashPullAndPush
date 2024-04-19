package com.crm.CAH.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailView_page {
	
	
	//Declaration
	@FindBy(xpath = "//td[@class='dvtTabCache']/input[@class='crmbutton small edit']" )
	private WebElement editButton;
	
	@FindBy(xpath = "//td[@class='dvtTabCache']/input[@name='Duplicate']" )
	private WebElement duplicateButton;
	
	@FindBy(xpath = "//td[@class='dvtTabCache']/input[@name='Delete']" )
	private WebElement deleteButton;
	
	
	//Initialization
	
	public  ProductDetailView_page(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}


	//Utilization
	
	public WebElement getEditButton() {
		return editButton;
	}


	public WebElement getDuplicateButton() {
		return duplicateButton;
	}


	public WebElement getDeleteButton() {
		return deleteButton;
	}

	
	//Business Libraries
	
		public void editing() {
			editButton.click();
		}
		public void duplicating() {
			duplicateButton.click();
			
		}
		public void deleting() {
			deleteButton.click();
		}
	
}
