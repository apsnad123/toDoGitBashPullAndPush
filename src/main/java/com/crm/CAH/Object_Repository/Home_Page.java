package com.crm.CAH.Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CAH.generic_Utility.WebdriverUtility;

public class Home_Page {
	
	//Declaration
	
	@FindBy(xpath = "//a[.='Products']")
     private WebElement productTab;
	@FindBy(xpath="//a[.='More']")
	private WebElement moreTab;
	@FindBy (xpath = "//a[.='Campaigns']")
	private WebElement campaignsTab;
	@FindBy(xpath="//a[.='Leads']")
	private WebElement leadTab;
	@FindBy (xpath = "//a[.='Opportunities']")
	private WebElement opportunityTab;
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutpic;
	@FindBy (xpath = "//a[.='Sign Out']")
	private WebElement signoutButton;
	
	
	//Initialization
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}


	//Utilization
	public WebElement getProductTab() {
		return productTab;
	}


	public WebElement getMoreTab() {
		return moreTab;
	}


	public WebElement getCampaignsTab() {
		return campaignsTab;
	}


	public WebElement getLeadTab() {
		return leadTab;
	}


	public WebElement getOpportunityTab() {
		return opportunityTab;
	}


	public WebElement getSignoutpic() {
		return signoutpic;
	}


	public WebElement getSignoutButton() {
		return signoutButton;
	}

	
	
	//Business Libraries
	
	public void clickOnProduct() {
		productTab.click();
	}
	public void clickOnMore(WebdriverUtility wUtil, WebDriver driver) {
		wUtil.moveToElement(driver, moreTab);
	}
	public void clickOnCampaign() {
		campaignsTab.click();
	}
	public void clickOnLead() {
		leadTab.click();
	}
	public void clickOnOpportunity() {
		opportunityTab.click();
	}
	
	public void clickOnsignOut(WebDriver driver,WebdriverUtility wUtil) {
		wUtil.moveToElement(driver, signoutpic);
		signoutButton.click();
	}

}
