package com.coxautoinc.sfdc.buform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuFormSelector {
	private By selectBuOpportunityRequest;
	private By selectRequestType;
	private By selectSaleType;
	private By selectSearchOpp;
	private By selectBuOpportunity;
	private By selectSaleStatus;
	private By selectProductGroup;
	private By selectProduct;
	private By specialInstructions;
	private By selectAllBtn;
	private By backToOpportunityBtn;
	private By appltToAccountsBtn;
	private By saveAndAddProductBtn;
	private By saveAndReviewBtn;
	private By FindAccBtn;

	public By getSelectBuOpportunityRequest() {
		return selectBuOpportunityRequest;
	}

	public By getSelectRequestType() {
		return selectRequestType;
	}

	public By getSelectSaleType() {
		return selectSaleType;
	}
	public By getSearchOpp() {
		return selectSearchOpp;
	}
	public By getSelectBuOpportunity() {
		return selectBuOpportunity;
	}

	public By getSelectProductGroup() {
		return selectProductGroup;
	}
	
	@FindBy (id="phSearchButton")
	public WebElement searchBtn;

	
	
	public By getSelectSaleStatus() {
		return selectSaleStatus;
	}

	public By getSelectProduct() {
		return selectProduct;
	}

	public By getSpecialInstructions() {
		return specialInstructions;
	}

	public By getSelectAllBtn() {
		return selectAllBtn;
	}

	public By getBackToOpportunityBtn() {
		return backToOpportunityBtn;
	}

	public By getAppltToAccountsBtn() {
		return appltToAccountsBtn;
	}

	public By getSaveAndAddProductBtn() {
		return saveAndAddProductBtn;
	}

	public By getSaveAndReviewBtn() {
		return saveAndReviewBtn;
	}

	public By getFindAccBtn() {
		return FindAccBtn;
	}

	private void init() {
		selectBuOpportunityRequest = By.name("bu_opportunity_request");
		selectRequestType = By.xpath("//*[@id=\"44:0\"]");
		selectSaleType = By.xpath("//*[@id=\"83:0\"]");
		selectSearchOpp = By.id("phSearchInput");
		selectBuOpportunity =By.xpath("//*[@id=\"Opportunity_body\"]/table/tbody/tr[2]");
		//need to work
		selectProductGroup = By.id("00Nj000000C1bRK");
		selectSaleStatus = By.id("00Nj000000C14OY");
		selectProduct = By.id("00Nj000000C1bRJ");
		specialInstructions = By.id("CF00Nj000000C14Ty");
		selectAllBtn = By.id("00Nj000000C1bRI");
		backToOpportunityBtn = By.id("00Nj000000C1bRN_unselected");
		appltToAccountsBtn = By.xpath("//a[@title = 'Add']");
		saveAndAddProductBtn = By.id("00Nj000000C1bRH");
		saveAndReviewBtn = By.id("00Nj000000C1bRG");
		FindAccBtn = By.id("00Nj000000C1bRL");

	}
}
