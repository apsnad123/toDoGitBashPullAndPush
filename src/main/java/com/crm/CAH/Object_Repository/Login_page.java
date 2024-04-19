package com.crm.CAH.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	
	//Declaration
	@FindBy(xpath ="//input[@name='user_name']")
	private WebElement usernametxt;
	
	@FindBy(name="user_password")
	private WebElement passwordtxt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Initialization
	
	public Login_page(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);		
	}

	
	//Utilization
	
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Libraries
	
	/**
	 * login to application with username and password and click on save btn
	 * @param username
	 * @param password 
	 */
	public void loginToApp(String username,String password) {
		usernametxt.sendKeys(username);
		passwordtxt.sendKeys(password);
		loginBtn.submit();
		
	}

	
	
	
	
	
	
		
	}

